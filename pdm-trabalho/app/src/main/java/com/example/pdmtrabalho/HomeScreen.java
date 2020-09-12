package com.example.pdmtrabalho;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;

public class HomeScreen extends AppCompatActivity {

    private RecyclerView listaCategorias;
    private RecyclerView listaProdutosDestaque;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    private ArrayList<Categoria> categoriasRepo = new ArrayList<Categoria>();
    private AdapterListaCategorias adapterListaCategorias;

    private ArrayList<Produto> produtosDestaque = new ArrayList<Produto>();
    private AdapterListaProdutosDestaque adapterListaProdutosDestaque;

    private DatabaseReference db = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth usuarios = FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        editor = sharedPreferences.edit();

        listaCategorias = findViewById(R.id.listaCategorias);
        listaProdutosDestaque = findViewById(R.id.listaProdutosDestaque);

        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext());
        GridLayoutManager gm = new GridLayoutManager(getApplicationContext(), 2);

        adapterListaCategorias = new AdapterListaCategorias(categoriasRepo);
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
                        categoriaScreen.putExtra("categoria", categoriasRepo.get(position));
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

        db.addValueEventListener(new EscutadorFirebase());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();

        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        System.out.println("Logout: " + item.getItemId() + " " + R.id.menLogout);
        switch (item.getItemId()) {
            case R.id.menLogout:
                editor.putString("UID", "");
                editor.commit();
                usuarios.signOut();
                Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i1);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class EscutadorFirebase implements ValueEventListener {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if ( dataSnapshot.exists() ) {
                for(Iterator<DataSnapshot> catObj = dataSnapshot.getChildren().iterator(); catObj.hasNext();){
                    String titulo = "";
                    String imagemUrl = "";
                    ArrayList<Produto> produtos = new ArrayList<>();
                    DataSnapshot catObjNext = catObj.next();
                    for(Iterator<DataSnapshot> catDataIter = catObjNext.getChildren().iterator(); catDataIter.hasNext();){
                        DataSnapshot catData = catDataIter.next();
                        String key = catData.getKey();
                        if(key.equals("titulo")){
                            titulo = catData.getValue(String.class);
                        } else if(key.equals("imagemUrl")){
                            imagemUrl = catData.getValue(String.class);
                        } else if (key.equals("produtos")){
                            for(Iterator<DataSnapshot> prodArrDataIter = catData.getChildren().iterator(); prodArrDataIter.hasNext();){
                                String prodTitulo = "";
                                String prodDescricao = "";
                                String prodImagemUrl = "";
                                double prodPreco = 0;
                                boolean prodDestaque = false;
                                DataSnapshot prodArrDataIterNext = prodArrDataIter.next();
                                for(Iterator<DataSnapshot> prodDataIter = prodArrDataIterNext.getChildren().iterator(); prodDataIter.hasNext();){
                                    DataSnapshot prodData = prodDataIter.next();
                                    String prodKey = prodData.getKey();
                                    if(prodKey.equals("titulo")){
                                        prodTitulo = prodData.getValue(String.class);
                                    } else if(prodKey.equals("imagemUrl")){
                                        prodImagemUrl = prodData.getValue(String.class);
                                    } else if (prodKey.equals("descricao")) {
                                        prodDescricao = prodData.getValue(String.class);
                                    } else if (prodKey.equals("preco")){
                                        prodPreco = prodData.getValue(Double.class);
                                    } else if (prodKey.equals("destaque")){
                                        prodDestaque = prodData.getValue(Boolean.class);
                                    }
                                }
                                Produto prod = new Produto(prodTitulo, prodImagemUrl, prodDescricao, prodPreco);
                                produtos.add(prod);
                                if(prodDestaque) {
                                    produtosDestaque.add(prod);
                                }
                            }
                        }
                    }
                    categoriasRepo.add(new Categoria(titulo, imagemUrl, produtos));
                }

            }
            Repositorio.getInstance().setCategorias(categoriasRepo);
            categoriasRepo = Repositorio.getInstance().getCategorias();
            adapterListaProdutosDestaque.notifyDataSetChanged();
            adapterListaCategorias.notifyDataSetChanged();
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    }

}
