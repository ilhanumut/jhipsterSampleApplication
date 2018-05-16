package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopFinansalHareketService;
import io.github.jhipster.application.domain.HopFinansalHareket;
import io.github.jhipster.application.repository.HopFinansalHareketRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopFinansalHareket.
 */
@Service
@Transactional
public class HopFinansalHareketServiceImpl implements HopFinansalHareketService {

    private final Logger log = LoggerFactory.getLogger(HopFinansalHareketServiceImpl.class);

    private final HopFinansalHareketRepository hopFinansalHareketRepository;

    public HopFinansalHareketServiceImpl(HopFinansalHareketRepository hopFinansalHareketRepository) {
        this.hopFinansalHareketRepository = hopFinansalHareketRepository;
    }

    /**
     * Save a hopFinansalHareket.
     *
     * @param hopFinansalHareket the entity to save
     * @return the persisted entity
     */
    @Override
    public HopFinansalHareket save(HopFinansalHareket hopFinansalHareket) {
        log.debug("Request to save HopFinansalHareket : {}", hopFinansalHareket);
        return hopFinansalHareketRepository.save(hopFinansalHareket);
    }

    /**
     * Get all the hopFinansalHarekets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopFinansalHareket> findAll(Pageable pageable) {
        log.debug("Request to get all HopFinansalHarekets");
        return hopFinansalHareketRepository.findAll(pageable);
    }

    /**
     * Get one hopFinansalHareket by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopFinansalHareket findOne(Long id) {
        log.debug("Request to get HopFinansalHareket : {}", id);
        return hopFinansalHareketRepository.findOne(id);
    }

    /**
     * Delete the hopFinansalHareket by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopFinansalHareket : {}", id);
        hopFinansalHareketRepository.delete(id);
    }
}
