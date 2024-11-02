package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Curriculo;
import com.fatec.vamosVencer.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Classe CurriculoService
 */
@Service
public class CurriculoService {

    /**
     * Atributo curriculoRepository
     */
    @Autowired
    private CurriculoRepository curriculoRepository;

    /**
     * Método findAll do CurriculoService
     */
    public List<Curriculo> findAll() {
        return curriculoRepository.findAll();
    }

    /**
     * Método findById do CurriculoService
     */
    public Optional<Curriculo> findById(Integer id) {
        return curriculoRepository.findById(id);
    }

    /**
     * Método save do CurriculoService
     */
    public Curriculo save(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    /**
     * Método deleteById do CurriculoService
     */
    public void deleteById(Integer id) {
        curriculoRepository.deleteById(id);
    }
}
