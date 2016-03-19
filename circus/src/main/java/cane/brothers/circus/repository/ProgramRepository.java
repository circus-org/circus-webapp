package cane.brothers.circus.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cane.brothers.circus.domain.Program;

public interface ProgramRepository extends JpaRepository<Program, Long> {

}
