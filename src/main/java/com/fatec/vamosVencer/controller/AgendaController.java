package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Agenda;
import com.fatec.vamosVencer.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agendas")
public class AgendaController {

    @Autowired
    private AgendaService agendaService;

    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Integer id) {
        Optional<Agenda> agenda = agendaService.findById(id);
        return agenda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agenda) {
        Agenda novaAgenda = agendaService.save(agenda);
        return new ResponseEntity<>(novaAgenda, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
        if (!agendaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agenda.setCodAgenda(id);
        Agenda agendaAtualizada = agendaService.save(agenda);
        return ResponseEntity.ok(agendaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Integer id) {
        if (!agendaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
