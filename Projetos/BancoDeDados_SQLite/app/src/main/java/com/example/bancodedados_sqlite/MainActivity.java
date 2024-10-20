package com.example.bancodedados_sqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements View.OnClickListener, AdapterView.OnItemClickListener {

    ListView lstCliente;
    Button btnCad;

    List<Cliente> listaClientes = new ArrayList<>();
    ListAdapter listAdapter;
    int indice;
    ClienteDao dao;

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
        btnCad = findViewById(R.id.btnCriarCliente);
        btnCad.setOnClickListener(this);

        lstCliente = findViewById(R.id.listaClientes);
        lstCliente.setOnItemClickListener(this);

        dao = new ClienteDao(this);
        atualizarLista();
    }

    @Override
    protected void onResume(){
        super.onResume();
        atualizarLista();
    }

    private void atualizarLista() {
        listaClientes = dao.listar();
        listAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listaClientes);
        lstCliente.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View view) {
        if (view == btnCad){
            Cliente c = new Cliente();
            c.setId(0L);
            abrirCadastro("Inserir", c);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        indice = position;
        Cliente c = (Cliente) lstCliente.getAdapter().getItem(position);
        abrirCadastro("Alterar", c);
    }

    private void abrirCadastro(String acao, Cliente obj) {
        Intent telaCad = new Intent(this, AtvCadastro.class);
        Bundle extras = new Bundle();
        extras.putString("acao", acao);
        extras.putSerializable("obj", (Serializable) obj);
        telaCad.putExtras(extras);
        startActivity(telaCad);
    }
}