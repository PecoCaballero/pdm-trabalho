package com.example.pdmtrabalho;

import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable {

    private String title;
    private String imageUrl;
    private ArrayList<Produto> produtos;

    public Categoria(String title, String imageUrl, ArrayList<Produto> produtos) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.produtos = produtos;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
