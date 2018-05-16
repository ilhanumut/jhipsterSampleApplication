package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopBorc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopBorc.
 */
public interface HopBorcService {

    /**
     * Save a hopBorc.
     *
     * @param hopBorc the entity to save
     * @return the persisted entity
     */
    HopBorc save(HopBorc hopBorc);

    /**
     * Get all the hopBorcs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopBorc> findAll(Pageable pageable);

    /**
     * Get the "id" hopBorc.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopBorc findOne(Long id);

    /**
     * Delete the "id" hopBorc.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
