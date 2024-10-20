package com.example.requisiohttpnativa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText edtCep;
    EditText edtResposta;
    Button btnBuscarCep;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCep = findViewById(R.id.edtCep);
        edtResposta = findViewById(R.id.edtResposta);
        btnBuscarCep = findViewById(R.id.btnBuscar);
        btnBuscarCep.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try {
            String resposta = new HttpService(edtCep.getText().toString()).execute().get();
            edtResposta.setText(resposta.toString());
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao realizar a consulta!", Toast.LENGTH_SHORT).show();
        }
    }
}