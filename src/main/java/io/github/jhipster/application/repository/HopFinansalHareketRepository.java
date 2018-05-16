package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.HopFinansalHareket;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the HopFinansalHareket entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HopFinansalHareketRepository extends JpaRepository<HopFinansalHareket, Long> {

}
