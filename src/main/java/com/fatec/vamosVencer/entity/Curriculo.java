package com.fatec.vamosVencer.entity;

import jakarta.persistence.*;

/**
 * Classe responsável por representar a entidade Curriculo
 */
@Entity
public class Curriculo {

    // Atributos
    /**
     * Código do currículo
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCurriculo;
    private Integer semestreGrade;

    /**
     * Disciplina
     */
    @ManyToOne
    @JoinColumn(name = "codDisciplina", nullable = false)
    private Disciplina disciplina;

    /**
     * Curso
     */
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
