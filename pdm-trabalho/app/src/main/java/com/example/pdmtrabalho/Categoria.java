package com.example.pdmtrabalho;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {

    private String titulo;
    private String imagemUrl;
    private ArrayList<Produto> produtos;

    public Categoria(String titulo, String imagemUrl, ArrayList<Produto> produtos) {
        this.titulo = titulo;
        this.imagemUrl = imagemUrl;
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }
}
