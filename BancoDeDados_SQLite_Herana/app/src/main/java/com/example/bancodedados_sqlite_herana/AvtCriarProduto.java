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

public class AvtCriarProduto extends AppCompatActivity implements View

        .OnClickListener{
    Button btnGravarProduto, btnVoltar;

    EditText inputNome, inputCusto, inputPrecoVenda, inputUnidade, inputEstoque;

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

        inputNome = findViewById(R.id.inputNome);
        inputCusto = findViewById(R.id.inputCusto);
        inputPrecoVenda = findViewById(R.id.inputVenda);
        inputUnidade = findViewById(R.id.inputUnidade);
        inputEstoque = findViewById(R.id.inputEstoque);

        spnCategorias = findViewById(R.id.inputCategoria);
    }

    @Override
    public void onClick(View view) {
        if(view == btnVoltar){
            finish();
        }else if(view == btnGravarProduto) {
            produto.setNome(inputNome.getText().toString());
            produto.setCusto(Float.parseFloat(inputCusto.getText().toString()));
            produto.setPrecoVenda(Float.parseFloat(inputPrecoVenda.getText().toString()));
            produto.setUnidade(inputUnidade.getText().toString());
            produto.setQuantidade(Integer.parseInt(inputEstoque.getText().toString()));
            //produto.setCategoria((String) spnCategorias.getSelectedItem());
        }
    }
}