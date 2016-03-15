package com.ufpi.estagio.apphealth.BancoDeDados_Local;

/**
 * Created by lucas on 14/03/2016.
 */
public class Usuario {
    private String nome;
    private String senha;
    private Long ID;

    public Usuario(){

    }
    public Usuario (String nome, String senha, Long ID){
        this.nome = nome;
        this.senha = senha;
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
}
