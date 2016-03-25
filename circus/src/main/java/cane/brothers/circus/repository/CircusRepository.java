package cane.brothers.circus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.circus.domain.Circus;

public interface CircusRepository extends JpaRepository<Circus, Long> {

}
