package com.ufpi.estagio.apphealth.BancoDeDados_Local;

/**
 * Created by lucas on 14/03/2016.
 */
public class Avaliado {
    Long ID;
    String nome_avaliado, sexo, estado_fisico;
    float altura, peso;
    int idade;

    public Avaliado(){

    }
    public Avaliado(Long ID, String nome_avaliado, String sexo, String estado_fisico, float altura, float peso, int idade) {
        this.ID = ID;
        this.nome_avaliado = nome_avaliado;
        this.sexo = sexo;
        this.estado_fisico = estado_fisico;
        this.altura = altura;
        this.peso = peso;
        this.idade = idade;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNome_avaliado() {
        return nome_avaliado;
    }

    public void setNome_avaliado(String nome_avaliado) {
        this.nome_avaliado = nome_avaliado;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstado_fisico() {
        return estado_fisico;
    }

    public void setEstado_fisico(String estado_fisico) {
        this.estado_fisico = estado_fisico;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
