package cane.brothers.circus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.circus.domain.CircusRow;

public interface CircusRowRepository extends JpaRepository<CircusRow, Long> {

	// TODO get full capacity
}
