package com.example.listacustomizada;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.List;

public class AtvAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List lista;

    private TextView txtLinha1, txtLinha2;

    public AtvAdapter(Context context, List lista){
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Object obj = lista.get(position);
        view = mInflater.inflate(R.layout.atv_adapter, null);

        txtLinha1 = (TextView) view.findViewById(R.id.txtLinha1);
        txtLinha2 = (TextView) view.findViewById(R.id.txtLinha2);

        if(obj instanceof Produto){
            txtLinha1.setText(((Produto) obj).getNome());
            txtLinha2.setText(((Produto) obj).getPreco().toString());
        }
        return view;
    }
}