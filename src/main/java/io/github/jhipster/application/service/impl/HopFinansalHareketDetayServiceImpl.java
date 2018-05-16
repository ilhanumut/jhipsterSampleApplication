package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.HopFinansalHareketDetayService;
import io.github.jhipster.application.domain.HopFinansalHareketDetay;
import io.github.jhipster.application.repository.HopFinansalHareketDetayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing HopFinansalHareketDetay.
 */
@Service
@Transactional
public class HopFinansalHareketDetayServiceImpl implements HopFinansalHareketDetayService {

    private final Logger log = LoggerFactory.getLogger(HopFinansalHareketDetayServiceImpl.class);

    private final HopFinansalHareketDetayRepository hopFinansalHareketDetayRepository;

    public HopFinansalHareketDetayServiceImpl(HopFinansalHareketDetayRepository hopFinansalHareketDetayRepository) {
        this.hopFinansalHareketDetayRepository = hopFinansalHareketDetayRepository;
    }

    /**
     * Save a hopFinansalHareketDetay.
     *
     * @param hopFinansalHareketDetay the entity to save
     * @return the persisted entity
     */
    @Override
    public HopFinansalHareketDetay save(HopFinansalHareketDetay hopFinansalHareketDetay) {
        log.debug("Request to save HopFinansalHareketDetay : {}", hopFinansalHareketDetay);
        return hopFinansalHareketDetayRepository.save(hopFinansalHareketDetay);
    }

    /**
     * Get all the hopFinansalHareketDetays.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<HopFinansalHareketDetay> findAll(Pageable pageable) {
        log.debug("Request to get all HopFinansalHareketDetays");
        return hopFinansalHareketDetayRepository.findAll(pageable);
    }

    /**
     * Get one hopFinansalHareketDetay by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public HopFinansalHareketDetay findOne(Long id) {
        log.debug("Request to get HopFinansalHareketDetay : {}", id);
        return hopFinansalHareketDetayRepository.findOne(id);
    }

    /**
     * Delete the hopFinansalHareketDetay by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete HopFinansalHareketDetay : {}", id);
        hopFinansalHareketDetayRepository.delete(id);
    }
}
