package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.HopDosya;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the HopDosya entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HopDosyaRepository extends JpaRepository<HopDosya, Long> {

}
