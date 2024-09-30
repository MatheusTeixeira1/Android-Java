package com.example.bancodedados_sqlite_herana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener{
    Button btnNavCriarProduto, btnCriarCategoria;

    ListView listViewProdutos;
    ListView listViewCategoiras;

    List<Produto> listaProdutos = new ArrayList<>();
    List<Categoria> listaCategorias = new ArrayList<>();

    ListAdapter listAdapterProdutos;
    ListAdapter listAdapterCategorias;

    EditText inputCriarCategoria;

    int indice;

    ProdutoDao produtoDao;
    CategoriaDao categoriaDao;
    Categoria categoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        inicializarEntidades();
    }

    public void inicializarEntidades(){
        btnNavCriarProduto = findViewById(R.id.btnNavCriarProduto);
        btnNavCriarProduto.setOnClickListener(this);

        btnCriarCategoria = findViewById(R.id.btnCriarCategoria);
        btnCriarCategoria.setOnClickListener(this);

        listViewProdutos = findViewById(R.id.listaProdutos);
        listViewProdutos.setOnItemClickListener(this);

        listViewCategoiras = findViewById(R.id.listaCategoria);
        listViewCategoiras.setOnItemClickListener(this);

        inputCriarCategoria = findViewById(R.id.inputCategoria);
    }
    private void atualizarListas() {
        listaCategorias = categoriaDao.listar();
        listAdapterCategorias = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaCategorias);
        listViewCategoiras.setAdapter(listAdapterCategorias);
    }
    @Override
    public void onClick(View view) {
        if(view == btnNavCriarProduto){
            abrirCadastroProduto();
        } else if (view == btnCriarCategoria) {
            categoria = new Categoria();
            categoria.setNome(inputCriarCategoria.getText().toString());
            System.out.println("------------------------");
            System.out.println("meu pau de asas");

            System.out.println(inputCriarCategoria.getText().toString());
            System.out.println("------------------------");
            long id = categoriaDao.inserir(categoria);
            Toast.makeText(this, "Categoria " + categoria.getNome() + " foi criado com o id = " + id, Toast.LENGTH_LONG).show();
            atualizarListas();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }
    private void abrirCadastroProduto() {
        Intent telaCad = new Intent(this, AvtCriarProduto.class);
        startActivity(telaCad);
    }
}