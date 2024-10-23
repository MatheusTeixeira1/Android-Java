package com.example.bancodedados_sqlite_herana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDao {
    private final String TABELA = "categoria";
    private final String[] CAMPOS = {"id, nome"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public CategoriaDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    private ContentValues preecherValores(Categoria categoria){
        ContentValues values = new ContentValues();

        values.put("nome", categoria.getNome());

        return values;
    }

    public long inserir(Categoria categoria) {
        ContentValues values = preecherValores(categoria);
        return banco.insert(TABELA, null, values);
    }
    public long alterar(Categoria categoria) {
        ContentValues values = preecherValores(categoria);
        return banco.update(TABELA, values, "id = ?", new String[] {categoria.getId().toString()});
    }
    public long excluir(Categoria categoria) {
        return banco.delete(TABELA, "id = ?", new String[] {categoria.getId().toString()});
    }
    public List<Categoria> listar(){
        Cursor c = banco.query(TABELA, CAMPOS,
                null, null, null, null, null);
        List<Categoria> lista = new ArrayList<>();
        while (c.moveToNext()){
            Categoria categoria = new Categoria();
            categoria.setId(c.getLong(0));
            categoria.setNome(c.getString(1));
            lista.add(categoria);
        }
        return lista;
    }
}
