package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface TurmaRepository
 */
@Repository
public interface TurmaRepository extends JpaRepository<Turma, Integer> {
}
