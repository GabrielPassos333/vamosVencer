package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Interface ReservaRepository
 */
@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
}
