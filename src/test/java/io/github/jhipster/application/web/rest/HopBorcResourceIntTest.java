package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.JhipsterSampleApplicationApp;

import io.github.jhipster.application.domain.HopBorc;
import io.github.jhipster.application.repository.HopBorcRepository;
import io.github.jhipster.application.service.HopBorcService;
import io.github.jhipster.application.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static io.github.jhipster.application.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import io.github.jhipster.application.domain.enumeration.EnmBorcTipi;
/**
 * Test class for the HopBorcResource REST controller.
 *
 * @see HopBorcResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class HopBorcResourceIntTest {

    private static final String DEFAULT_KOD = "AAAAAAAAAA";
    private static final String UPDATED_KOD = "BBBBBBBBBB";

    private static final BigDecimal DEFAULT_TUTAR = new BigDecimal(1);
    private static final BigDecimal UPDATED_TUTAR = new BigDecimal(2);

    private static final EnmBorcTipi DEFAULT_BORC_TIPI = EnmBorcTipi.FATURA;
    private static final EnmBorcTipi UPDATED_BORC_TIPI = EnmBorcTipi.URUN;

    private static final LocalDate DEFAULT_TARIH = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_TARIH = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private HopBorcRepository hopBorcRepository;

    @Autowired
    private HopBorcService hopBorcService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restHopBorcMockMvc;

    private HopBorc hopBorc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final HopBorcResource hopBorcResource = new HopBorcResource(hopBorcService);
        this.restHopBorcMockMvc = MockMvcBuilders.standaloneSetup(hopBorcResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static HopBorc createEntity(EntityManager em) {
        HopBorc hopBorc = new HopBorc()
            .kod(DEFAULT_KOD)
            .tutar(DEFAULT_TUTAR)
            .borcTipi(DEFAULT_BORC_TIPI)
            .tarih(DEFAULT_TARIH);
        return hopBorc;
    }

    @Before
    public void initTest() {
        hopBorc = createEntity(em);
    }

    @Test
    @Transactional
    public void createHopBorc() throws Exception {
        int databaseSizeBeforeCreate = hopBorcRepository.findAll().size();

        // Create the HopBorc
        restHopBorcMockMvc.perform(post("/api/hop-borcs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hopBorc)))
            .andExpect(status().isCreated());

        // Validate the HopBorc in the database
        List<HopBorc> hopBorcList = hopBorcRepository.findAll();
        assertThat(hopBorcList).hasSize(databaseSizeBeforeCreate + 1);
        HopBorc testHopBorc = hopBorcList.get(hopBorcList.size() - 1);
        assertThat(testHopBorc.getKod()).isEqualTo(DEFAULT_KOD);
        assertThat(testHopBorc.getTutar()).isEqualTo(DEFAULT_TUTAR);
        assertThat(testHopBorc.getBorcTipi()).isEqualTo(DEFAULT_BORC_TIPI);
        assertThat(testHopBorc.getTarih()).isEqualTo(DEFAULT_TARIH);
    }

    @Test
    @Transactional
    public void createHopBorcWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = hopBorcRepository.findAll().size();

        // Create the HopBorc with an existing ID
        hopBorc.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restHopBorcMockMvc.perform(post("/api/hop-borcs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hopBorc)))
            .andExpect(status().isBadRequest());

        // Validate the HopBorc in the database
        List<HopBorc> hopBorcList = hopBorcRepository.findAll();
        assertThat(hopBorcList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllHopBorcs() throws Exception {
        // Initialize the database
        hopBorcRepository.saveAndFlush(hopBorc);

        // Get all the hopBorcList
        restHopBorcMockMvc.perform(get("/api/hop-borcs?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(hopBorc.getId().intValue())))
            .andExpect(jsonPath("$.[*].kod").value(hasItem(DEFAULT_KOD.toString())))
            .andExpect(jsonPath("$.[*].tutar").value(hasItem(DEFAULT_TUTAR.intValue())))
            .andExpect(jsonPath("$.[*].borcTipi").value(hasItem(DEFAULT_BORC_TIPI.toString())))
            .andExpect(jsonPath("$.[*].tarih").value(hasItem(DEFAULT_TARIH.toString())));
    }

    @Test
    @Transactional
    public void getHopBorc() throws Exception {
        // Initialize the database
        hopBorcRepository.saveAndFlush(hopBorc);

        // Get the hopBorc
        restHopBorcMockMvc.perform(get("/api/hop-borcs/{id}", hopBorc.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(hopBorc.getId().intValue()))
            .andExpect(jsonPath("$.kod").value(DEFAULT_KOD.toString()))
            .andExpect(jsonPath("$.tutar").value(DEFAULT_TUTAR.intValue()))
            .andExpect(jsonPath("$.borcTipi").value(DEFAULT_BORC_TIPI.toString()))
            .andExpect(jsonPath("$.tarih").value(DEFAULT_TARIH.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingHopBorc() throws Exception {
        // Get the hopBorc
        restHopBorcMockMvc.perform(get("/api/hop-borcs/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateHopBorc() throws Exception {
        // Initialize the database
        hopBorcService.save(hopBorc);

        int databaseSizeBeforeUpdate = hopBorcRepository.findAll().size();

        // Update the hopBorc
        HopBorc updatedHopBorc = hopBorcRepository.findOne(hopBorc.getId());
        // Disconnect from session so that the updates on updatedHopBorc are not directly saved in db
        em.detach(updatedHopBorc);
        updatedHopBorc
            .kod(UPDATED_KOD)
            .tutar(UPDATED_TUTAR)
            .borcTipi(UPDATED_BORC_TIPI)
            .tarih(UPDATED_TARIH);

        restHopBorcMockMvc.perform(put("/api/hop-borcs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedHopBorc)))
            .andExpect(status().isOk());

        // Validate the HopBorc in the database
        List<HopBorc> hopBorcList = hopBorcRepository.findAll();
        assertThat(hopBorcList).hasSize(databaseSizeBeforeUpdate);
        HopBorc testHopBorc = hopBorcList.get(hopBorcList.size() - 1);
        assertThat(testHopBorc.getKod()).isEqualTo(UPDATED_KOD);
        assertThat(testHopBorc.getTutar()).isEqualTo(UPDATED_TUTAR);
        assertThat(testHopBorc.getBorcTipi()).isEqualTo(UPDATED_BORC_TIPI);
        assertThat(testHopBorc.getTarih()).isEqualTo(UPDATED_TARIH);
    }

    @Test
    @Transactional
    public void updateNonExistingHopBorc() throws Exception {
        int databaseSizeBeforeUpdate = hopBorcRepository.findAll().size();

        // Create the HopBorc

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restHopBorcMockMvc.perform(put("/api/hop-borcs")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(hopBorc)))
            .andExpect(status().isCreated());

        // Validate the HopBorc in the database
        List<HopBorc> hopBorcList = hopBorcRepository.findAll();
        assertThat(hopBorcList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteHopBorc() throws Exception {
        // Initialize the database
        hopBorcService.save(hopBorc);

        int databaseSizeBeforeDelete = hopBorcRepository.findAll().size();

        // Get the hopBorc
        restHopBorcMockMvc.perform(delete("/api/hop-borcs/{id}", hopBorc.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<HopBorc> hopBorcList = hopBorcRepository.findAll();
        assertThat(hopBorcList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(HopBorc.class);
        HopBorc hopBorc1 = new HopBorc();
        hopBorc1.setId(1L);
        HopBorc hopBorc2 = new HopBorc();
        hopBorc2.setId(hopBorc1.getId());
        assertThat(hopBorc1).isEqualTo(hopBorc2);
        hopBorc2.setId(2L);
        assertThat(hopBorc1).isNotEqualTo(hopBorc2);
        hopBorc1.setId(null);
        assertThat(hopBorc1).isNotEqualTo(hopBorc2);
    }
}
