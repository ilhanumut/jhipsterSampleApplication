package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopDosyaService;
import io.github.jhipster.application.domain.HopDosya;
import io.github.jhipster.application.repository.HopDosyaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopDosya.
 */
@Service
@Transactional
public class HopDosyaServiceImpl implements HopDosyaService {

    private final Logger log = LoggerFactory.getLogger(HopDosyaServiceImpl.class);

    private final HopDosyaRepository hopDosyaRepository;

    public HopDosyaServiceImpl(HopDosyaRepository hopDosyaRepository) {
        this.hopDosyaRepository = hopDosyaRepository;
    }

    /**
     * Save a hopDosya.
     *
     * @param hopDosya the entity to save
     * @return the persisted entity
     */
    @Override
    public HopDosya save(HopDosya hopDosya) {
        log.debug("Request to save HopDosya : {}", hopDosya);
        return hopDosyaRepository.save(hopDosya);
    }

    /**
     * Get all the hopDosyas.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopDosya> findAll(Pageable pageable) {
        log.debug("Request to get all HopDosyas");
        return hopDosyaRepository.findAll(pageable);
    }

    /**
     * Get one hopDosya by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopDosya findOne(Long id) {
        log.debug("Request to get HopDosya : {}", id);
        return hopDosyaRepository.findOne(id);
    }

    /**
     * Delete the hopDosya by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopDosya : {}", id);
        hopDosyaRepository.delete(id);
    }
}
