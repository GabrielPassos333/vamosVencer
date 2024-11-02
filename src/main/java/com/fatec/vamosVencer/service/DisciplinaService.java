package com.fatec.vamosVencer.service;


import com.fatec.vamosVencer.entity.Disciplina;
import com.fatec.vamosVencer.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DisciplinaService {

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    public Optional<Disciplina> findById(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    public void deleteById(Integer id) {
        disciplinaRepository.deleteById(id);
    }
}