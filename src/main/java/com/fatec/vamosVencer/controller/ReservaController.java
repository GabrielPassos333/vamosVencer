package com.fatec.vamosVencer.controller;

import com.fatec.vamosVencer.entity.Reserva;
import com.fatec.vamosVencer.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public List<Reserva> getAllReservas() {
        return reservaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@PathVariable Integer id) {
        Optional<Reserva> reserva = reservaService.findById(id);
        return reserva.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@RequestBody Reserva reserva) {
        Reserva novaReserva = reservaService.save(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@PathVariable Integer id, @RequestBody Reserva reserva) {
        if (!reservaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reserva.setCodReserva(id);
        Reserva reservaAtualizada = reservaService.save(reserva);
        return ResponseEntity.ok(reservaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@PathVariable Integer id) {
        if (!reservaService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        reservaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
