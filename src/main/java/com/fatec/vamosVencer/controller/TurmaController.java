package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Turma;
import com.fatec.vamosVencer.service.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar as requisições referentes a Turma
 */
@RestController
@RequestMapping("/turmas")
public class TurmaController {

    /**
     * Atributo turmaService do tipo TurmaService
     */
    @Autowired
    private TurmaService turmaService;

    /**
     * Método para listar todas as turmas
     * @return List<Turma>
     */
    @GetMapping
    public List<Turma> getAllTurmas() {
        return turmaService.findAll();
    }

    /**
     * Método para buscar uma turma pelo id
     * @param id do tipo Integer
     * @return ResponseEntity<Turma>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Turma> getTurmaById(@PathVariable Integer id) {
        Optional<Turma> turma = turmaService.findById(id);
        return turma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para criar uma nova turma
     * @param turma do tipo Turma
     * @return ResponseEntity<Turma>
     */
    @PostMapping
    public ResponseEntity<Turma> createTurma(@RequestBody Turma turma) {
        Turma novaTurma = turmaService.save(turma);
        return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
    }

    /**
     * Método para atualizar uma turma
     * @param id do tipo Integer
     * @param turma do tipo Turma
     * @return ResponseEntity<Turma>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma) {
        if (!turmaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        turma.setCodTurma(id);
        Turma turmaAtualizada = turmaService.save(turma);
        return ResponseEntity.ok(turmaAtualizada);
    }

    /**
     * Método para deletar uma turma
     * @param id do tipo Integer
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTurma(@PathVariable Integer id) {
        if (!turmaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        turmaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
