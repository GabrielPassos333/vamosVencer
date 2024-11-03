package com.fatec.vamosVencer.repository;

import com.fatec.vamosVencer.entity.Secretaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretariaRepository extends JpaRepository<Secretaria, Integer> {
}
