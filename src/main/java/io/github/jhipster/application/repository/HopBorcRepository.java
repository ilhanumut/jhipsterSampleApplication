package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.HopBorc;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the HopBorc entity.
 */
@SuppressWarnings("unused")
@Repository
public interface HopBorcRepository extends JpaRepository<HopBorc, Long> {

}
