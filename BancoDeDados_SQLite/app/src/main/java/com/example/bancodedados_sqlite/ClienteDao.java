package com.example.bancodedados_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private final String TABELA = "cliente";
    private final String[] CAMPOS = {"id, nome, fone, email, observacao"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ClienteDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    private ContentValues preecherValores(Cliente cliente){
        ContentValues values = new ContentValues();

        values.put("nome", cliente.getNome());
        values.put("fone", cliente.getFone());
        values.put("email", cliente.getEmail());
        values.put("observacao", cliente.getObservacao());

        return values;
    }

    public long inserir(Cliente cliente) {
        ContentValues values = preecherValores(cliente);
        return banco.insert(TABELA, null, values);
    }
    public long alterar(Cliente cliente) {
        ContentValues values = preecherValores(cliente);
        return banco.update(TABELA, values, "id = ?", new String[] {cliente.getId().toString()});
    }
    public long excluir(Cliente cliente) {
        return banco.delete(TABELA, "id = ?", new String[] {cliente.getId().toString()});
    }
    public List<Cliente> listar(){
        Cursor c = banco.query(TABELA, CAMPOS,
                null, null, null, null, null);
        List<Cliente> lista = new ArrayList<>();
        while (c.moveToNext()){
            Cliente cliente = new Cliente();
            cliente.setId(c.getLong(0));
            cliente.setNome(c.getString(1));
            cliente.setNome(c.getString(2));
            cliente.setNome(c.getString(3));
            cliente.setNome(c.getString(4));
            lista.add(cliente);
        }
        return lista;
    }
}
