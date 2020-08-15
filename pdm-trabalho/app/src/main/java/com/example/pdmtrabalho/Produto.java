package com.example.pdmtrabalho;

import java.io.Serializable;

public class Produto implements Serializable {

    private String titulo;
    private String imgUrl;
    private String descricao;
    private double preco;

    public Produto(String titulo, String imgUrl, String descricao, double preco) {
        this.titulo = titulo;
        this.imgUrl = imgUrl;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preço) {
        this.preco = preco;
    }
}
