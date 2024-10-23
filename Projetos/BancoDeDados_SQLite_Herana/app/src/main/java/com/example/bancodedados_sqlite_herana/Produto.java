package com.example.bancodedados_sqlite_herana;

import java.io.Serializable;

public class Produto implements Serializable {
    private Long id;
    private String nome;
    private float custo;
    private float precoVenda;
    private String unidade;
    private int quantidade;
    //private Categoria categoria;
    private Long categoria;

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

    public float getCusto() {
        return custo;
    }

    public void setCusto(float custo) {
        this.custo = custo;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getCategoria() {
        return categoria;
    }

    public void setCategoria(Long categoria) {
        this.categoria = categoria;
    }

    public Produto() {
    }

    public Produto(String nome, float custo, float precoVenda, String unidade, int quantidade, Long categoria) {
        this.nome = nome;
        this.custo = custo;
        this.precoVenda = precoVenda;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.categoria = categoria;
    }

    @Override
    public String toString(){
        return "ID: " + this.id + "Nome: " + this.nome + "Preço de Venda: " + this.precoVenda;
    }
}
