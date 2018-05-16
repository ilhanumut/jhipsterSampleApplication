package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopBorcService;
import io.github.jhipster.application.domain.HopBorc;
import io.github.jhipster.application.repository.HopBorcRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopBorc.
 */
@Service
@Transactional
public class HopBorcServiceImpl implements HopBorcService {

    private final Logger log = LoggerFactory.getLogger(HopBorcServiceImpl.class);

    private final HopBorcRepository hopBorcRepository;

    public HopBorcServiceImpl(HopBorcRepository hopBorcRepository) {
        this.hopBorcRepository = hopBorcRepository;
    }

    /**
     * Save a hopBorc.
     *
     * @param hopBorc the entity to save
     * @return the persisted entity
     */
    @Override
    public HopBorc save(HopBorc hopBorc) {
        log.debug("Request to save HopBorc : {}", hopBorc);
        return hopBorcRepository.save(hopBorc);
    }

    /**
     * Get all the hopBorcs.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopBorc> findAll(Pageable pageable) {
        log.debug("Request to get all HopBorcs");
        return hopBorcRepository.findAll(pageable);
    }

    /**
     * Get one hopBorc by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopBorc findOne(Long id) {
        log.debug("Request to get HopBorc : {}", id);
        return hopBorcRepository.findOne(id);
    }

    /**
     * Delete the hopBorc by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopBorc : {}", id);
        hopBorcRepository.delete(id);
    }
}
