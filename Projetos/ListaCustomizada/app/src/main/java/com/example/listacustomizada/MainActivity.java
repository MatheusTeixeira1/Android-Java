package com.example.listacustomizada;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lstDados;
    List<Produto> listaProd;

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

        lstDados = findViewById(R.id.lstDados);
        gerarDados();
        AtvAdapter listAdapter = new AtvAdapter(this, listaProd);
        lstDados.setAdapter(listAdapter);
        lstDados.setOnItemClickListener(this);
    }

    private void gerarDados() {
        listaProd = new ArrayList<Produto>();

        listaProd.add(new Produto(1L, "Arroz", 25.0f));
        listaProd.add(new Produto(2L, "Feijão", 6.0f));
        listaProd.add(new Produto(3L, "Açucar", 15.0f));
        listaProd.add(new Produto(4L, "Carne", 33.9f));
        listaProd.add(new Produto(5L, "Ovos", 12.5f));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Produto p = (Produto) lstDados.getAdapter().getItem(position);
        Toast.makeText(this,"Produto" + p.getNome(), Toast.LENGTH_LONG).show();
    }
}