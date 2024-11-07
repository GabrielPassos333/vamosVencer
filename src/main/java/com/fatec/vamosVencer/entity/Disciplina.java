package com.fatec.vamosVencer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Disciplina
 */
@Entity
public class Disciplina {

    // Atributos
    /**
     * Código da disciplina
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codDisciplina;
    
    /**
     * Nome da disciplina
     */
    private String nomeDisciplina;

    // Getters e Setters
    public Integer getCodDisciplina() {
        return codDisciplina;
    }

    public void setCodDisciplina(Integer codDisciplina) {
        this.codDisciplina = codDisciplina;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }
}