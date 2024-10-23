package com.example.requisicaohttpgetepost.model;

import java.io.Serializable;

public class Fabricante implements Serializable {
    private Long id;
    private String nome;

    public Fabricante() {
    }

    public Fabricante(String nome) {this.nome = nome;}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString(){return  id + " - " + nome;}
}
