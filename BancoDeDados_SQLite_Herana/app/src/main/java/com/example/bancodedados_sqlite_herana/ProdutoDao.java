package com.example.bancodedados_sqlite_herana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao {
    private final String TABELA = "produto";
    private final String[] CAMPOS = {"id, nome, custo, preco_venda, unidade, quantidade, categoria_id"};
    private Conexao conexao;
    private SQLiteDatabase banco;

    public ProdutoDao(Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }
    private ContentValues preecherValores(Produto produto){
        ContentValues values = new ContentValues();

        values.put("nome", produto.getNome());
        values.put("custo",produto.getCusto());
        values.put("preco_venda", produto.getPrecoVenda());
        values.put("unidade", produto.getUnidade());
        values.put("quantidade", produto.getQuantidade());
        values.put("categoria_id", produto.getCategoria());

        return values;
    }

    public long inserir(Produto produto) {
        ContentValues values = preecherValores(produto);
        return banco.insert(TABELA, null, values);
    }
    public long alterar(Produto produto) {
        ContentValues values = preecherValores(produto);
        return banco.update(TABELA, values, "id = ?", new String[] {String.valueOf(produto.getId())});
    }
    public long excluir(Produto produto) {
        return banco.delete(TABELA, "id = ?", new String[] {String.valueOf(produto.getId())});
    }
    public List<Produto> listar(){
        Cursor p = banco.query(TABELA, CAMPOS,
                null, null, null, null, null);
        List<Produto> lista = new ArrayList<>();
        while (p.moveToNext()){
            Produto produto = new Produto();
            produto.setId(p.getLong(0));
            produto.setNome(p.getString(1));
            produto.setCusto(Float.parseFloat(p.getString(2)));
            produto.setPrecoVenda(Float.parseFloat(p.getString(3)));
            produto.setUnidade(p.getString(4));
            produto.setQuantidade(Integer.parseInt(p.getString(5)));
            produto.setCategoria(p.getLong(6));
            //Categoria categoria = new Categoria();
            //categoria.setId(p.getLong(6)); // Supondo que o ID da categoria esteja na coluna 6
            //categoria.setNome(p.getString(7)); // Supondo que o nome da categoria esteja na coluna 7
            //produto.setCategoria(categoria);
            lista.add(produto);
        }
        return lista;
    }
}
