package com.example.bancodedados_sqlite_herana;

import android.database.sqlite.SQLiteDatabase;

public class ProdutoDao {
    private final String TABELA = "produto";
    private final String[] CAMPOS = {"id, nome, custo, preco_venda, unidade, quantidade, categoria_id"};
    private Conexao conexao;
    private SQLiteDatabase banco;
}
