package com.example.bancodedados_sqlite_herana;

import java.io.Serializable;

public class Categoria implements Serializable {
    private Long id;
    private String nome;

    public Categoria() {
    }
    public Categoria(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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

    @Override
    public String toString(){
        return "Id: "+ getId() + ", Nome: "+ getNome();
    }
}
