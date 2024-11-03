package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codTurma;

    @ManyToOne
    @JoinColumn(name = "codCurriculo", nullable = false)
    private Curriculo curriculo;

    @ManyToOne
    @JoinColumn(name = "matriculaProfessor", nullable = false)
    private Professor professor;

    private Integer semestre;

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
