package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Disciplina;
import com.fatec.vamosVencer.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe DisciplinaService
 */
@Service
public class DisciplinaService {

    /**
     * Atributo disciplinaRepository
     */
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    /**
     * Método findAll do DisciplinaService
     */
    public List<Disciplina> findAll() {
        return disciplinaRepository.findAll();
    }

    /**
     * Método findById do DisciplinaService
     */
    public Optional<Disciplina> findById(Integer id) {
        return disciplinaRepository.findById(id);
    }

    /**
     * Método save do DisciplinaService
     */
    public Disciplina save(Disciplina disciplina) {
        return disciplinaRepository.save(disciplina);
    }

    /**
     * Método deleteById do DisciplinaService
     */
    public void deleteById(Integer id) {
        disciplinaRepository.deleteById(id);
    }
}