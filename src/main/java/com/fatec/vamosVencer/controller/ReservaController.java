package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Reserva;
import com.fatec.vamosVencer.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável por controlar as requisições referentes a Reserva
 */
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    /**
     * Atributo reservaService do tipo ReservaService
     */
    @Autowired
    private ReservaService reservaService;

    /**
     * Método para listar todas as reservas
     * @return List<Reserva>
     */
    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    /**
     * Método para buscar uma reserva pelo id
     * @param id do tipo Integer
     * @return ResponseEntity<Reserva>
     */
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Método para criar uma nova reserva
     * @param reserva do tipo Reserva
     * @return ResponseEntity<Reserva>
     */
    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.save(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    /**
     * Método para atualizar uma reserva
     * @param id do tipo Integer
     * @param reserva do tipo Reserva
     * @return ResponseEntity<Reserva>
     */
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        if (!reservaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reserva.setCodReserva(id);
        Reserva reservaAtualizada = reservaService.save(reserva);
        return ResponseEntity.ok(reservaAtualizada);
    }

    /**
     * Método para deletar uma reserva
     * @param id do tipo Integer
     * @return ResponseEntity<Void>
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Integer id) {
        if (!reservaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
