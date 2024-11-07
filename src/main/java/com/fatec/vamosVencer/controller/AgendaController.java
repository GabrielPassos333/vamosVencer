package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Agenda;
import com.fatec.vamosVencer.service.AgendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar as requisições referentes a Agenda
 */
@RestController
@RequestMapping("/agendas")
public class AgendaController {

    /**
     * Atributo agendaService do tipo AgendaService
     */
    @Autowired
    private AgendaService agendaService;

    /**
     * Método para listar todas as agendas
     * @return List<Agenda>
     */
    @GetMapping
    public List<Agenda> getAllAgendas() {
        return agendaService.findAll();
    }

    /**
     * Método para buscar uma agenda pelo id
     * @param id do tipo Integer
     * @return ResponseEntity<Agenda>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Agenda> getAgendaById(@PathVariable Integer id) {
        Optional<Agenda> agenda = agendaService.findById(id);
        return agenda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para criar uma nova agenda
     * @param agenda do tipo Agenda
     * @return ResponseEntity<Agenda>
     */
    @PostMapping
    public ResponseEntity<Agenda> createAgenda(@RequestBody Agenda agenda) {
        Agenda novaAgenda = agendaService.save(agenda);
        return new ResponseEntity<>(novaAgenda, HttpStatus.CREATED);
    }

    /**
     * Método para atualizar uma agenda
     * @param id do tipo Integer
     * @param agenda do tipo Agenda
     * @return ResponseEntity<Agenda>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Agenda> updateAgenda(@PathVariable Integer id, @RequestBody Agenda agenda) {
        if (!agendaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agenda.setCodAgenda(id);
        Agenda agendaAtualizada = agendaService.save(agenda);
        return ResponseEntity.ok(agendaAtualizada);
    }

    /**
     * Método para deletar uma agenda
     * @param id do tipo Integer
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAgenda(@PathVariable Integer id) {
        if (!agendaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        agendaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
