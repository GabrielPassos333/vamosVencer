package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

@Entity
public class AgendaSala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codAgendaSala;

    private String status = "disponível";

    @ManyToOne
    @JoinColumn(name = "codSala", nullable = false)
    private Sala sala;

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
