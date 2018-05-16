package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopMasrafService;
import io.github.jhipster.application.domain.HopMasraf;
import io.github.jhipster.application.repository.HopMasrafRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopMasraf.
 */
@Service
@Transactional
public class HopMasrafServiceImpl implements HopMasrafService {

    private final Logger log = LoggerFactory.getLogger(HopMasrafServiceImpl.class);

    private final HopMasrafRepository hopMasrafRepository;

    public HopMasrafServiceImpl(HopMasrafRepository hopMasrafRepository) {
        this.hopMasrafRepository = hopMasrafRepository;
    }

    /**
     * Save a hopMasraf.
     *
     * @param hopMasraf the entity to save
     * @return the persisted entity
     */
    @Override
    public HopMasraf save(HopMasraf hopMasraf) {
        log.debug("Request to save HopMasraf : {}", hopMasraf);
        return hopMasrafRepository.save(hopMasraf);
    }

    /**
     * Get all the hopMasrafs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopMasraf> findAll(Pageable pageable) {
        log.debug("Request to get all HopMasrafs");
        return hopMasrafRepository.findAll(pageable);
    }

    /**
     * Get one hopMasraf by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopMasraf findOne(Long id) {
        log.debug("Request to get HopMasraf : {}", id);
        return hopMasrafRepository.findOne(id);
    }

    /**
     * Delete the hopMasraf by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopMasraf : {}", id);
        hopMasrafRepository.delete(id);
    }
}
