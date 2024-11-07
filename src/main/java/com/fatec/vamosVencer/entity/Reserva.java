package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

/**
 * Classe responsável por representar a entidade Reserva
 */
@Entity
public class Reserva {

    // Atributos
    /**
     * Código da reserva
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codReserva;

    /**
     * Agenda da sala
     */
    @ManyToOne
    @JoinColumn(name = "codAgendaSala", nullable = false)
    private AgendaSala agendaSala;

    /**
     * Turma
     */
    @ManyToOne
    @JoinColumn(name = "codTurma")
    private Turma turma;

    /**
     * Secretaria
     */
    @ManyToOne
    @JoinColumn(name = "matriculaSecretaria", nullable = false)
    private Secretaria secretaria;

    /**
     * Manutenção
     */
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
