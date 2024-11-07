package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.AgendaSala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface AgendaSalaRepository
 */
@Repository
public interface AgendaSalaRepository extends JpaRepository<AgendaSala, Integer> {
}
