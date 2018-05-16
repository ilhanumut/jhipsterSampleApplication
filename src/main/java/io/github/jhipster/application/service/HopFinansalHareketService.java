package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopFinansalHareket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopFinansalHareket.
 */
public interface HopFinansalHareketService {

    /**
     * Save a hopFinansalHareket.
     *
     * @param hopFinansalHareket the entity to save
     * @return the persisted entity
     */
    HopFinansalHareket save(HopFinansalHareket hopFinansalHareket);

    /**
     * Get all the hopFinansalHarekets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopFinansalHareket> findAll(Pageable pageable);

    /**
     * Get the "id" hopFinansalHareket.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopFinansalHareket findOne(Long id);

    /**
     * Delete the "id" hopFinansalHareket.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
