package com.fatec.vamosVencer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Secretaria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer matriculaSecretaria;
    private String nomeSecretaria;

    // Getters e Setters
    public Integer getMatriculaSecretaria() {
        return matriculaSecretaria;
    }

    public void setMatriculaSecretaria(Integer matriculaSecretaria) {
        this.matriculaSecretaria = matriculaSecretaria;
    }

    public String getNomeSecretaria() {
        return nomeSecretaria;
    }

    public void setNomeSecretaria(String nomeSecretaria) {
        this.nomeSecretaria = nomeSecretaria;
    }
}
