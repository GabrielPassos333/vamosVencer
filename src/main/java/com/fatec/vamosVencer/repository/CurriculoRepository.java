package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.Curriculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface CurriculoRepository
 */
@Repository
public interface CurriculoRepository extends JpaRepository<Curriculo, Integer> {
}
