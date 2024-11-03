package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Sala;
import com.fatec.vamosVencer.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaService {

    @Autowired
    private SalaRepository salaRepository;

    public List<Sala> findAll() {
        return salaRepository.findAll();
    }

    public Optional<Sala> findById(Integer id) {
        return salaRepository.findById(id);
    }

    public Sala save(Sala sala) {
        return salaRepository.save(sala);
    }

    public void deleteById(Integer id) {
        salaRepository.deleteById(id);
    }
}
