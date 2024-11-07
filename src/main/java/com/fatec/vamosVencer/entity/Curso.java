package com.fatec.vamosVencer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Curso
 */
@Entity
public class Curso {
    
    // Atributos
    /**
     * Código do curso
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codCurso;
    
    /**
     * Nome do curso
     */
    private String nomeCurso;

    // Getters e Setters
    public Integer getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(Integer codCurso) {
        this.codCurso = codCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }
}