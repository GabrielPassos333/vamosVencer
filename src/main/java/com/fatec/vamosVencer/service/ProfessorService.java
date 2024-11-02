package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Professor;
import com.fatec.vamosVencer.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe ProfessorService
 */
@Service
public class ProfessorService {

    /**
     * Atributo professorRepository
     */
    @Autowired
    private ProfessorRepository professorRepository;

    /**
     * Método findAll do ProfessorService
     */
    public List<Professor> findAll() {
        return professorRepository.findAll();
    }

    /**
     * Método findById do ProfessorService
     */
    public Optional<Professor> findById(Integer id) {
        return professorRepository.findById(id);
    }

    /**
     * Método save do ProfessorService
     */
    public Professor save(Professor professor) {
        return professorRepository.save(professor);
    }

    /**
     * Método deleteById do ProfessorService
     */
    public void deleteById(Integer id) {
        professorRepository.deleteById(id);
    }
}
