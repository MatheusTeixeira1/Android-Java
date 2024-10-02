package com.example.bancodedados_sqlite_herana;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class AvtCriarProduto extends AppCompatActivity implements View

        .OnClickListener{
    Button btnGravarProduto, btnVoltar, btnCriarCategoria;

    EditText inputNome, inputCusto, inputPrecoVenda, inputUnidade, inputEstoque, inputCriarCategoria;

    Spinner spnCategorias;

    Produto produto;
    ProdutoDao dao;

    ProdutoDao produtoDao;
    CategoriaDao categoriaDao;

    List<Categoria> categorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_criar_produto);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
        inicializarEntidades();
    }

    public void inicializarEntidades(){
        btnVoltar = findViewById(R.id.btnVoltar_CriarProduto_Home);
        btnVoltar.setOnClickListener(this);
        btnGravarProduto = findViewById(R.id.btnGravarProduto);
        btnGravarProduto.setOnClickListener(this);
        btnCriarCategoria = findViewById(R.id.btnCriarCategoria);
        btnCriarCategoria.setOnClickListener(this);

        inputNome = findViewById(R.id.inputNome);
        inputCusto = findViewById(R.id.inputCusto);
        inputPrecoVenda = findViewById(R.id.inputVenda);
        inputUnidade = findViewById(R.id.inputUnidade);
        inputEstoque = findViewById(R.id.inputEstoque);
        inputCriarCategoria = findViewById(R.id.inputCategoria);

        spnCategorias = findViewById(R.id.inputSpnCategoria);


        categoriaDao = new CategoriaDao(this);
        produtoDao = new ProdutoDao(this);

        carregarSpinner();
    }
    public void carregarSpinner(){
        categorias = categoriaDao.listar();

        ArrayList<String> options = new ArrayList<>();

        for (Categoria c : categorias){
            options.add(c.getNome());
            System.out.println(c.getNome());
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnCategorias.setAdapter(adapter);

        String opSel = (String) spnCategorias.getSelectedItem();

    }



    @Override
    public void onClick(View view) {
        produto = new Produto();
        if(view == btnVoltar){
            finish();
        }else if(view == btnGravarProduto) {
            produto.setNome(inputNome.getText().toString());
            produto.setCusto(Float.parseFloat(inputCusto.getText().toString()));
            produto.setPrecoVenda(Float.parseFloat(inputPrecoVenda.getText().toString()));
            produto.setUnidade(inputUnidade.getText().toString());
            produto.setQuantidade(Integer.parseInt(inputEstoque.getText().toString()));

            String opSel = (String) spnCategorias.getSelectedItem();
            for(Categoria c: categorias){
                if(c.getNome() == opSel){
                    produto.setCategoria(c.getId());
                }
            }
            System.out.println(produto);
            produtoDao.inserir(produto);
            finish();
        }else if(view == btnCriarCategoria){
            Categoria categoria = new Categoria();
            categoria.setNome(inputCriarCategoria.getText().toString());
            categoriaDao.inserir(categoria);
            carregarSpinner();
        }
    }
}