package com.ufpi.estagio.apphealth.ConsultaAvaliacao_tela;

/**
 * Created by lucas on 13/03/2016.
 */
public class ItemCard_Consulta {
    String titulo, conteudo;

    public ItemCard_Consulta(){

    }
    public ItemCard_Consulta(String titulo,String conteudo){
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
