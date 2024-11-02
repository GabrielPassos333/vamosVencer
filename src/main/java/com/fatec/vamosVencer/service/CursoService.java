package com.fatec.vamosVencer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fatec.vamosVencer.entity.Curso;
import com.fatec.vamosVencer.repository.CursoRepository;

import java.util.List;
import java.util.Optional;

/**
 * Classe CursoService
 */
@Service
public class CursoService {

    /**
     * Atributo cursoRepository
     */
    @Autowired
    private CursoRepository cursoRepository;

    /**
     * Método findAll do CursoService
     */
    public List<Curso> findAll() {
        return cursoRepository.findAll();
    }

    /**
     * Método findById do CursoService
     */
    public Optional<Curso> findById(Integer id) {
        return cursoRepository.findById(id);
    }

    /**
     * Método save do CursoService
     */
    public Curso save(Curso curso) {
        return cursoRepository.save(curso);
    }
    
    /**
     * Método deleteById do CursoService
     */
    public void deleteById(Integer id) {
        cursoRepository.deleteById(id);
    }
}