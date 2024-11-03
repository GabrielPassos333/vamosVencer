package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Turma;
import com.fatec.vamosVencer.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaService turmaService;

    @GetMapping
    public List<Turma> getAllTurmas() {
        return turmaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable Integer id) {
        Optional<Turma> turma = turmaService.findById(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        Turma novaTurma = turmaService.save(turma);
        return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        if (!turmaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        turma.setCodTurma(id);
        Turma turmaAtualizada = turmaService.save(turma);
        return ResponseEntity.ok(turmaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Integer id) {
        if (!turmaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        turmaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
