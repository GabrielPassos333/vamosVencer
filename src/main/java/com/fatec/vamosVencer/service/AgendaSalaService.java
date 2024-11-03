package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.AgendaSala;
import com.fatec.vamosVencer.repository.AgendaSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaSalaService {

    @Autowired
    private AgendaSalaRepository agendaSalaRepository;

    public List<AgendaSala> findAll() {
        return agendaSalaRepository.findAll();
    }

    public Optional<AgendaSala> findById(Integer id) {
        return agendaSalaRepository.findById(id);
    }

    public AgendaSala save(AgendaSala agendaSala) {
        return agendaSalaRepository.save(agendaSala);
    }

    public void deleteById(Integer id) {
        agendaSalaRepository.deleteById(id);
    }
}
