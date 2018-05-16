package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopDosya;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopDosya.
 */
public interface HopDosyaService {

    /**
     * Save a hopDosya.
     *
     * @param hopDosya the entity to save
     * @return the persisted entity
     */
    HopDosya save(HopDosya hopDosya);

    /**
     * Get all the hopDosyas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopDosya> findAll(Pageable pageable);

    /**
     * Get the "id" hopDosya.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopDosya findOne(Long id);

    /**
     * Delete the "id" hopDosya.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
