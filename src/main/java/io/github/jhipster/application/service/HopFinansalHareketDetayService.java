package io.github.jhipster.application.service;

import io.github.jhipster.application.domain.HopFinansalHareketDetay;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing HopFinansalHareketDetay.
 */
public interface HopFinansalHareketDetayService {

    /**
     * Save a hopFinansalHareketDetay.
     *
     * @param hopFinansalHareketDetay the entity to save
     * @return the persisted entity
     */
    HopFinansalHareketDetay save(HopFinansalHareketDetay hopFinansalHareketDetay);

    /**
     * Get all the hopFinansalHareketDetays.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<HopFinansalHareketDetay> findAll(Pageable pageable);

    /**
     * Get the "id" hopFinansalHareketDetay.
     *
     * @param id the id of the entity
     * @return the entity
     */
    HopFinansalHareketDetay findOne(Long id);

    /**
     * Delete the "id" hopFinansalHareketDetay.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
