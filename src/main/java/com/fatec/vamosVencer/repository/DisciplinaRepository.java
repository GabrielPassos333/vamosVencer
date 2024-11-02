package com.fatec.vamosVencer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatec.vamosVencer.entity.Disciplina;

/**
 * Interface DisciplinaRepository
 */
@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {
}