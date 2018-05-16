package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopDosyaBorcKalemService;
import io.github.jhipster.application.domain.HopDosyaBorcKalem;
import io.github.jhipster.application.repository.HopDosyaBorcKalemRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopDosyaBorcKalem.
 */
@Service
@Transactional
public class HopDosyaBorcKalemServiceImpl implements HopDosyaBorcKalemService {

    private final Logger log = LoggerFactory.getLogger(HopDosyaBorcKalemServiceImpl.class);

    private final HopDosyaBorcKalemRepository hopDosyaBorcKalemRepository;

    public HopDosyaBorcKalemServiceImpl(HopDosyaBorcKalemRepository hopDosyaBorcKalemRepository) {
        this.hopDosyaBorcKalemRepository = hopDosyaBorcKalemRepository;
    }

    /**
     * Save a hopDosyaBorcKalem.
     *
     * @param hopDosyaBorcKalem the entity to save
     * @return the persisted entity
     */
    @Override
    public HopDosyaBorcKalem save(HopDosyaBorcKalem hopDosyaBorcKalem) {
        log.debug("Request to save HopDosyaBorcKalem : {}", hopDosyaBorcKalem);
        return hopDosyaBorcKalemRepository.save(hopDosyaBorcKalem);
    }

    /**
     * Get all the hopDosyaBorcKalems.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopDosyaBorcKalem> findAll(Pageable pageable) {
        log.debug("Request to get all HopDosyaBorcKalems");
        return hopDosyaBorcKalemRepository.findAll(pageable);
    }

    /**
     * Get one hopDosyaBorcKalem by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopDosyaBorcKalem findOne(Long id) {
        log.debug("Request to get HopDosyaBorcKalem : {}", id);
        return hopDosyaBorcKalemRepository.findOne(id);
    }

    /**
     * Delete the hopDosyaBorcKalem by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopDosyaBorcKalem : {}", id);
        hopDosyaBorcKalemRepository.delete(id);
    }
}
