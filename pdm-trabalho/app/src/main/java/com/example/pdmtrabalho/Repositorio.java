package com.example.pdmtrabalho;

import java.util.ArrayList;

public class Repositorio {


    private static Repositorio instance = null;

    public ArrayList<Categoria> categorias;

    private Repositorio() {
        categorias = new ArrayList<>();
    }

    public static Repositorio getInstance(){
        if(instance == null){
            instance = new Repositorio();
        }
        return instance;
    }

    public ArrayList<Categoria> getCategorias() {
        return instance.categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        instance.categorias = categorias;
    }
}
