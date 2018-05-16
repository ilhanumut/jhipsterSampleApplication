package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.HopDosya;
import io.github.jhipster.application.service.HopDosyaService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing HopDosya.
 */
@RestController
@RequestMapping("/api")
public class HopDosyaResource {

    private final Logger log = LoggerFactory.getLogger(HopDosyaResource.class);

    private static final String ENTITY_NAME = "hopDosya";

    private final HopDosyaService hopDosyaService;

    public HopDosyaResource(HopDosyaService hopDosyaService) {
        this.hopDosyaService = hopDosyaService;
    }

    /**
     * POST  /hop-dosyas : Create a new hopDosya.
     *
     * @param hopDosya the hopDosya to create
     * @return the ResponseEntity with status 201 (Created) and with body the new hopDosya, or with status 400 (Bad Request) if the hopDosya has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/hop-dosyas")
    @Timed
    public ResponseEntity<HopDosya> createHopDosya(@RequestBody HopDosya hopDosya) throws URISyntaxException {
        log.debug("REST request to save HopDosya : {}", hopDosya);
        if (hopDosya.getId() != null) {
            throw new BadRequestAlertException("A new hopDosya cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HopDosya result = hopDosyaService.save(hopDosya);
        return ResponseEntity.created(new URI("/api/hop-dosyas/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /hop-dosyas : Updates an existing hopDosya.
     *
     * @param hopDosya the hopDosya to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated hopDosya,
     * or with status 400 (Bad Request) if the hopDosya is not valid,
     * or with status 500 (Internal Server Error) if the hopDosya couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/hop-dosyas")
    @Timed
    public ResponseEntity<HopDosya> updateHopDosya(@RequestBody HopDosya hopDosya) throws URISyntaxException {
        log.debug("REST request to update HopDosya : {}", hopDosya);
        if (hopDosya.getId() == null) {
            return createHopDosya(hopDosya);
        }
        HopDosya result = hopDosyaService.save(hopDosya);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, hopDosya.getId().toString()))
            .body(result);
    }

    /**
     * GET  /hop-dosyas : get all the hopDosyas.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of hopDosyas in body
     */
    @GetMapping("/hop-dosyas")
    @Timed
    public ResponseEntity<List<HopDosya>> getAllHopDosyas(Pageable pageable) {
        log.debug("REST request to get a page of HopDosyas");
        Page<HopDosya> page = hopDosyaService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/hop-dosyas");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /hop-dosyas/:id : get the "id" hopDosya.
     *
     * @param id the id of the hopDosya to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the hopDosya, or with status 404 (Not Found)
     */
    @GetMapping("/hop-dosyas/{id}")
    @Timed
    public ResponseEntity<HopDosya> getHopDosya(@PathVariable Long id) {
        log.debug("REST request to get HopDosya : {}", id);
        HopDosya hopDosya = hopDosyaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(hopDosya));
    }

    /**
     * DELETE  /hop-dosyas/:id : delete the "id" hopDosya.
     *
     * @param id the id of the hopDosya to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/hop-dosyas/{id}")
    @Timed
    public ResponseEntity<Void> deleteHopDosya(@PathVariable Long id) {
        log.debug("REST request to delete HopDosya : {}", id);
        hopDosyaService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
