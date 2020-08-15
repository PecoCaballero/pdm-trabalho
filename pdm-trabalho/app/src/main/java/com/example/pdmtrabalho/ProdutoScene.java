package com.example.pdmtrabalho;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

public class ProdutoScene extends AppCompatActivity {

    Produto produto;

    private TextView txtTitulo;
    private TextView txtDescricao;
    private TextView txtPreco;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        setContentView(R.layout.activity_produto_scene);

        produto = (Produto) intent.getSerializableExtra("produto");

        txtTitulo = findViewById(R.id.txtTitulo);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtPreco = findViewById(R.id.txtPreco);

        txtTitulo.setText(produto.getTitulo());
        txtDescricao.setText(produto.getDescricao());
        txtPreco.setText(Double.toString(produto.getPreco()));

    }

}
