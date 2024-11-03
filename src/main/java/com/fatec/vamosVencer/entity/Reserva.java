package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

@Entity
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codReserva;

    @ManyToOne
    @JoinColumn(name = "codAgendaSala", nullable = false)
    private AgendaSala agendaSala;

    @ManyToOne
    @JoinColumn(name = "codTurma")
    private Turma turma;

    @ManyToOne
    @JoinColumn(name = "matriculaSecretaria", nullable = false)
    private Secretaria secretaria;

    private Boolean manutencao;

    // Getters e Setters
    public Integer getCodReserva() {
        return codReserva;
    }

    public void setCodReserva(Integer codReserva) {
        this.codReserva = codReserva;
    }

    public AgendaSala getAgendaSala() {
        return agendaSala;
    }

    public void setAgendaSala(AgendaSala agendaSala) {
        this.agendaSala = agendaSala;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
    }

    public Boolean getManutencao() {
        return manutencao;
    }

    public void setManutencao(Boolean manutencao) {
        this.manutencao = manutencao;
    }
}
