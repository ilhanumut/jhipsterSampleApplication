package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.HopFinansalHareket;
import io.github.jhipster.application.service.HopFinansalHareketService;
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
 * REST controller for managing HopFinansalHareket.
 */
@RestController
@RequestMapping("/api")
public class HopFinansalHareketResource {

    private final Logger log = LoggerFactory.getLogger(HopFinansalHareketResource.class);

    private static final String ENTITY_NAME = "hopFinansalHareket";

    private final HopFinansalHareketService hopFinansalHareketService;

    public HopFinansalHareketResource(HopFinansalHareketService hopFinansalHareketService) {
        this.hopFinansalHareketService = hopFinansalHareketService;
    }

    /**
     * POST  /hop-finansal-harekets : Create a new hopFinansalHareket.
     *
     * @param hopFinansalHareket the hopFinansalHareket to create
     * @return the ResponseEntity with status 201 (Created) and with body the new hopFinansalHareket, or with status 400 (Bad Request) if the hopFinansalHareket has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/hop-finansal-harekets")
    @Timed
    public ResponseEntity<HopFinansalHareket> createHopFinansalHareket(@RequestBody HopFinansalHareket hopFinansalHareket) throws URISyntaxException {
        log.debug("REST request to save HopFinansalHareket : {}", hopFinansalHareket);
        if (hopFinansalHareket.getId() != null) {
            throw new BadRequestAlertException("A new hopFinansalHareket cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HopFinansalHareket result = hopFinansalHareketService.save(hopFinansalHareket);
        return ResponseEntity.created(new URI("/api/hop-finansal-harekets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /hop-finansal-harekets : Updates an existing hopFinansalHareket.
     *
     * @param hopFinansalHareket the hopFinansalHareket to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated hopFinansalHareket,
     * or with status 400 (Bad Request) if the hopFinansalHareket is not valid,
     * or with status 500 (Internal Server Error) if the hopFinansalHareket couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/hop-finansal-harekets")
    @Timed
    public ResponseEntity<HopFinansalHareket> updateHopFinansalHareket(@RequestBody HopFinansalHareket hopFinansalHareket) throws URISyntaxException {
        log.debug("REST request to update HopFinansalHareket : {}", hopFinansalHareket);
        if (hopFinansalHareket.getId() == null) {
            return createHopFinansalHareket(hopFinansalHareket);
        }
        HopFinansalHareket result = hopFinansalHareketService.save(hopFinansalHareket);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, hopFinansalHareket.getId().toString()))
            .body(result);
    }

    /**
     * GET  /hop-finansal-harekets : get all the hopFinansalHarekets.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of hopFinansalHarekets in body
     */
    @GetMapping("/hop-finansal-harekets")
    @Timed
    public ResponseEntity<List<HopFinansalHareket>> getAllHopFinansalHarekets(Pageable pageable) {
        log.debug("REST request to get a page of HopFinansalHarekets");
        Page<HopFinansalHareket> page = hopFinansalHareketService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/hop-finansal-harekets");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /hop-finansal-harekets/:id : get the "id" hopFinansalHareket.
     *
     * @param id the id of the hopFinansalHareket to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the hopFinansalHareket, or with status 404 (Not Found)
     */
    @GetMapping("/hop-finansal-harekets/{id}")
    @Timed
    public ResponseEntity<HopFinansalHareket> getHopFinansalHareket(@PathVariable Long id) {
        log.debug("REST request to get HopFinansalHareket : {}", id);
        HopFinansalHareket hopFinansalHareket = hopFinansalHareketService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(hopFinansalHareket));
    }

    /**
     * DELETE  /hop-finansal-harekets/:id : delete the "id" hopFinansalHareket.
     *
     * @param id the id of the hopFinansalHareket to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/hop-finansal-harekets/{id}")
    @Timed
    public ResponseEntity<Void> deleteHopFinansalHareket(@PathVariable Long id) {
        log.debug("REST request to delete HopFinansalHareket : {}", id);
        hopFinansalHareketService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
