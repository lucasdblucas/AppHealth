package com.ufpi.estagio.apphealth;

/**
 * Created by lucas on 03/03/2016.
 */
public class ItemCard {
    String titulo;
    String conteudo;

    public ItemCard(){}
    public ItemCard(String titulo, String conteudo){
        this.titulo = titulo;
        this.conteudo = conteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
