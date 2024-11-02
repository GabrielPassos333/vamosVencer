package com.fatec.vamosVencer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.vamosVencer.entity.Curso;
import com.fatec.vamosVencer.service.CursoService;

import java.util.List;
import java.util.Optional;

/**
 * Controlador para o recurso Curso
 */
@RestController
@RequestMapping("/cursos")
public class CursoController {

    /**
     * Injeção de dependência para o serviço de curso
     */
    @Autowired
    private CursoService cursoService;

    /**
     * Busca todos os cursos
     * @return lista de cursos
     */
    @GetMapping
    public List<Curso> getAllCursos() {
        return cursoService.findAll();
    }

    /**
     * Busca um curso pelo id
     * @param id do curso
     * @return o curso encontrado
     */
    @GetMapping("/{id}")
    public ResponseEntity<Curso> getCursoById(@PathVariable Integer id) {
        Optional<Curso> curso = cursoService.findById(id);
        return curso.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Cria um novo curso
     * @param curso a ser criado
     * @return o curso criado
     */
    @PostMapping
    public ResponseEntity<Curso> createCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.save(curso);
        return new ResponseEntity<>(novoCurso, HttpStatus.CREATED);
    }

    /**
     * Atualiza um curso
     * @param id do curso a ser atualizado
     * @param curso com os novos dados
     * @return o curso atualizado
     */
    @PutMapping("/{id}")
    public ResponseEntity<Curso> updateCurso(@PathVariable Integer id, @RequestBody Curso curso) {
        if (!cursoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        curso.setCodCurso(id);
        Curso cursoAtualizado = cursoService.save(curso);
        return ResponseEntity.ok(cursoAtualizado);
    }

    /**
     * Deleta um curso
     * @param id do curso a ser deletado
     * @return resposta vazia
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurso(@PathVariable Integer id) {
        if (!cursoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cursoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}