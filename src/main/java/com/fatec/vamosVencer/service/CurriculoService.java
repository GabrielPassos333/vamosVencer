package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Curriculo;
import com.fatec.vamosVencer.repository.CurriculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CurriculoService {

    @Autowired
    private CurriculoRepository curriculoRepository;

    public List<Curriculo> findAll() {
        return curriculoRepository.findAll();
    }

    public Optional<Curriculo> findById(Integer id) {
        return curriculoRepository.findById(id);
    }

    public Curriculo save(Curriculo curriculo) {
        return curriculoRepository.save(curriculo);
    }

    public void deleteById(Integer id) {
        curriculoRepository.deleteById(id);
    }
}
