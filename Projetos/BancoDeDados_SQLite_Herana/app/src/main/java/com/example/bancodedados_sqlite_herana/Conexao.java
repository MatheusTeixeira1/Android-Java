package com.example.bancodedados_sqlite_herana;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String NAME = "Banco.db";
    private static final int VERSION = 2;

    // SQL para criar a tabela categoria
    private static final String SQL_CREATE_CATEGORIA = "create table categoria(" +
            "id integer primary key autoincrement," +
            "nome varchar(50));";

    // SQL corrigido para criar a tabela produto com a coluna categoria_id
    private static final String SQL_CREATE_PRODUTO = "create table produto("+
            "id integer primary key autoincrement," +
            "nome varchar(50)," +
            "custo float," +
            "preco_venda float," +
            "unidade text," +
            "quantidade integer," +
            "categoria_id integer," + // Adicionada a coluna categoria_id
            "FOREIGN KEY (categoria_id) REFERENCES categoria(id));"; // Corrigido o nome da tabela referenciada

    public Conexao(@Nullable Context context) {
        super(context, NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Remove essas linhas que estão tentando excluir o banco de dados
        // db.execSQL("DELETE FROM Banco.db");
        // db.execSQL("DROP TABLE IF EXISTS Banco.db");

        // Criação das tabelas
        db.execSQL(SQL_CREATE_CATEGORIA);
        db.execSQL(SQL_CREATE_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Aqui, você pode lidar com atualizações de versão, se necessário
    }
}
