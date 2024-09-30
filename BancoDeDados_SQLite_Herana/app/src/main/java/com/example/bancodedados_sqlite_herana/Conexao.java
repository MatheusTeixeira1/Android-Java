package com.example.bancodedados_sqlite_herana;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String NAME = "Banco.db";
    private static final int VERSION = 1;

    private static final String SQL_CREATE_CATEGORIA = "create table categoria(" +
            "id integer primary key autoincrement," +
            "nome varchar(50));";

    private static final String SQL_CREATE_PRODUTO = "create table produto(" +
            "id integer primary key autoincrement," +
            "nome varchar(50)," +
            "custo float," +
            "preco_venda float," +
            "unidade text," +
            "quantidade integer," +
            "FOREIGN KEY (categoria_id) REFERENCES Categoria(id));";


    public Conexao(@Nullable Context context) {super(context, NAME, null, VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS Banco.db");
        db.execSQL(SQL_CREATE_CATEGORIA);
        //db.execSQL(SQL_CREATE_PRODUTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
