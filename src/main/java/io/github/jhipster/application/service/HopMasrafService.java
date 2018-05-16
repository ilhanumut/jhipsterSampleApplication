package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopMasraf;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopMasraf.
 */
public interface HopMasrafService {

    /**
     * Save a hopMasraf.
     *
     * @param hopMasraf the entity to save
     * @return the persisted entity
     */
    HopMasraf save(HopMasraf hopMasraf);

    /**
     * Get all the hopMasrafs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopMasraf> findAll(Pageable pageable);

    /**
     * Get the "id" hopMasraf.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopMasraf findOne(Long id);

    /**
     * Delete the "id" hopMasraf.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
