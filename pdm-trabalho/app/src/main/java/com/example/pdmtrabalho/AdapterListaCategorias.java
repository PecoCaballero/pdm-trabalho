package com.example.pdmtrabalho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListaCategorias extends  RecyclerView.Adapter<AdapterListaCategorias.GuardadorItemLista> {

    private ArrayList<Categoria> categorias;

    public AdapterListaCategorias(ArrayList<Categoria> categorias){
        this.categorias = categorias;
    }

    @Override
    public GuardadorItemLista onCreateViewHolder(ViewGroup viewGroup, int i){

        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());

        View itemLista = li.inflate(R.layout.item_categoria, viewGroup, false);

        return new GuardadorItemLista(itemLista);
    }

    @Override
    public void onBindViewHolder(GuardadorItemLista guardadorItemLista, int position){
        guardadorItemLista.lblTitulo.setText( categorias.get(position).getTitle() );
    }

    @Override
    public int getItemCount(){
        return categorias.size();
    }

    public class GuardadorItemLista extends RecyclerView.ViewHolder {

        private TextView lblTitulo;

        public GuardadorItemLista(View itemView) {
            super(itemView);

            this.lblTitulo = itemView.findViewById(R.id.lblTituloCategoria);
        }

    }


}
