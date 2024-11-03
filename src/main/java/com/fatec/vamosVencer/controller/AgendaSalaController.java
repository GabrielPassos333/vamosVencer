package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.AgendaSala;
import com.fatec.vamosVencer.service.AgendaSalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendasalas")
public class AgendaSalaController {

    @Autowired
    private AgendaSalaService agendaSalaService;

    @GetMapping
    public List<AgendaSala> getAllAgendaSalas() {
        return agendaSalaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AgendaSala> getAgendaSalaById(@PathVariable Integer id) {
        Optional<AgendaSala> agendaSala = agendaSalaService.findById(id);
        return agendaSala.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AgendaSala> createAgendaSala(@RequestBody AgendaSala agendaSala) {
        AgendaSala novaAgendaSala = agendaSalaService.save(agendaSala);
        return new ResponseEntity<>(novaAgendaSala, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AgendaSala> updateAgendaSala(@PathVariable Integer id, @RequestBody AgendaSala agendaSala) {
        if (!agendaSalaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agendaSala.setCodAgendaSala(id);
        AgendaSala agendaSalaAtualizada = agendaSalaService.save(agendaSala);
        return ResponseEntity.ok(agendaSalaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgendaSala(@PathVariable Integer id) {
        if (!agendaSalaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agendaSalaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
