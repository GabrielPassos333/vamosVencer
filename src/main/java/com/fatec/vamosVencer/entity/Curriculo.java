package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

/**
 * Entidade Curriculo
 */
@Entity
public class Curriculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCurriculo;
    private Integer semestreGrade;

    @ManyToOne
    @JoinColumn(name = "codDisciplina", nullable = false)
    private Disciplina disciplina;

    @ManyToOne
    @JoinColumn(name = "codCurso", nullable = false)
    private Curso curso;

    // Getters e Setters
    public Integer getCodCurriculo() {
        return codCurriculo;
    }

    public void setCodCurriculo(Integer codCurriculo) {
        this.codCurriculo = codCurriculo;
    }

    public Integer getSemestreGrade() {
        return semestreGrade;
    }

    public void setSemestreGrade(Integer semestreGrade) {
        this.semestreGrade = semestreGrade;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
