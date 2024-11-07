package com.fatec.vamosVencer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidade Professor
 */
@Entity
public class Professor {

    // Atributos
    /**
     * Matrícula do professor
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matriculaProfessor;

    /**
     * Nome do professor
     */
    private String nomeProfessor;

    // Getters e Setters
    public Integer getMatriculaProfessor() {
        return matriculaProfessor;
    }

    public void setMatriculaProfessor(Integer matriculaProfessor) {
        this.matriculaProfessor = matriculaProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}