package com.fatec.vamosVencer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Classe responsável por representar a entidade Agenda
 */
@Entity
public class Agenda {

    // Atributos
    /**
     * Código da agenda
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAgenda;
    
    /**
     * Data agendada
     */
    private LocalDate dataAgendada;
    /**
     * Hora agendada
     */
    private LocalTime hora;

    // Getters e Setters
    public Integer getCodAgenda() {
        return codAgenda;
    }

    public void setCodAgenda(Integer codAgenda) {
        this.codAgenda = codAgenda;
    }

    public LocalDate getDataAgendada() {
        return dataAgendada;
    }

    public void setDataAgendada(LocalDate dataAgendada) {
        this.dataAgendada = dataAgendada;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
}
