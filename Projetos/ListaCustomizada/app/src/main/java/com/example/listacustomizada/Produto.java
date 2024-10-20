package com.example.listacustomizada;

import java.io.Serializable;

public class Produto implements Serializable {
    private Long id;
    private String nome;
    private Float preco;

    public Produto(Long id, String nome, Float preco) {
        this.nome = nome;
        this.id = id;
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
