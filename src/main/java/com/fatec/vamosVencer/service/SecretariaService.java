package com.fatec.vamosVencer.service;

import com.fatec.vamosVencer.entity.Secretaria;
import com.fatec.vamosVencer.repository.SecretariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecretariaService {

    @Autowired
    private SecretariaRepository secretariaRepository;

    public List<Secretaria> findAll() {
        return secretariaRepository.findAll();
    }

    public Optional<Secretaria> findById(Integer id) {
        return secretariaRepository.findById(id);
    }

    public Secretaria save(Secretaria secretaria) {
        return secretariaRepository.save(secretaria);
    }

    public void deleteById(Integer id) {
        secretariaRepository.deleteById(id);
    }
}
