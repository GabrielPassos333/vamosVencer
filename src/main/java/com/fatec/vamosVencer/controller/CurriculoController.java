package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Curriculo;
import com.fatec.vamosVencer.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<Curriculo> getAllCurriculos() {
        return curriculoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Integer id) {
        Optional<Curriculo> curriculo = curriculoService.findById(id);
        return curriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Curriculo> createCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo novoCurriculo = curriculoService.save(curriculo);
        return new ResponseEntity<>(novoCurriculo, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> updateCurriculo(@PathVariable Integer id, @RequestBody Curriculo curriculo) {
        if (!curriculoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        curriculo.setCodCurriculo(id);
        Curriculo curriculoAtualizado = curriculoService.save(curriculo);
        return ResponseEntity.ok(curriculoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Integer id) {
        if (!curriculoService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        curriculoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
