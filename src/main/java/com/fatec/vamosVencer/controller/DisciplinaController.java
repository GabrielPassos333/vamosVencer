package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Disciplina;
import com.fatec.vamosVencer.service.DisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para o recurso Disciplina
 */
@RestController
@RequestMapping("/disciplinas")
public class DisciplinaController {

    /**
     * Injeção de dependência para o serviço de disciplina
     */
    @Autowired
    private DisciplinaService disciplinaService;

    /**
     * Busca todas as disciplinas
     * @return lista de disciplinas
     */
    @GetMapping
    public List<Disciplina> getAllDisciplinas() {
        return disciplinaService.findAll();
    }

    /**
     * Busca uma disciplina pelo id
     * @param id da disciplina
     * @return a disciplina encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Integer id) {
        Optional<Disciplina> disciplina = disciplinaService.findById(id);
        return disciplina.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria uma nova disciplina
     * @param disciplina a ser criada
     * @return a disciplina criada
     */
    @PostMapping
    public ResponseEntity<Disciplina> createDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina novaDisciplina = disciplinaService.save(disciplina);
        return new ResponseEntity<>(novaDisciplina, HttpStatus.CREATED);
    }

    /**
     * Atualiza uma disciplina
     * @param id da disciplina a ser atualizada
     * @param disciplina com os novos dados
     * @return a disciplina atualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<Disciplina> updateDisciplina(@PathVariable Integer id, @RequestBody Disciplina disciplina) {
        if (!disciplinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        disciplina.setCodDisciplina(id);
        Disciplina disciplinaAtualizada = disciplinaService.save(disciplina);
        return ResponseEntity.ok(disciplinaAtualizada);
    }

    /**
     * Deleta uma disciplina
     * @param id da disciplina a ser deletada
     * @return resposta vazia
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDisciplina(@PathVariable Integer id) {
        if (!disciplinaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        disciplinaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}