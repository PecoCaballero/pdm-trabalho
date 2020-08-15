package com.example.pdmtrabalho;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class HomeScreen extends AppCompatActivity {

    private RecyclerView listaCategorias;
    private RecyclerView listaProdutosDestaque;

    private ArrayList<Categoria> categorias = new ArrayList<Categoria>();
    private AdapterListaCategorias adapterListaCategorias;

    private ArrayList<Produto> produtosDestaque = new ArrayList<Produto>();
    private AdapterListaProdutosDestaque adapterListaProdutosDestaque;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        listaCategorias = findViewById(R.id.listaCategorias);
        listaProdutosDestaque = findViewById(R.id.listaProdutosDestaque);

        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        GridLayoutManager gm = new GridLayoutManager(getApplicationContext(), 2);

        adapterListaCategorias = new AdapterListaCategorias(categorias);
        adapterListaProdutosDestaque = new AdapterListaProdutosDestaque(produtosDestaque);

        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        listaCategorias.setLayoutManager(lm);
        listaCategorias.setAdapter(adapterListaCategorias);
        DividerItemDecoration linhaHorizontal =
                new DividerItemDecoration( this, LinearLayout.HORIZONTAL );
        listaCategorias.addItemDecoration(linhaHorizontal);

        listaCategorias.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), listaCategorias,
                        new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Intent categoriaScreen = new Intent(getApplicationContext(), CategoriaScene.class);
                        categoriaScreen.putExtra("categoria", categorias.get(position));
                        startActivity(categoriaScreen);
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        listaProdutosDestaque.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), listaProdutosDestaque,
                        new RecyclerItemClickListener.OnItemClickListener() {
                            @Override public void onItemClick(View view, int position) {
                                Intent produtoScene = new Intent(getApplicationContext(), ProdutoScene.class);
                                produtoScene.putExtra("produto", produtosDestaque.get(position));
                                startActivity(produtoScene);
                            }

                            @Override public void onLongItemClick(View view, int position) {
                                // do whatever
                            }
                        })
        );


        listaProdutosDestaque.setLayoutManager(gm);
        listaProdutosDestaque.setAdapter(adapterListaProdutosDestaque);
        DividerItemDecoration linhaVertical =
                new DividerItemDecoration( this, LinearLayout.VERTICAL );
        listaProdutosDestaque.addItemDecoration(linhaVertical);

        popularCategorias();
        popularProdutosDestaque();

    }

    private void popularCategorias(){
        ArrayList<Produto> produtosCat = new ArrayList<Produto>();
        produtosCat.add(new Produto("Barbie", null, "Este produto é bom", 50.34));
        produtosCat.add(new Produto("Jogo de Tabuleiro", null, "Este produto é bom", 32));
        produtosCat.add(new Produto("Carrinho", null, "Este produto é bom", 14.99));
        produtosCat.add(new Produto("Nerf", null, "Este produto é bom", 160.55));
        Categoria cat = new Categoria("Brinquedos", "", produtosCat);
        ArrayList<Produto> produtosCat2 = new ArrayList<Produto>();
        produtosCat2.add(new Produto("Pá", null, "Este produto é bom", 50.34));
        produtosCat2.add(new Produto("Britadeira", null, "Este produto é bom", 599.99));
        produtosCat2.add(new Produto("Conjunto de chaves", null, "Este produto é bom", 14.99));
        produtosCat2.add(new Produto("Parafusadeira", null, "Este produto é bom", 360.55));
        Categoria cat2 = new Categoria("Ferramentas", "", produtosCat2);
        ArrayList<Produto> produtosCat3 = new ArrayList<Produto>();
        produtosCat3.add(new Produto("Capinha de celular", null, "Este produto é bom", 50.34));
        produtosCat3.add(new Produto("IPhone 6", null, "Este produto é bom", 599.99));
        produtosCat3.add(new Produto("Carregador USB-C", null, "Este produto é bom", 14.99));
        produtosCat3.add(new Produto("Google home mini", null, "Este produto é bom", 360.55));
        Categoria cat3 = new Categoria("Eletrônicos", "", produtosCat3);
        ArrayList<Produto> produtosCat4 = new ArrayList<Produto>();
        produtosCat4.add(new Produto("Panela funda", null, "Este produto é bom", 50.34));
        produtosCat4.add(new Produto("AirFryer", null, "Este produto é bom", 599.99));
        produtosCat4.add(new Produto("Espatula de silicone", null, "Este produto é bom", 14.99));
        produtosCat4.add(new Produto("Frigideira antiaderente", null, "Este produto é bom", 360.55));
        Categoria cat4 = new Categoria("Cozinha", "", produtosCat4);
        categorias.add(cat);
        categorias.add(cat2);
        categorias.add(cat3);
        categorias.add(cat4);
        adapterListaProdutosDestaque.notifyDataSetChanged();
    }


    private void popularProdutosDestaque(){
        Produto prod = new Produto("Jogo de tabuleiro", "","Este produto é bom", 10);
        Produto prod2 = new Produto("Pá", "", "Este produto é bom",10);
        Produto prod3 = new Produto("Celular", "", "Este produto é bom",10);
        Produto prod4 = new Produto("Panela", "", "Este produto é bom",10);
        produtosDestaque.add(prod);
        produtosDestaque.add(prod2);
        produtosDestaque.add(prod3);
        produtosDestaque.add(prod4);
        adapterListaProdutosDestaque.notifyDataSetChanged();
    }
}
