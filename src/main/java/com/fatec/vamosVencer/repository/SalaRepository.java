package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface SalaRepository
 */
@Repository
public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
