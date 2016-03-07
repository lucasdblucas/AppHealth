package com.ufpi.estagio.apphealth.Avaliacoes_tela;

/**
 * Created by lucas on 23/02/2016.
 */
public class ItemLinha {
    private String nome_avaliado;
    private int profile_pic_ID;
    //private String status_avaliacao;

    private String status_envio_cliente;

    public ItemLinha(String nome_avaliado, int profile_pic_ID, String status_envio_cliente){
        this.nome_avaliado = nome_avaliado;
        this.profile_pic_ID = profile_pic_ID;
        this.status_envio_cliente = status_envio_cliente;
    }

    public String getNome_avaliado() {
        return nome_avaliado;
    }

    public void setNome_avaliado(String nome_avaliado) {
        this.nome_avaliado = nome_avaliado;
    }

    public int getProfile_pic_ID() {
        return profile_pic_ID;
    }

    public void setProfile_pic_ID(int profile_pic_ID) {
        this.profile_pic_ID = profile_pic_ID;
    }

    public String getStatus_envio_cliente() {
        return status_envio_cliente;
    }

    public void setStatus_envio_cliente(String status_envio_cliente) {
        this.status_envio_cliente = status_envio_cliente;
    }
}
