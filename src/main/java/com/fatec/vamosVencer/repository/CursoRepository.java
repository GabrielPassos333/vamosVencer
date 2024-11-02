package com.fatec.vamosVencer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.vamosVencer.entity.Curso;

/**
 * Interface CursoRepository
 */
@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer> {
}