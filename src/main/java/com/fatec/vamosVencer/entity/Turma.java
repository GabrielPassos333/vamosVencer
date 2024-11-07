package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

/**
 * Entidade Turma
 */
@Entity
public class Turma {

    // Atributos
    /**
     * Código da turma
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTurma;

    /**
     * Currículo da turma
     */
    @ManyToOne
    @JoinColumn(name = "codCurriculo", nullable = false)
    private Curriculo curriculo;

    /**
     * Professor da turma
     */
    @ManyToOne
    @JoinColumn(name = "matriculaProfessor", nullable = false)
    private Professor professor;

    /**
     * Semestre da turma
     */
    private Integer semestre;

    /**
     * Ano da turma
     */
    private Integer ano;

    // Getters e Setters
    public Integer getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(Integer codTurma) {
        this.codTurma = codTurma;
    }

    public Curriculo getCurriculo() {
        return curriculo;
    }

    public void setCurriculo(Curriculo curriculo) {
        this.curriculo = curriculo;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}
