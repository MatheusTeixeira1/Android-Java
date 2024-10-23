package com.example.requisicaohttpgetepost;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

import com.example.requisicaohttpgetepost.model.Fabricante;
import com.example.requisicaohttpgetepost.services.ServiceFabricante;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText edtNome, edtResposta;
    Button btnPost, btnGet;
    ListView listView;
    List<Fabricante> listaFab = new ArrayList<>();
    Context context;

    private Retrofit retrofit;
    ServiceFabricante service;

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

        iniciarObjetos();

    }

    public void iniciarObjetos(){
        edtNome = findViewById(R.id.edtNome);
        edtResposta = findViewById(R.id.edtResposta);
        listView = findViewById(R.id.listView);
        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(this);
        btnGet = findViewById(R.id.btnGet);
        btnGet.setOnClickListener(this);

        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.1:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(ServiceFabricante.class);

        context = this;
    }

    @Override
    public void onClick(View v) {
        if(v == btnGet){
            Call<List<Fabricante>> call = service.getFabricante();
            call.enqueue(new Callback<List<Fabricante>>() {
                @Override
                public void onResponse(Call<List<Fabricante>> call, Response<List<Fabricante>> response) {
                    if(response.isSuccessful()) {
                        listaFab = response.body();
                        edtResposta.setText(response.body().toString());

                        ListAdapter listAdapter = new ArrayAdapter<Fabricante>(context,
                                android.R.layout.simple_list_item_1, listaFab);
                        listView.setAdapter(listAdapter);
                    }
                }

                @Override
                public void onFailure(Call<List<Fabricante>> call, Throwable t) {
                    Toast.makeText(MainActivity.this, "Ocorreu um erro na requisição",
                            Toast.LENGTH_SHORT).show();
                    Log.e("Erro", t.getMessage());
                }
            });
        }
    }
}