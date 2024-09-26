package com.example.bancodedados_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String NAME = "Banco.db";
    private static final int VERSION = 1;

    private static final String SQL_CREATE = "create table cliente(" +
    "id integer primary key autoincrement," +
    "nome varchar(50), fone varchat(20)," +
    "email varchar(50)," +
            " observacao text);";

    public Conexao(@Nullable Context context) {super(context, NAME, null, VERSION);}

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
