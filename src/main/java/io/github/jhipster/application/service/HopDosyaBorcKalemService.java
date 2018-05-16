package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopDosyaBorcKalem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopDosyaBorcKalem.
 */
public interface HopDosyaBorcKalemService {

    /**
     * Save a hopDosyaBorcKalem.
     *
     * @param hopDosyaBorcKalem the entity to save
     * @return the persisted entity
     */
    HopDosyaBorcKalem save(HopDosyaBorcKalem hopDosyaBorcKalem);

    /**
     * Get all the hopDosyaBorcKalems.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopDosyaBorcKalem> findAll(Pageable pageable);

    /**
     * Get the "id" hopDosyaBorcKalem.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopDosyaBorcKalem findOne(Long id);

    /**
     * Delete the "id" hopDosyaBorcKalem.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
