package com.example.bancodedados_sqlite;

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

public class AtvCadastro extends AppCompatActivity implements View.OnClickListener {

    Button btnGravar;
    Button btnVoltar;
    Button btnExcluir;

    EditText edtCodigo;
    EditText edtNome;
    EditText edtFone;
    EditText edtEmail;
    EditText edtObs;

    String acao;
    Cliente c;
    ClienteDao dao;

    private void criarComponentes(){
        btnGravar = findViewById(R.id.btnInserir);
        btnGravar.setOnClickListener(this);
        btnGravar.setText(acao);

        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        btnExcluir = findViewById(R.id.btnExcluir);
        btnExcluir.setOnClickListener(this);

        if (acao.equals("Inserir")){
            btnExcluir.setVisibility(View.INVISIBLE);
        }
        else{
            btnExcluir.setVisibility(View.VISIBLE);
        }

        edtCodigo = findViewById(R.id.imputCodigo);
        edtNome = findViewById(R.id.imputNome);
        edtFone = findViewById(R.id.imputFone);
        edtEmail = findViewById(R.id.imputEmail);
        edtObs = findViewById(R.id.imputObs);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_atv_cadastro);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        acao = getIntent().getExtras().getString("acao");
        dao = new ClienteDao(this);
        criarComponentes();

        if (getIntent().getExtras().getSerializable("obj") != null){
            c = (Cliente) getIntent().getExtras().getSerializable("obj");
            edtCodigo.setText(c.getId().toString());
            edtNome.setText(c.getNome());
            edtFone.setText(c.getFone());
            edtEmail.setText(c.getEmail());
            edtObs.setText(c.getObservacao());
        }
    }

    @Override
    public void onClick(View v) {
        if(v == btnVoltar){
            finish();
        } else if (v == btnExcluir) {
            long id = dao.excluir(c);
            Toast.makeText(this, "Cliente " + c.getNome() + " foi excluido!", Toast.LENGTH_LONG).show();
            finish();
        } else if (v == btnGravar) {
                c.setNome(edtNome.getText().toString());
            c.setFone(edtFone.getText().toString());
            c.setEmail(edtEmail.getText().toString());
            c.setObservacao(edtObs.getText().toString());

            if(acao.equals("Inserir")){
                long id = dao.inserir(c);
                Toast.makeText(this, "Cliente " + c.getNome() + " foi criado com o id = " + id, Toast.LENGTH_LONG).show();
            }else{
                long id = dao.alterar(c);
                Toast.makeText(this, "Cliente " + c.getNome() + " foi alterado", Toast.LENGTH_LONG).show();

            }
            finish();
        }
    }
}