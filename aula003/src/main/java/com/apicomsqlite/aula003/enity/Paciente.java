package com.apicomsqlite.aula003.enity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Paciente {

    @Id
    private int id;

    private String nome;

    private String email;

    private String telefone;

    private String comorbidade;

    private String endereco;

    public Paciente() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getnome() {
        return nome;
    }

    public String gettelefone() {
        return telefone;
    }

    public String getcomorbidade() {
        return comorbidade;
    }

    public String getendereco() {
        return endereco;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void settelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setcomorbidade(String comorbidade) {
        this.comorbidade = comorbidade;
    }

    public void setendereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco='" + endereco + '\'' +
                ", comorbidade='" + comorbidade + '\'' +
                '}';
    }
}