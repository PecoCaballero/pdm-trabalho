package com.example.pdmtrabalho;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterListaProdutosDestaque extends  RecyclerView.Adapter<AdapterListaProdutosDestaque.GuardadorItemLista> {

    private ArrayList<Produto> produtosDestaque;

    public AdapterListaProdutosDestaque(ArrayList<Produto> produtosDestaque){
        this.produtosDestaque = produtosDestaque;
    }

    @Override
    public GuardadorItemLista onCreateViewHolder(ViewGroup viewGroup, int i){

        LayoutInflater li = LayoutInflater.from(viewGroup.getContext());

        View itemLista = li.inflate(R.layout.item_produto, viewGroup, false);


        return new GuardadorItemLista(itemLista);
    }

    @Override
    public void onBindViewHolder(GuardadorItemLista guardadorItemLista, int position){
        guardadorItemLista.lblTitulo.setText( produtosDestaque.get(position).getTitulo() );
        guardadorItemLista.lblPreco.setText( "R$ " + Double.toString(produtosDestaque.get(position).getPreco()) );
    }

    @Override
    public int getItemCount(){
        return produtosDestaque.size();
    }

    public class GuardadorItemLista extends RecyclerView.ViewHolder {

        private TextView lblTitulo;
        private TextView lblPreco;

        public GuardadorItemLista(View itemView) {
            super(itemView);

            this.lblTitulo = itemView.findViewById(R.id.lblTituloCategoria);
            this.lblPreco = itemView.findViewById(R.id.lblPreco);
        }

    }

}
