package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.HopBorc;
import io.github.jhipster.application.service.HopBorcService;
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
 * REST controller for managing HopBorc.
 */
@RestController
@RequestMapping("/api")
public class HopBorcResource {

    private final Logger log = LoggerFactory.getLogger(HopBorcResource.class);

    private static final String ENTITY_NAME = "hopBorc";

    private final HopBorcService hopBorcService;

    public HopBorcResource(HopBorcService hopBorcService) {
        this.hopBorcService = hopBorcService;
    }

    /**
     * POST  /hop-borcs : Create a new hopBorc.
     *
     * @param hopBorc the hopBorc to create
     * @return the ResponseEntity with status 201 (Created) and with body the new hopBorc, or with status 400 (Bad Request) if the hopBorc has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/hop-borcs")
    @Timed
    public ResponseEntity<HopBorc> createHopBorc(@RequestBody HopBorc hopBorc) throws URISyntaxException {
        log.debug("REST request to save HopBorc : {}", hopBorc);
        if (hopBorc.getId() != null) {
            throw new BadRequestAlertException("A new hopBorc cannot already have an ID", ENTITY_NAME, "idexists");
        }
        HopBorc result = hopBorcService.save(hopBorc);
        return ResponseEntity.created(new URI("/api/hop-borcs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /hop-borcs : Updates an existing hopBorc.
     *
     * @param hopBorc the hopBorc to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated hopBorc,
     * or with status 400 (Bad Request) if the hopBorc is not valid,
     * or with status 500 (Internal Server Error) if the hopBorc couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/hop-borcs")
    @Timed
    public ResponseEntity<HopBorc> updateHopBorc(@RequestBody HopBorc hopBorc) throws URISyntaxException {
        log.debug("REST request to update HopBorc : {}", hopBorc);
        if (hopBorc.getId() == null) {
            return createHopBorc(hopBorc);
        }
        HopBorc result = hopBorcService.save(hopBorc);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, hopBorc.getId().toString()))
            .body(result);
    }

    /**
     * GET  /hop-borcs : get all the hopBorcs.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of hopBorcs in body
     */
    @GetMapping("/hop-borcs")
    @Timed
    public ResponseEntity<List<HopBorc>> getAllHopBorcs(Pageable pageable) {
        log.debug("REST request to get a page of HopBorcs");
        Page<HopBorc> page = hopBorcService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/hop-borcs");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /hop-borcs/:id : get the "id" hopBorc.
     *
     * @param id the id of the hopBorc to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the hopBorc, or with status 404 (Not Found)
     */
    @GetMapping("/hop-borcs/{id}")
    @Timed
    public ResponseEntity<HopBorc> getHopBorc(@PathVariable Long id) {
        log.debug("REST request to get HopBorc : {}", id);
        HopBorc hopBorc = hopBorcService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(hopBorc));
    }

    /**
     * DELETE  /hop-borcs/:id : delete the "id" hopBorc.
     *
     * @param id the id of the hopBorc to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/hop-borcs/{id}")
    @Timed
    public ResponseEntity<Void> deleteHopBorc(@PathVariable Long id) {
        log.debug("REST request to delete HopBorc : {}", id);
        hopBorcService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
