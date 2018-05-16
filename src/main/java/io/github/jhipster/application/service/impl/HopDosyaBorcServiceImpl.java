package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopDosyaBorcService;
import io.github.jhipster.application.domain.HopDosyaBorc;
import io.github.jhipster.application.repository.HopDosyaBorcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopDosyaBorc.
 */
@Service
@Transactional
public class HopDosyaBorcServiceImpl implements HopDosyaBorcService {

    private final Logger log = LoggerFactory.getLogger(HopDosyaBorcServiceImpl.class);

    private final HopDosyaBorcRepository hopDosyaBorcRepository;

    public HopDosyaBorcServiceImpl(HopDosyaBorcRepository hopDosyaBorcRepository) {
        this.hopDosyaBorcRepository = hopDosyaBorcRepository;
    }

    /**
     * Save a hopDosyaBorc.
     *
     * @param hopDosyaBorc the entity to save
     * @return the persisted entity
     */
    @Override
    public HopDosyaBorc save(HopDosyaBorc hopDosyaBorc) {
        log.debug("Request to save HopDosyaBorc : {}", hopDosyaBorc);
        return hopDosyaBorcRepository.save(hopDosyaBorc);
    }

    /**
     * Get all the hopDosyaBorcs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopDosyaBorc> findAll(Pageable pageable) {
        log.debug("Request to get all HopDosyaBorcs");
        return hopDosyaBorcRepository.findAll(pageable);
    }

    /**
     * Get one hopDosyaBorc by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopDosyaBorc findOne(Long id) {
        log.debug("Request to get HopDosyaBorc : {}", id);
        return hopDosyaBorcRepository.findOne(id);
    }

    /**
     * Delete the hopDosyaBorc by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopDosyaBorc : {}", id);
        hopDosyaBorcRepository.delete(id);
    }
}
