package com.fatec.vamosVencer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.vamosVencer.entity.Professor;

/**
 * Interface ProfessorRepository
 */
@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}