package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Sala;
import com.fatec.vamosVencer.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar as requisições referentes a Sala
 */
@RestController
@RequestMapping("/salas")
public class SalaController {

    /**
     * Atributo salaService do tipo SalaService
     */
    @Autowired
    private SalaService salaService;

    /**
     * Método para listar todas as salas
     * @return List<Sala>
     */
    @GetMapping
    public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    /**
     * Método para buscar uma sala pelo id
     * @param id do tipo Integer
     * @return ResponseEntity<Sala>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Integer id) {
        Optional<Sala> sala = salaService.findById(id);
        return sala.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para criar uma nova sala
     * @param sala do tipo Sala
     * @return ResponseEntity<Sala>
     */
    @PostMapping
    public ResponseEntity<Sala> createSala(@RequestBody Sala sala) {
        Sala novaSala = salaService.save(sala);
        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
    }

    /**
     * Método para atualizar uma sala
     * @param id do tipo Integer
     * @param sala do tipo Sala
     * @return ResponseEntity<Sala>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Integer id, @RequestBody Sala sala) {
        if (!salaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sala.setCodSala(id);
        Sala salaAtualizada = salaService.save(sala);
        return ResponseEntity.ok(salaAtualizada);
    }

    /**
     * Método para deletar uma sala
     * @param id do tipo Integer
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Integer id) {
        if (!salaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
