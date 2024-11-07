package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

/**
 * Classe responsável por representar a entidade AgendaSala
 */
@Entity
public class AgendaSala {

    // Atributos
    /**
     * Código da agenda da sala
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAgendaSala;

    /**
     * Status da sala
     */
    private String status = "disponível";

    /**
     * Sala
     */
    @ManyToOne
    @JoinColumn(name = "codSala", nullable = false)
    private Sala sala;

    /**
     * Agenda
     */
    @ManyToOne
    @JoinColumn(name = "codAgenda", nullable = false)
    private Agenda agenda;

    // Getters e Setters
    public Integer getCodAgendaSala() {
        return codAgendaSala;
    }

    public void setCodAgendaSala(Integer codAgendaSala) {
        this.codAgendaSala = codAgendaSala;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}
