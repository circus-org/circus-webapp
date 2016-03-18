package cane.brothers.circus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.circus.domain.Troupe;

public interface TroupeRepository extends JpaRepository<Troupe, Long> {

}
