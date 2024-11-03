package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Agenda;
import com.fatec.vamosVencer.repository.AgendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgendaService {

    @Autowired
    private AgendaRepository agendaRepository;

    public List<Agenda> findAll() {
        return agendaRepository.findAll();
    }

    public Optional<Agenda> findById(Integer id) {
        return agendaRepository.findById(id);
    }

    public Agenda save(Agenda agenda) {
        return agendaRepository.save(agenda);
    }

    public void deleteById(Integer id) {
        agendaRepository.deleteById(id);
    }
}
