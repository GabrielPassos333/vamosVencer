package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Disciplina;
import com.fatec.vamosVencer.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaService disciplinaService;

    @GetMapping
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Integer id) {
        Optional<Disciplina> disciplina = disciplinaService.findById(id);
        return disciplina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = disciplinaService.save(disciplina);
        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        if (!disciplinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        disciplina.setCodDisciplina(id);
        Disciplina disciplinaAtualizada = disciplinaService.save(disciplina);
        return ResponseEntity.ok(disciplinaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Integer id) {
        if (!disciplinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        disciplinaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}