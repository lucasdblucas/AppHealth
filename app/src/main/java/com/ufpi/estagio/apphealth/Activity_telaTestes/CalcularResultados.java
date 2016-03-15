package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.content.Context;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliacao;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliado;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Resultado;

/**
 * Created by lucas on 14/03/2016.
 */
public class CalcularResultados {

    Resultado resultado;
    Avaliacao avaliacao;
    Avaliado avaliado;
    Conver_App_Banco banco;

    public CalcularResultados( Context context, Avaliacao avaliacao){
        banco = new Conver_App_Banco(context);
        resultado = new Resultado();
        this.avaliacao = avaliacao;
        this.avaliado = banco.consultarAvaliadoByID(avaliacao);

        calcular();
    }

    public void calcular(){
        resultado.setImc(calcular_imc());
        resultado.setTeste_01(calcular_teste_01());
        resultado.setTeste_02(calcular_teste_02());
        resultado.setTeste_03(calcular_teste_03());
        resultado.setTeste_04(calcular_teste_04());
        resultado.setTeste_05(calcular_teste_05());
        resultado.setTeste_06(calcular_teste_06());
        resultado.setTeste_07(calcular_teste_07());
        resultado.setTeste_08(calcular_teste_08());
    }

    public String calcular_imc(){
        double imc;
        imc = (avaliado.getPeso() / Math.pow(avaliado.getAltura(), 2) );

        if(avaliado.getSexo().equals("H")){
            if(imc < 24.0) return "abaixo de 24.0"; //adicionado pq o livro não trata essa possibilidade
            if(imc >= 24.0 && imc < 28.0) return "normal";
            if(imc >= 28.0 && imc <= 31.0) return "moderadamente obeso";
            if(imc > 31.0) return "severamente obeso";
        }
        if(avaliado.getSexo().equals("M")){
            if(imc < 23.0) return "abaixo de 23.0"; //adicionado pq o livro não trata essa possibilidade
            if(imc >= 23.0 && imc < 27.0) return "normal";
            if(imc >= 27.0 && imc <= 32.0) return "moderadamente obesa";
            if(imc > 32.0) return "severamente obesa";
        }

        return "erro no imc";
    }

    //classificação da relaão da citura para o quadril
    // Observação de que a população alvo esta entre 50 e 69. somente
    public String calcular_teste_01(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() < 60){
                if(avaliacao.getTeste_01() >= 0.97 && avaliacao.getTeste_01() <= 1.02) return "risco alto";
                if(avaliacao.getTeste_01() > 1.02) return "risco muito alto";
            }
            if(avaliado.getIdade() >= 60 && avaliado.getIdade() <= 94){ // avaliado.getIdade() <= 69, modificado pq o livro não tratava de outras possibilidades
                if(avaliacao.getTeste_01() >= 0.99 && avaliacao.getTeste_01() <= 1.03) return "risco alto";
                if(avaliacao.getTeste_01() > 1.03) return "risco muito alto";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() < 60){
                if(avaliacao.getTeste_01() >= 0.82 && avaliacao.getTeste_01() <= 0.88) return "risco alto";
                if(avaliacao.getTeste_01() > 0.88) return "risco muito alto";
            }
            if(avaliado.getIdade() >= 60 && avaliado.getIdade() <= 94){// avaliado.getIdade() <= 69, modificado pq o livro não tratava de outras possibilidades
                if(avaliacao.getTeste_01() >= 0.84 && avaliacao.getTeste_01() <= 0.90) return "risco alto";
                if(avaliacao.getTeste_01() > 0.90) return "risco muito alto";
            }
        }
        return "erro teste_01 RCQ";
    }

    public String calcular_teste_02(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <=64){// era para ser avaliado.getIdade() >= 60, mas o livro não trata idades menor que 60
                if(avaliacao.getTeste_02() < 597.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 597.0 && avaliacao.getTeste_02() < 652.0) return "fraco";
                if(avaliacao.getTeste_02() >= 652.0 && avaliacao.getTeste_02() < 698.0) return "regular";
                if(avaliacao.getTeste_02() >= 698.0 && avaliacao.getTeste_02() < 752.0) return "bom";
                if(avaliacao.getTeste_02() >= 752.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_02() < 544.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 544.0 && avaliacao.getTeste_02() < 606.0) return "fraco";
                if(avaliacao.getTeste_02() >= 606.0 && avaliacao.getTeste_02() < 658.0) return "regular";
                if(avaliacao.getTeste_02() >= 658.0 && avaliacao.getTeste_02() < 719.0) return "bom";
                if(avaliacao.getTeste_02() >= 719.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_02() < 526.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 526.0 && avaliacao.getTeste_02() < 587.0) return "fraco";
                if(avaliacao.getTeste_02() >= 587.0 && avaliacao.getTeste_02() < 639.0) return "regular";
                if(avaliacao.getTeste_02() >= 639.0 && avaliacao.getTeste_02() < 699.0) return "bom";
                if(avaliacao.getTeste_02() >= 699.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_02() < 449.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 449.0 && avaliacao.getTeste_02() < 525.0) return "fraco";
                if(avaliacao.getTeste_02() >= 525.0 && avaliacao.getTeste_02() < 587.0) return "regular";
                if(avaliacao.getTeste_02() >= 587.0 && avaliacao.getTeste_02() < 662.0) return "bom";
                if(avaliacao.getTeste_02() >= 662.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_02() < 423.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 423.0 && avaliacao.getTeste_02() < 495.0) return "fraco";
                if(avaliacao.getTeste_02() >= 495.0 && avaliacao.getTeste_02() < 555.0) return "regular";
                if(avaliacao.getTeste_02() >= 555.0 && avaliacao.getTeste_02() < 626.0) return "bom";
                if(avaliacao.getTeste_02() >= 626.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_02() < 358.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 358.0 && avaliacao.getTeste_02() < 443.0) return "fraco";
                if(avaliacao.getTeste_02() >= 443.0 && avaliacao.getTeste_02() < 513.0) return "regular";
                if(avaliacao.getTeste_02() >= 513.0 && avaliacao.getTeste_02() < 597.0) return "bom";
                if(avaliacao.getTeste_02() >= 597.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_02() < 279.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 279.0 && avaliacao.getTeste_02() < 367.0) return "fraco";
                if(avaliacao.getTeste_02() >= 367.0 && avaliacao.getTeste_02() < 441.0) return "regular";
                if(avaliacao.getTeste_02() >= 441.0 && avaliacao.getTeste_02() < 528.0) return "bom";
                if(avaliacao.getTeste_02() >= 528.0) return "muito bom";
            }

        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <=64){// era para ser avaliado.getIdade() >= 60, mas o livro não trata idades menor que 60
                if(avaliacao.getTeste_02() < 532.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 532.0 && avaliacao.getTeste_02() < 583.0) return "fraco";
                if(avaliacao.getTeste_02() >= 583.0 && avaliacao.getTeste_02() < 625.0) return "regular";
                if(avaliacao.getTeste_02() >= 625.0 && avaliacao.getTeste_02() < 675.0) return "bom";
                if(avaliacao.getTeste_02() >= 675.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_02() < 483.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 483.0 && avaliacao.getTeste_02() < 544.0) return "fraco";
                if(avaliacao.getTeste_02() >= 544.0 && avaliacao.getTeste_02() < 594.0) return "regular";
                if(avaliacao.getTeste_02() >= 594.0 && avaliacao.getTeste_02() < 654.0) return "bom";
                if(avaliacao.getTeste_02() >= 654.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_02() < 466.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 466.0 && avaliacao.getTeste_02() < 525.0) return "fraco";
                if(avaliacao.getTeste_02() >= 525.0 && avaliacao.getTeste_02() < 573.0) return "regular";
                if(avaliacao.getTeste_02() >= 573.0 && avaliacao.getTeste_02() < 631.0) return "bom";
                if(avaliacao.getTeste_02() >= 631.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_02() < 413.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 413.0 && avaliacao.getTeste_02() < 481.0) return "fraco";
                if(avaliacao.getTeste_02() >= 481.0 && avaliacao.getTeste_02() < 539.0) return "regular";
                if(avaliacao.getTeste_02() >= 539.0 && avaliacao.getTeste_02() < 606.0) return "bom";
                if(avaliacao.getTeste_02() >= 606.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_02() < 364.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 364.0 && avaliacao.getTeste_02() < 434.0) return "fraco";
                if(avaliacao.getTeste_02() >= 434.0 && avaliacao.getTeste_02() < 492.0) return "regular";
                if(avaliacao.getTeste_02() >= 492.0 && avaliacao.getTeste_02() < 561.0) return "bom";
                if(avaliacao.getTeste_02() >= 561.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_02() < 318.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 318.0 && avaliacao.getTeste_02() < 395.0) return "fraco";
                if(avaliacao.getTeste_02() >= 395.0 && avaliacao.getTeste_02() < 459.0) return "regular";
                if(avaliacao.getTeste_02() >= 459.0 && avaliacao.getTeste_02() < 535.0) return "bom";
                if(avaliacao.getTeste_02() >= 535.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_02() < 251.0) return "muito fraco";
                if(avaliacao.getTeste_02() >= 251.0 && avaliacao.getTeste_02() < 327.0) return "fraco";
                if(avaliacao.getTeste_02() >= 327.0 && avaliacao.getTeste_02() < 389.0) return "regular";
                if(avaliacao.getTeste_02() >= 389.0 && avaliacao.getTeste_02() < 464.0) return "bom";
                if(avaliacao.getTeste_02() >= 464.0) return "muito bom";
            }

        }
        return "erro teste_01 teste de caminhada de 6 minutos";
    }

    public String calcular_teste_03(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_03() < 87.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 87.0 && avaliacao.getTeste_03() <= 115.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 115.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_03() < 86.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 86.0 && avaliacao.getTeste_03() <= 116.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 116.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_03() < 80.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 80.0 && avaliacao.getTeste_03() <= 110.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 110.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_03() < 73.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 73.0 && avaliacao.getTeste_03() <= 109.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 109.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_03() < 71.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 71.0 && avaliacao.getTeste_03() <= 103.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 103.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_03() < 59.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 59.0 && avaliacao.getTeste_03() <= 91.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 91.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_03() < 52.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 52.0 && avaliacao.getTeste_03() <= 86.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 86.0) return "acima do adequado para idade";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_03() < 75.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 75.0 && avaliacao.getTeste_03() <= 1107.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 107.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_03() < 73.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 73.0 && avaliacao.getTeste_03() <= 107.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 107.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_03() < 68.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 68.0 && avaliacao.getTeste_03() <= 100.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 100.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_03() < 68.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 68.0 && avaliacao.getTeste_03() <= 100.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 100.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_03() < 60.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 60.0 && avaliacao.getTeste_03() <= 91.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 91.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_03() < 55.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 55.0 && avaliacao.getTeste_03() <= 85.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 85.0) return "acima do adequado para idade";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_03() < 44.0 ) return "abaixo do adequado para idade";
                if(avaliacao.getTeste_03() >= 44.0 && avaliacao.getTeste_03() <= 72.0) return "adequado para idade";
                if(avaliacao.getTeste_03() > 72.0) return "acima do adequado para idade";
            }
        }
        return "erro teste_02 teste da marcha estacionaria de 2 minutos";
    }

    public String calcular_teste_04(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_04() > 5.8 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 5.8 && avaliacao.getTeste_04() > 4.9) return "fraco";
                if(avaliacao.getTeste_04() <= 4.9 && avaliacao.getTeste_04() > 4.3) return "regular";
                if(avaliacao.getTeste_04() <= 4.3 && avaliacao.getTeste_04() > 3.5) return "bom";
                if(avaliacao.getTeste_04() <= 3.5) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_04() > 6.1 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 6.1 && avaliacao.getTeste_04() > 5.3) return "fraco";
                if(avaliacao.getTeste_04() <= 5.3 && avaliacao.getTeste_04() > 4.7) return "regular";
                if(avaliacao.getTeste_04() <= 4.7 && avaliacao.getTeste_04() > 4.0) return "bom";
                if(avaliacao.getTeste_04() <= 4.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_04() > 6.4 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 6.4 && avaliacao.getTeste_04() > 5.5) return "fraco";
                if(avaliacao.getTeste_04() <= 5.5 && avaliacao.getTeste_04() > 7.9) return "regular";
                if(avaliacao.getTeste_04() <= 4.9 && avaliacao.getTeste_04() > 4.1) return "bom";
                if(avaliacao.getTeste_04() <= 4.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_04() > 7.5 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 7.5 && avaliacao.getTeste_04() > 6.3) return "fraco";
                if(avaliacao.getTeste_04() <= 6.3 && avaliacao.getTeste_04() > 5.3) return "regular";
                if(avaliacao.getTeste_04() <= 5.3 && avaliacao.getTeste_04() > 4.2) return "bom";
                if(avaliacao.getTeste_04() <= 4.2) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_04() > 7.9 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 7.9 && avaliacao.getTeste_04() > 6.8) return "fraco";
                if(avaliacao.getTeste_04() <= 6.8 && avaliacao.getTeste_04() > 5.9) return "regular";
                if(avaliacao.getTeste_04() <= 5.9 && avaliacao.getTeste_04() > 4.8) return "bom";
                if(avaliacao.getTeste_04() <= 4.8) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_04() > 9.4 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 9.4 && avaliacao.getTeste_04() > 7.8) return "fraco";
                if(avaliacao.getTeste_04() <= 7.8 && avaliacao.getTeste_04() > 6.4) return "regular";
                if(avaliacao.getTeste_04() <= 6.4 && avaliacao.getTeste_04() > 4.9) return "bom";
                if(avaliacao.getTeste_04() <= 4.9) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_04() > 10.5 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 10.5 && avaliacao.getTeste_04() > 8.7) return "fraco";
                if(avaliacao.getTeste_04() <= 8.7 && avaliacao.getTeste_04() > 7.3) return "regular";
                if(avaliacao.getTeste_04() <= 7.3 && avaliacao.getTeste_04() > 5.6) return "bom";
                if(avaliacao.getTeste_04() <= 5.6) return "muito bom";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_04() > 6.2 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 6.2 && avaliacao.getTeste_04() > 5.4) return "fraco";
                if(avaliacao.getTeste_04() <= 5.4 && avaliacao.getTeste_04() > 4.8) return "regular";
                if(avaliacao.getTeste_04() <= 4.8 && avaliacao.getTeste_04() > 4.1) return "bom";
                if(avaliacao.getTeste_04() <= 4.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_04() > 6.6 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 6.6 && avaliacao.getTeste_04() > 5.8) return "fraco";
                if(avaliacao.getTeste_04() <= 5.8 && avaliacao.getTeste_04() > 5.2) return "regular";
                if(avaliacao.getTeste_04() <= 5.2 && avaliacao.getTeste_04() > 4.5) return "bom";
                if(avaliacao.getTeste_04() <= 4.5) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_04() > 7.3 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 7.3 && avaliacao.getTeste_04() > 6.3) return "fraco";
                if(avaliacao.getTeste_04() <= 6.3 && avaliacao.getTeste_04() > 5.5) return "regular";
                if(avaliacao.getTeste_04() <= 5.5 && avaliacao.getTeste_04() > 4.6) return "bom";
                if(avaliacao.getTeste_04() <= 4.6) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_04() > 7.6 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 7.6 && avaliacao.getTeste_04() > 6.6) return "fraco";
                if(avaliacao.getTeste_04() <= 6.6 && avaliacao.getTeste_04() > 5.8) return "regular";
                if(avaliacao.getTeste_04() <= 5.8 && avaliacao.getTeste_04() > 4.9) return "bom";
                if(avaliacao.getTeste_04() <= 4.9) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_04() > 9.0 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 9.0 && avaliacao.getTeste_04() > 7.7) return "fraco";
                if(avaliacao.getTeste_04() <= 7.7 && avaliacao.getTeste_04() > 6.6) return "regular";
                if(avaliacao.getTeste_04() <= 6.6 && avaliacao.getTeste_04() > 5.3) return "bom";
                if(avaliacao.getTeste_04() <= 5.3) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_04() > 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 10.0 && avaliacao.getTeste_04() > 8.4) return "fraco";
                if(avaliacao.getTeste_04() <= 8.4 && avaliacao.getTeste_04() > 7.2) return "regular";
                if(avaliacao.getTeste_04() <= 7.2 && avaliacao.getTeste_04() > 5.7) return "bom";
                if(avaliacao.getTeste_04() <= 5.7) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_04() > 12.1 ) return "muito fraco";
                if(avaliacao.getTeste_04() <= 12.1 && avaliacao.getTeste_04() > 10.1) return "fraco";
                if(avaliacao.getTeste_04() <= 10.1 && avaliacao.getTeste_04() > 8.5) return "regular";
                if(avaliacao.getTeste_04() <= 8.5 && avaliacao.getTeste_04() > 6.6) return "bom";
                if(avaliacao.getTeste_04() <= 6.6) return "muito bom";
            }
        }
        return "erro teste_04 teste da levantar caminhar e sentar";
    }

    public String calcular_teste_05(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_05() < 15.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 15.0 && avaliacao.getTeste_05() < 19.0) return "fraco";
                if(avaliacao.getTeste_05() >= 19.0 && avaliacao.getTeste_05() < 21.0) return "regular";
                if(avaliacao.getTeste_05() >= 21.0 && avaliacao.getTeste_05() < 24.0) return "bom";
                if(avaliacao.getTeste_05() >= 24.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_05() < 14.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 14.0 && avaliacao.getTeste_05() < 18.0) return "fraco";
                if(avaliacao.getTeste_05() >= 18.0 && avaliacao.getTeste_05() < 21.0) return "regular";
                if(avaliacao.getTeste_05() >= 21.0 && avaliacao.getTeste_05() < 24.0) return "bom";
                if(avaliacao.getTeste_05() >= 24.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_05() < 13.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 13.0 && avaliacao.getTeste_05() < 17.0) return "fraco";
                if(avaliacao.getTeste_05() >= 17.0 && avaliacao.getTeste_05() < 20.0) return "regular";
                if(avaliacao.getTeste_05() >= 20.0 && avaliacao.getTeste_05() < 23.0) return "bom";
                if(avaliacao.getTeste_05() >= 23.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_05() < 12.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 12.0 && avaliacao.getTeste_05() < 16.0) return "fraco";
                if(avaliacao.getTeste_05() >= 16.0 && avaliacao.getTeste_05() < 18.0) return "regular";
                if(avaliacao.getTeste_05() >= 18.0 && avaliacao.getTeste_05() < 21.0) return "bom";
                if(avaliacao.getTeste_05() >= 21.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_05() < 12.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 12.0 && avaliacao.getTeste_05() < 15.0) return "fraco";
                if(avaliacao.getTeste_05() >= 16.0 && avaliacao.getTeste_05() < 18.0) return "regular";
                if(avaliacao.getTeste_05() >= 18.0 && avaliacao.getTeste_05() < 21.0) return "bom";
                if(avaliacao.getTeste_05() >= 21.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_05() < 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 10.0 && avaliacao.getTeste_05() < 14.0) return "fraco";
                if(avaliacao.getTeste_05() >= 14.0 && avaliacao.getTeste_05() < 16.0) return "regular";
                if(avaliacao.getTeste_05() >= 16.0 && avaliacao.getTeste_05() < 18.0) return "bom";
                if(avaliacao.getTeste_05() >= 18.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_05() < 9.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 9.0 && avaliacao.getTeste_05() < 12.0) return "fraco";
                if(avaliacao.getTeste_05() >= 12.0 && avaliacao.getTeste_05() < 14.0) return "regular";
                if(avaliacao.getTeste_05() >= 14.0 && avaliacao.getTeste_05() < 16.0) return "bom";
                if(avaliacao.getTeste_05() >= 16.0) return "muito bom";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_05() < 13.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 13.0 && avaliacao.getTeste_05() < 16.0) return "fraco";
                if(avaliacao.getTeste_05() >= 16.0 && avaliacao.getTeste_05() < 19.0) return "regular";
                if(avaliacao.getTeste_05() >= 19.0 && avaliacao.getTeste_05() < 22.0) return "bom";
                if(avaliacao.getTeste_05() >= 22.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_05() < 11.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 11.0 && avaliacao.getTeste_05() < 15.0) return "fraco";
                if(avaliacao.getTeste_05() >= 15.0 && avaliacao.getTeste_05() < 18.0) return "regular";
                if(avaliacao.getTeste_05() >= 18.0 && avaliacao.getTeste_05() < 21.0) return "bom";
                if(avaliacao.getTeste_05() >= 21.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_05() < 11.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 11.0 && avaliacao.getTeste_05() < 15.0) return "fraco";
                if(avaliacao.getTeste_05() >= 15.0 && avaliacao.getTeste_05() < 17.0) return "regular";
                if(avaliacao.getTeste_05() >= 17.0 && avaliacao.getTeste_05() < 20.0) return "bom";
                if(avaliacao.getTeste_05() >= 20.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_05() < 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 10.0 && avaliacao.getTeste_05() < 14.0) return "fraco";
                if(avaliacao.getTeste_05() >= 14.0 && avaliacao.getTeste_05() < 17.0) return "regular";
                if(avaliacao.getTeste_05() >= 17.0 && avaliacao.getTeste_05() < 19.0) return "bom";
                if(avaliacao.getTeste_05() >= 19.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_05() < 9.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 9.0 && avaliacao.getTeste_05() < 12.0) return "fraco";
                if(avaliacao.getTeste_05() >= 12.0 && avaliacao.getTeste_05() < 15.0) return "regular";
                if(avaliacao.getTeste_05() >= 15.0 && avaliacao.getTeste_05() < 18.0) return "bom";
                if(avaliacao.getTeste_05() >= 18.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_05() < 7.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 7.0 && avaliacao.getTeste_05() < 11.0) return "fraco";
                if(avaliacao.getTeste_05() >= 11.0 && avaliacao.getTeste_05() < 14.0) return "regular";
                if(avaliacao.getTeste_05() >= 14.0 && avaliacao.getTeste_05() < 17.0) return "bom";
                if(avaliacao.getTeste_05() >= 17.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_05() < 6.0 ) return "muito fraco";
                if(avaliacao.getTeste_05() >= 6.0 && avaliacao.getTeste_05() < 10.0) return "fraco";
                if(avaliacao.getTeste_05() >= 10.0 && avaliacao.getTeste_05() < 12.0) return "regular";
                if(avaliacao.getTeste_05() >= 12.0 && avaliacao.getTeste_05() < 15.0) return "bom";
                if(avaliacao.getTeste_05() >= 15.0) return "muito bom";
            }
        }
        return "erro teste_05 test flexao de cotovelo";
    }

    public String calcular_teste_06(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_06() < 13.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 13.0 && avaliacao.getTeste_06() < 16.0) return "fraco";
                if(avaliacao.getTeste_06() >= 16.0 && avaliacao.getTeste_06() < 18.0) return "regular";
                if(avaliacao.getTeste_06() >= 18.0 && avaliacao.getTeste_06() < 21.0) return "bom";
                if(avaliacao.getTeste_06() >= 21.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_06() < 11.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 11.0 && avaliacao.getTeste_06() < 15.0) return "fraco";
                if(avaliacao.getTeste_06() >= 15.0 && avaliacao.getTeste_06() < 17.0) return "regular";
                if(avaliacao.getTeste_06() >= 17.0 && avaliacao.getTeste_06() < 20.0) return "bom";
                if(avaliacao.getTeste_06() >= 20.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_06() < 11.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 11.0 && avaliacao.getTeste_06() < 14.0) return "fraco";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 17.0) return "regular";
                if(avaliacao.getTeste_06() >= 17.0 && avaliacao.getTeste_06() < 19.0) return "bom";
                if(avaliacao.getTeste_06() >= 19.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_06() < 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 10.0 && avaliacao.getTeste_06() < 14.0) return "fraco";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 16.0) return "regular";
                if(avaliacao.getTeste_06() >= 16.0 && avaliacao.getTeste_06() < 19.0) return "bom";
                if(avaliacao.getTeste_06() >= 19.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_06() < 9.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 9.0 && avaliacao.getTeste_06() < 12.0) return "fraco";
                if(avaliacao.getTeste_06() >= 12.0 && avaliacao.getTeste_06() < 14.0) return "regular";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 17.0) return "bom";
                if(avaliacao.getTeste_06() >= 17.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_06() < 7.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 7.0 && avaliacao.getTeste_06() < 11.0) return "fraco";
                if(avaliacao.getTeste_06() >= 11.0 && avaliacao.getTeste_06() < 13.0) return "regular";
                if(avaliacao.getTeste_06() >= 13.0 && avaliacao.getTeste_06() < 16.0) return "bom";
                if(avaliacao.getTeste_06() >= 16.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_06() < 7.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 7.0 && avaliacao.getTeste_06() < 10.0) return "fraco";
                if(avaliacao.getTeste_06() >= 10.0 && avaliacao.getTeste_06() < 12.0) return "regular";
                if(avaliacao.getTeste_06() >= 12.0 && avaliacao.getTeste_06() < 14.0) return "bom";
                if(avaliacao.getTeste_06() >= 14.0) return "muito bom";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_06() < 12.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 12.0 && avaliacao.getTeste_06() < 16.0) return "fraco";
                if(avaliacao.getTeste_06() >= 16.0 && avaliacao.getTeste_06() < 18.0) return "regular";
                if(avaliacao.getTeste_06() >= 18.0 && avaliacao.getTeste_06() < 21.0) return "bom";
                if(avaliacao.getTeste_06() >= 21.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_06() < 12.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 12.0 && avaliacao.getTeste_06() < 15.0) return "fraco";
                if(avaliacao.getTeste_06() >= 15.0 && avaliacao.getTeste_06() < 17.0) return "regular";
                if(avaliacao.getTeste_06() >= 17.0 && avaliacao.getTeste_06() < 20.0) return "bom";
                if(avaliacao.getTeste_06() >= 20.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_06() < 11.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 11.0 && avaliacao.getTeste_06() < 14.0) return "fraco";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 17.0) return "regular";
                if(avaliacao.getTeste_06() >= 17.0 && avaliacao.getTeste_06() < 19.0) return "bom";
                if(avaliacao.getTeste_06() >= 19.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_06() < 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 10.0 && avaliacao.getTeste_06() < 14.0) return "fraco";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 16.0) return "regular";
                if(avaliacao.getTeste_06() >= 16.0 && avaliacao.getTeste_06() < 19.0) return "bom";
                if(avaliacao.getTeste_06() >= 19.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_06() < 10.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 10.0 && avaliacao.getTeste_06() < 13.0) return "fraco";
                if(avaliacao.getTeste_06() >= 13.0 && avaliacao.getTeste_06() < 15.0) return "regular";
                if(avaliacao.getTeste_06() >= 15.0 && avaliacao.getTeste_06() < 17.0) return "bom";
                if(avaliacao.getTeste_06() >= 17.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_06() < 9.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 9.0 && avaliacao.getTeste_06() < 12.0) return "fraco";
                if(avaliacao.getTeste_06() >= 12.0 && avaliacao.getTeste_06() < 14.0) return "regular";
                if(avaliacao.getTeste_06() >= 14.0 && avaliacao.getTeste_06() < 16.0) return "bom";
                if(avaliacao.getTeste_06() >= 16.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_06() < 8.0 ) return "muito fraco";
                if(avaliacao.getTeste_06() >= 8.0 && avaliacao.getTeste_06() < 11.0) return "fraco";
                if(avaliacao.getTeste_06() >= 11.0 && avaliacao.getTeste_06() < 13.0) return "regular";
                if(avaliacao.getTeste_06() >= 13.0 && avaliacao.getTeste_06() < 15.0) return "bom";
                if(avaliacao.getTeste_06() >= 15.0) return "muito bom";
            }
        }
        return "erro teste_06 test de sentar e levantar da cadeira em 30 seg";
    }

    public String calcular_teste_07(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_07() < -3.4 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -3.4 && avaliacao.getTeste_07() < -0.5) return "fraco";
                if(avaliacao.getTeste_07() >= -0.5 && avaliacao.getTeste_07() < 1.9) return "regular";
                if(avaliacao.getTeste_07() >= 1.9 && avaliacao.getTeste_07() < 4.7) return "bom";
                if(avaliacao.getTeste_07() >= 4.7) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_07() < -3.9 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -3.9 && avaliacao.getTeste_07() < -1.0) return "fraco";
                if(avaliacao.getTeste_07() >= -1.0 && avaliacao.getTeste_07() < 1.2) return "regular";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 4.0) return "bom";
                if(avaliacao.getTeste_07() >= 4.0) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_07() < -3.9 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -3.9 && avaliacao.getTeste_07() < -1.1) return "fraco";
                if(avaliacao.getTeste_07() >= -1.1 && avaliacao.getTeste_07() < 1.2) return "regular";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 3.9) return "bom";
                if(avaliacao.getTeste_07() >= 3.9) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_07() < -5.0 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -5.0 && avaliacao.getTeste_07() < -2.2) return "fraco";
                if(avaliacao.getTeste_07() >= -2.2 && avaliacao.getTeste_07() < 0.2) return "regular";
                if(avaliacao.getTeste_07() >= 0.2 && avaliacao.getTeste_07() < 2.9) return "bom";
                if(avaliacao.getTeste_07() >= 2.9) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_07() < -6.2 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -6.2 && avaliacao.getTeste_07() < -3.1) return "fraco";
                if(avaliacao.getTeste_07() >= -3.1 && avaliacao.getTeste_07() < -0.7) return "regular";
                if(avaliacao.getTeste_07() >= -0.7 && avaliacao.getTeste_07() < 2.3) return "bom";
                if(avaliacao.getTeste_07() >= 2.3) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_07() < -5.9 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -5.9 && avaliacao.getTeste_07() < -3.4) return "fraco";
                if(avaliacao.getTeste_07() >= -3.4 && avaliacao.getTeste_07() < -1.2) return "regular";
                if(avaliacao.getTeste_07() >= -1.2 && avaliacao.getTeste_07() < 1.2) return "bom";
                if(avaliacao.getTeste_07() >= 1.2) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_07() < -7.2 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -7.2 && avaliacao.getTeste_07() < -4.6) return "fraco";
                if(avaliacao.getTeste_07() >= -4.6 && avaliacao.getTeste_07() < -2.4) return "regular";
                if(avaliacao.getTeste_07() >= -2.4 && avaliacao.getTeste_07() < 1.1) return "bom";
                if(avaliacao.getTeste_07() >= 1.1) return "muito bom";
            }
        }
        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_07() < -1.3 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.3 && avaliacao.getTeste_07() < 1.2) return "fraco";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 3.2) return "regular";
                if(avaliacao.getTeste_07() >= 3.2 && avaliacao.getTeste_07() < 5.6) return "bom";
                if(avaliacao.getTeste_07() >= 5.6) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_07() < -1.0 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.0 && avaliacao.getTeste_07() < 1.2) return "fraco";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 3.0) return "regular";
                if(avaliacao.getTeste_07() >= 3.0 && avaliacao.getTeste_07() < 5.1) return "bom";
                if(avaliacao.getTeste_07() >= 5.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_07() < -1.7 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.7 && avaliacao.getTeste_07() < 0.6) return "fraco";
                if(avaliacao.getTeste_07() >= 0.6 && avaliacao.getTeste_07() < 2.4) return "regular";
                if(avaliacao.getTeste_07() >= 2.4 && avaliacao.getTeste_07() < 4.6) return "bom";
                if(avaliacao.getTeste_07() >= 4.6) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_07() < -2.0 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -2.0 && avaliacao.getTeste_07() < 0.3) return "fraco";
                if(avaliacao.getTeste_07() >= 0.3 && avaliacao.getTeste_07() < 2.2) return "regular";
                if(avaliacao.getTeste_07() >= 2.2 && avaliacao.getTeste_07() < 4.5) return "bom";
                if(avaliacao.getTeste_07() >= 4.5) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_07() < -2.6 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -2.6 && avaliacao.getTeste_07() < -0.3) return "fraco";
                if(avaliacao.getTeste_07() >= -0.3 && avaliacao.getTeste_07() < 1.5) return "regular";
                if(avaliacao.getTeste_07() >= 1.5 && avaliacao.getTeste_07() < 3.7) return "bom";
                if(avaliacao.getTeste_07() >= 3.7) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_07() < -3.2 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -3.2 && avaliacao.getTeste_07() < -0.9) return "fraco";
                if(avaliacao.getTeste_07() >= -0.9 && avaliacao.getTeste_07() < 0.9) return "regular";
                if(avaliacao.getTeste_07() >= 0.9 && avaliacao.getTeste_07() < 3.1) return "bom";
                if(avaliacao.getTeste_07() >= 3.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_07() < -5.1 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -5.1 && avaliacao.getTeste_07() < -2.6) return "fraco";
                if(avaliacao.getTeste_07() >= -2.6 && avaliacao.getTeste_07() < -0.6) return "regular";
                if(avaliacao.getTeste_07() >= -0.6 && avaliacao.getTeste_07() < 1.8) return "bom";
                if(avaliacao.getTeste_07() >= 1.8) return "muito bom";
            }
        }
        return "erro teste_07 teste de sentar e alcançar";
    }

    public String calcular_teste_08(){
        if(avaliado.getSexo().equals("H")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_08() < -7.4 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -7.4 && avaliacao.getTeste_08() < -4.5) return "fraco";
                if(avaliacao.getTeste_08() >= -4.5 && avaliacao.getTeste_08() < -2.1) return "regular";
                if(avaliacao.getTeste_08() >= -2.1 && avaliacao.getTeste_08() < 0.7) return "bom";
                if(avaliacao.getTeste_08() >= 0.7) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_08() < -8.2 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -8.2 && avaliacao.getTeste_08() < -5.2) return "fraco";
                if(avaliacao.getTeste_08() >= -5.2 && avaliacao.getTeste_08() < -2.8) return "regular";
                if(avaliacao.getTeste_08() >= -2.8 && avaliacao.getTeste_08() < 0.1) return "bom";
                if(avaliacao.getTeste_08() >= 0.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_08() < -8.6 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -8.6 && avaliacao.getTeste_08() < -5.6) return "fraco";
                if(avaliacao.getTeste_08() >= -5.6 && avaliacao.getTeste_08() < -3.2) return "regular";
                if(avaliacao.getTeste_08() >= -3.2 && avaliacao.getTeste_08() < -0.3) return "bom";
                if(avaliacao.getTeste_08() >= -0.3) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_08() < -9.9 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -9.9 && avaliacao.getTeste_08() < -6.8) return "fraco";
                if(avaliacao.getTeste_08() >= -6.8 && avaliacao.getTeste_08() < -4.2) return "regular";
                if(avaliacao.getTeste_08() >= -4.2 && avaliacao.getTeste_08() < -1.2) return "bom";
                if(avaliacao.getTeste_08() >= -1.2) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_08() < -1.05 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -10.5 && avaliacao.getTeste_08() < -7.0) return "fraco";
                if(avaliacao.getTeste_08() >= -7.0 && avaliacao.getTeste_08() < -4.2) return "regular";
                if(avaliacao.getTeste_08() >= -4.2 && avaliacao.getTeste_08() < -1.1) return "bom";
                if(avaliacao.getTeste_08() >= -1.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_08() < -10.2) return "muito fraco";
                if(avaliacao.getTeste_08() >= -10.2 && avaliacao.getTeste_08() < -7.3) return "fraco";
                if(avaliacao.getTeste_08() >= -7.3 && avaliacao.getTeste_08() < -4.9) return "regular";
                if(avaliacao.getTeste_08() >= -4.9 && avaliacao.getTeste_08() < -2.1) return "bom";
                if(avaliacao.getTeste_08() >= -2.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_08() < -11.2 ) return "muito fraco";
                if(avaliacao.getTeste_08() >= -11.2 && avaliacao.getTeste_08() < -8.3) return "fraco";
                if(avaliacao.getTeste_08() >= -8.3 && avaliacao.getTeste_08() < -5.9) return "regular";
                if(avaliacao.getTeste_08() >= -5.9 && avaliacao.getTeste_08() < -3.1) return "bom";
                if(avaliacao.getTeste_08() >= -3.1) return "muito bom";
            }
        }

        //parei aqui


        if(avaliado.getSexo().equals("M")){
            if(avaliado.getIdade() >= 50 && avaliado.getIdade() <= 64){
                if(avaliacao.getTeste_07() < -1.3 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.3 && avaliacao.getTeste_07() < 1.2) return "fraco";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 3.2) return "regular";
                if(avaliacao.getTeste_07() >= 3.2 && avaliacao.getTeste_07() < 5.6) return "bom";
                if(avaliacao.getTeste_07() >= 5.6) return "muito bom";
            }
            if(avaliado.getIdade() >= 65 && avaliado.getIdade() <= 69){
                if(avaliacao.getTeste_07() < -1.0 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.0 && avaliacao.getTeste_07() < 1.2) return "fraco";
                if(avaliacao.getTeste_07() >= 1.2 && avaliacao.getTeste_07() < 3.0) return "regular";
                if(avaliacao.getTeste_07() >= 3.0 && avaliacao.getTeste_07() < 5.1) return "bom";
                if(avaliacao.getTeste_07() >= 5.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 70 && avaliado.getIdade() <= 74){
                if(avaliacao.getTeste_07() < -1.7 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -1.7 && avaliacao.getTeste_07() < 0.6) return "fraco";
                if(avaliacao.getTeste_07() >= 0.6 && avaliacao.getTeste_07() < 2.4) return "regular";
                if(avaliacao.getTeste_07() >= 2.4 && avaliacao.getTeste_07() < 4.6) return "bom";
                if(avaliacao.getTeste_07() >= 4.6) return "muito bom";
            }
            if(avaliado.getIdade() >= 75 && avaliado.getIdade() <= 79){
                if(avaliacao.getTeste_07() < -2.0 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -2.0 && avaliacao.getTeste_07() < 0.3) return "fraco";
                if(avaliacao.getTeste_07() >= 0.3 && avaliacao.getTeste_07() < 2.2) return "regular";
                if(avaliacao.getTeste_07() >= 2.2 && avaliacao.getTeste_07() < 4.5) return "bom";
                if(avaliacao.getTeste_07() >= 4.5) return "muito bom";
            }
            if(avaliado.getIdade() >= 80 && avaliado.getIdade() <= 84){
                if(avaliacao.getTeste_07() < -2.6 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -2.6 && avaliacao.getTeste_07() < -0.3) return "fraco";
                if(avaliacao.getTeste_07() >= -0.3 && avaliacao.getTeste_07() < 1.5) return "regular";
                if(avaliacao.getTeste_07() >= 1.5 && avaliacao.getTeste_07() < 3.7) return "bom";
                if(avaliacao.getTeste_07() >= 3.7) return "muito bom";
            }
            if(avaliado.getIdade() >= 85 && avaliado.getIdade() <= 89){
                if(avaliacao.getTeste_07() < -3.2 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -3.2 && avaliacao.getTeste_07() < -0.9) return "fraco";
                if(avaliacao.getTeste_07() >= -0.9 && avaliacao.getTeste_07() < 0.9) return "regular";
                if(avaliacao.getTeste_07() >= 0.9 && avaliacao.getTeste_07() < 3.1) return "bom";
                if(avaliacao.getTeste_07() >= 3.1) return "muito bom";
            }
            if(avaliado.getIdade() >= 90 && avaliado.getIdade() <= 94){
                if(avaliacao.getTeste_07() < -5.1 ) return "muito fraco";
                if(avaliacao.getTeste_07() >= -5.1 && avaliacao.getTeste_07() < -2.6) return "fraco";
                if(avaliacao.getTeste_07() >= -2.6 && avaliacao.getTeste_07() < -0.6) return "regular";
                if(avaliacao.getTeste_07() >= -0.6 && avaliacao.getTeste_07() < 1.8) return "bom";
                if(avaliacao.getTeste_07() >= 1.8) return "muito bom";
            }
        }
        return "erro teste_07 teste de sentar e alcançar";
    }
}
