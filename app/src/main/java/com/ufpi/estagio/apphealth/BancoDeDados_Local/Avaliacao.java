package com.ufpi.estagio.apphealth.BancoDeDados_Local;

/**
 * Created by lucas on 14/03/2016.
 */
public class Avaliacao {
    Long ID, ID_Avaliado, ID_Avaliador;
    String status_Envio;
    float teste_01, teste_02, teste_03, teste_04, teste_05, teste_06, teste_07, teste_08;

    public Avaliacao() {

    }

    public Avaliacao(Long ID, Long ID_Avaliado, Long ID_Avaliador, float teste_01,float teste_02,  float teste_03, float teste_04,
                     float teste_05, float teste_06, float teste_07, float teste_08, String status_Envio) {
        this.teste_02 = teste_02;
        this.ID = ID;
        this.ID_Avaliado = ID_Avaliado;
        this.ID_Avaliador = ID_Avaliador;
        this.status_Envio = status_Envio;
        this.teste_01 = teste_01;
        this.teste_03 = teste_03;
        this.teste_04 = teste_04;
        this.teste_05 = teste_05;
        this.teste_06 = teste_06;
        this.teste_07 = teste_07;
        this.teste_08 = teste_08;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getID_Avaliado() {
        return ID_Avaliado;
    }

    public void setID_Avaliado(Long ID_Avaliado) {
        this.ID_Avaliado = ID_Avaliado;
    }

    public Long getID_Avaliador() {
        return ID_Avaliador;
    }

    public void setID_Avaliador(Long ID_Avaliador) {
        this.ID_Avaliador = ID_Avaliador;
    }

    public String getStatus_Envio() {
        return status_Envio;
    }

    public void setStatus_Envio(String status_Envio) {
        this.status_Envio = status_Envio;
    }

    public float getTeste_01() {
        return teste_01;
    }

    public void setTeste_01(float teste_01) {
        this.teste_01 = teste_01;
    }

    public float getTeste_02() {
        return teste_02;
    }

    public void setTeste_02(float teste_02) {
        this.teste_02 = teste_02;
    }

    public float getTeste_03() {
        return teste_03;
    }

    public void setTeste_03(float teste_03) {
        this.teste_03 = teste_03;
    }

    public float getTeste_04() {
        return teste_04;
    }

    public void setTeste_04(float teste_04) {
        this.teste_04 = teste_04;
    }

    public float getTeste_05() {
        return teste_05;
    }

    public void setTeste_05(float teste_05) {
        this.teste_05 = teste_05;
    }

    public float getTeste_06() {
        return teste_06;
    }

    public void setTeste_06(float teste_06) {
        this.teste_06 = teste_06;
    }

    public float getTeste_07() {
        return teste_07;
    }

    public void setTeste_07(float teste_07) {
        this.teste_07 = teste_07;
    }

    public float getTeste_08() {
        return teste_08;
    }

    public void setTeste_08(float teste_08) {
        this.teste_08 = teste_08;
    }
}
