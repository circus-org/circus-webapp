package cane.brothers.circus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.circus.domain.CircusRowSegment;

public interface CircusSegmentRepository extends JpaRepository<CircusRowSegment, Long> {

}
