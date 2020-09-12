package com.example.pdmtrabalho;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CategoriaScene extends AppCompatActivity {

    Categoria categoria;

    private TextView lblTituloCategoria;
    private RecyclerView listaProdutos;

    private AdapterListaProdutosDestaque adapterListaProdutos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria_scene);
        Intent intent = getIntent();
        categoria = (Categoria) intent.getSerializableExtra("categoria");

        lblTituloCategoria = findViewById(R.id.lblTituloCategoria);

        lblTituloCategoria.setText(categoria.getTitulo());

        listaProdutos = findViewById(R.id.listaProdutos);

        GridLayoutManager gm = new GridLayoutManager(getApplicationContext(), 2);

        adapterListaProdutos = new AdapterListaProdutosDestaque(categoria.getProdutos());

        listaProdutos.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), listaProdutos,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View view, int position) {
                                Intent produtoScene = new Intent(getApplicationContext(), ProdutoScene.class);
                                produtoScene.putExtra("produto", categoria.getProdutos().get(position));
                                startActivity(produtoScene);
                            }

                            @Override public void onLongItemClick(View view, int position) {
                                // do whatever
                            }
                        })
        );


        listaProdutos.setLayoutManager(gm);
        listaProdutos.setAdapter(adapterListaProdutos);
        DividerItemDecoration linhaVertical =
                new DividerItemDecoration( this, LinearLayout.VERTICAL );
        listaProdutos.addItemDecoration(linhaVertical);


    }

}
