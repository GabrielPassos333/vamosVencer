package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Secretaria;
import com.fatec.vamosVencer.service.SecretariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/secretarias")
public class SecretariaController {

    @Autowired
    private SecretariaService secretariaService;

    @GetMapping
    public List<Secretaria> getAllSecretarias() {
        return secretariaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Secretaria> getSecretariaById(@PathVariable Integer id) {
        Optional<Secretaria> secretaria = secretariaService.findById(id);
        return secretaria.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Secretaria> createSecretaria(@RequestBody Secretaria secretaria) {
        Secretaria novaSecretaria = secretariaService.save(secretaria);
        return new ResponseEntity<>(novaSecretaria, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Secretaria> updateSecretaria(@PathVariable Integer id, @RequestBody Secretaria secretaria) {
        if (!secretariaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        secretaria.setMatriculaSecretaria(id);
        Secretaria secretariaAtualizada = secretariaService.save(secretaria);
        return ResponseEntity.ok(secretariaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSecretaria(@PathVariable Integer id) {
        if (!secretariaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        secretariaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
