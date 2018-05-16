package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopDosyaBorc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopDosyaBorc.
 */
public interface HopDosyaBorcService {

    /**
     * Save a hopDosyaBorc.
     *
     * @param hopDosyaBorc the entity to save
     * @return the persisted entity
     */
    HopDosyaBorc save(HopDosyaBorc hopDosyaBorc);

    /**
     * Get all the hopDosyaBorcs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopDosyaBorc> findAll(Pageable pageable);

    /**
     * Get the "id" hopDosyaBorc.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopDosyaBorc findOne(Long id);

    /**
     * Delete the "id" hopDosyaBorc.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
