package com.example.bancodedados_sqlite_herana;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class criarProduto extends AppCompatActivity implements View

        .OnClickListener{
    Button btnGravarProduto, btnVoltar;

    EditText imputNome, imputCusto, imputPrecoVenda, imputUnidade, imputEstoque;

    Spinner spnCategorias;

    Produto produto;
    ProdutoDao dao;

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
    }

    public void inicializarEntidades(){
        btnVoltar = findViewById(R.id.btnVoltar_CriarProduto_Home);
        btnVoltar.setOnClickListener(this);
        btnGravarProduto = findViewById(R.id.btnGravarProduto);
        btnGravarProduto.setOnClickListener(this);

        imputNome = findViewById(R.id.imputNome);
        imputCusto = findViewById(R.id.imputCusto);
        imputPrecoVenda = findViewById(R.id.imputVenda);
        imputUnidade = findViewById(R.id.imputUnidade);
        imputEstoque = findViewById(R.id.imputEstoque);

        spnCategorias = findViewById(R.id.imputCategoria);
    }

    @Override
    public void onClick(View view) {

    }
}