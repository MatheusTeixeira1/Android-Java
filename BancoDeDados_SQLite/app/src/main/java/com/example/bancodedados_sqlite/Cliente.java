package com.example.bancodedados_sqlite;

import java.io.Serializable;

public class Cliente implements Serializable {
    private Long id;
    private String nome;
    private String fone;
    private String email;
    private String observacao;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String fone, String email, String observacao) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
        this.observacao = observacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "id: " + id + ", Nome: " + nome + ", Fone: " + fone;
    }
}
