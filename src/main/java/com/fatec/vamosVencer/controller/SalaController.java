package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Sala;
import com.fatec.vamosVencer.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    @Autowired
    private SalaService salaService;

    @GetMapping
    public List<Sala> getAllSalas() {
        return salaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Sala> getSalaById(@PathVariable Integer id) {
        Optional<Sala> sala = salaService.findById(id);
        return sala.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Sala> createSala(@RequestBody Sala sala) {
        Sala novaSala = salaService.save(sala);
        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Sala> updateSala(@PathVariable Integer id, @RequestBody Sala sala) {
        if (!salaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        sala.setCodSala(id);
        Sala salaAtualizada = salaService.save(sala);
        return ResponseEntity.ok(salaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSala(@PathVariable Integer id) {
        if (!salaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        salaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
