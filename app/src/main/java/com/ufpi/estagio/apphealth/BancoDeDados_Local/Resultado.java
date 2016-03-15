package com.ufpi.estagio.apphealth.BancoDeDados_Local;

/**
 * Created by lucas on 14/03/2016.
 */
public class Resultado {

    Long ID, ID_avaliado, ID_avaliador, ID_avaliacao;
    String imc, teste_01, teste_02, teste_03, teste_04, teste_05, teste_06, teste_07, teste_08;

    public Resultado(){

    }

    public Resultado(Long ID, Long ID_avaliado, Long ID_avaliador, Long ID_avaliacao, String imc,
                     String teste_01, String teste_02, String teste_03, String teste_04, String teste_05,
                     String teste_06, String teste_07, String teste_08) {
        this.ID = ID;
        this.ID_avaliado = ID_avaliado;
        this.ID_avaliador = ID_avaliador;
        this.ID_avaliacao = ID_avaliacao;
        this.imc = imc;
        this.teste_01 = teste_01;
        this.teste_02 = teste_02;
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

    public Long getID_avaliado() {
        return ID_avaliado;
    }

    public void setID_avaliado(Long ID_avaliado) {
        this.ID_avaliado = ID_avaliado;
    }

    public Long getID_avaliador() {
        return ID_avaliador;
    }

    public void setID_avaliador(Long ID_avaliador) {
        this.ID_avaliador = ID_avaliador;
    }

    public Long getID_avaliacao() {
        return ID_avaliacao;
    }

    public void setID_avaliacao(Long ID_avaliacao) {
        this.ID_avaliacao = ID_avaliacao;
    }

    public String getImc() {
        return imc;
    }

    public void setImc(String imc) {
        this.imc = imc;
    }

    public String getTeste_01() {
        return teste_01;
    }

    public void setTeste_01(String teste_01) {
        this.teste_01 = teste_01;
    }

    public String getTeste_02() {
        return teste_02;
    }

    public void setTeste_02(String teste_02) {
        this.teste_02 = teste_02;
    }

    public String getTeste_03() {
        return teste_03;
    }

    public void setTeste_03(String teste_03) {
        this.teste_03 = teste_03;
    }

    public String getTeste_04() {
        return teste_04;
    }

    public void setTeste_04(String teste_04) {
        this.teste_04 = teste_04;
    }

    public String getTeste_05() {
        return teste_05;
    }

    public void setTeste_05(String teste_05) {
        this.teste_05 = teste_05;
    }

    public String getTeste_06() {
        return teste_06;
    }

    public void setTeste_06(String teste_06) {
        this.teste_06 = teste_06;
    }

    public String getTeste_07() {
        return teste_07;
    }

    public void setTeste_07(String teste_07) {
        this.teste_07 = teste_07;
    }

    public String getTeste_08() {
        return teste_08;
    }

    public void setTeste_08(String teste_08) {
        this.teste_08 = teste_08;
    }
}
