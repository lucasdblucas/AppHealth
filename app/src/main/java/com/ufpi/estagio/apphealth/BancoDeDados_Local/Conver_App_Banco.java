package com.ufpi.estagio.apphealth.BancoDeDados_Local;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucas on 13/03/2016.
 */
public class Conver_App_Banco {
    private SQLiteDatabase banco;

    public Conver_App_Banco (Context context){
        Banco_Main auxBanco = new Banco_Main(context);
        banco = auxBanco.getWritableDatabase();
    }

    //funções para a tabela usuarios
    public Long Cadastrar_NovoUsuario(Usuario usuario){
        ContentValues valores = new ContentValues();
        valores.put("nome", usuario.getNome());
        valores.put("senha", usuario.getSenha());

        String[] colunas = new String[]{"_id", "nome", "senha"};
        Cursor cursor = banco.query("cadastros", colunas, "nome = ?", new String[]{"" + usuario.getNome()}, null, null, null);
        if(cursor.getCount() > 0) return null;
        else{
            Long id = banco.insert("cadastros", null, valores);
            //cursor.close();
            return id;
        }

    }

    public void deletarUsuario(Usuario usuario){

    }

    public void atualizarUsuario(Usuario usuario){

        //banco.update("cadastros", valores, "_id = ? AND _nome = ?", new Atring[]{""+usuario.getID(), ""+usuario.getNome()}););
    }

    public Usuario consultarUsuarioByName (String nome){
        String[] colunas = new String[]{"_id", "nome", "senha"};
        Cursor cursor = banco.query("cadastros", colunas, "nome = ?", new String[]{nome}, null, null, "_id ASC");

        Usuario usuario = new Usuario();
        if(cursor.getCount() > 0){
            Log.i("TESTE_TESTES", "cursor não é zero");
            cursor.moveToFirst();

            usuario.setID(cursor.getLong(0));
            usuario.setNome(cursor.getString(1));
            usuario.setSenha(cursor.getString(2));
            return usuario;
        }else return null;
    }

    public Usuario consultarUsuarioByID (Long ID){
        String[] colunas = new String[]{"_id", "nome", "senha"};
        Cursor cursor = banco.query("cadastros", colunas, "_id = ?", new String[]{""+ID}, null, null, "_id ASC");

        Usuario usuario = new Usuario();
        if(cursor.getCount() > 0){
            Log.i("TESTE_TESTES", "cursor não é zero");
            cursor.moveToFirst();

            usuario.setID(cursor.getLong(0));
            usuario.setNome(cursor.getString(1));
            usuario.setSenha(cursor.getString(2));
            return usuario;
        }else return null;
    }

    public List<Usuario> consultarUsuarios (){
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome", "senha"};
        Cursor cursor = banco.query("cadastros", colunas, null, null, null, null, "_id ASC");

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Usuario usuario = new Usuario();

                usuario.setID(cursor.getLong(0));
                usuario.setNome(cursor.getString(1));
                usuario.setSenha(cursor.getString(2));

                usuarios.add(usuario);
            }while(cursor.moveToNext());
        }
        return usuarios;
    }

    //funçõs para a tabela de avaliações
    public Long Inserir_NovaAvaliacao(Avaliacao avaliacao){
        ContentValues valores = new ContentValues();

        valores.put("id_avaliado", avaliacao.getID_Avaliado());
        valores.put("id_avaliador", avaliacao.getID_Avaliador());
        valores.put("teste_01", 0.0);
        valores.put("teste_02", 0.0);
        valores.put("teste_03", 0.0);
        valores.put("teste_04", 0.0);
        valores.put("teste_05", 0.0);
        valores.put("teste_06", 0.0);
        valores.put("teste_07", 0.0);
        valores.put("teste_08", 0.0);
        valores.put("status_envio", avaliacao.getStatus_Envio());

        Long id = banco.insert("avaliacoes", null, valores);
        return id;
    }

    public List<Avaliacao> getAvaliacoesUmUsuario(Usuario usuario){
        List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
        String[] colunas = new String[]{"_id", "id_avaliado", "id_avaliador", "teste_01", "teste_02", "teste_03"
                , "teste_04", "teste_05" , "teste_06", "teste_07"," teste_08", "status_envio"};
        Cursor cursor = banco.query("avaliacoes", colunas, "id_avaliador = ?", new String[]{"" + usuario.getID()}, null, null, "_id ASC");

        if(cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Avaliacao avaliacao = new Avaliacao();

                avaliacao.setID(cursor.getLong(0));
                avaliacao.setID_Avaliado(cursor.getLong(1));
                avaliacao.setID_Avaliador(cursor.getLong(2));
                avaliacao.setTeste_01(cursor.getFloat(3));
                avaliacao.setTeste_02(cursor.getFloat(4));
                avaliacao.setTeste_03(cursor.getFloat(5));
                avaliacao.setTeste_04(cursor.getFloat(6));
                avaliacao.setTeste_05(cursor.getFloat(7));
                avaliacao.setTeste_06(cursor.getFloat(8));
                avaliacao.setTeste_07(cursor.getFloat(9));
                avaliacao.setTeste_08(cursor.getFloat(10));
                avaliacao.setStatus_Envio(cursor.getString(11));

                avaliacoes.add(avaliacao);
            }while(cursor.moveToNext());
        }else{
            Log.i("MENSAGEM_ERRO_BASEDATA", "não foi encontrado nenhuma avaliação para esse usuário");
        }

        return avaliacoes;
    }

    public Avaliacao consultarAvaliacaoByID (Long id){
        String[] colunas = new String[]{"_id", "id_avaliado", "id_avaliador", "teste_01", "teste_02", "teste_03"
                , "teste_04", "teste_05" , "teste_06", "teste_07"," teste_08", "status_envio"};
        Cursor cursor = banco.query("avaliacoes", colunas, "_id = ?", new String[]{""+id}, null, null, "_id ASC");

        Avaliacao avaliacao = new Avaliacao();
        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            avaliacao.setID(cursor.getLong(0));
            avaliacao.setID_Avaliado(cursor.getLong(1));
            avaliacao.setID_Avaliador(cursor.getLong(2));
            avaliacao.setTeste_01(cursor.getFloat(3));
            avaliacao.setTeste_02(cursor.getFloat(4));
            avaliacao.setTeste_03(cursor.getFloat(5));
            avaliacao.setTeste_04(cursor.getFloat(6));
            avaliacao.setTeste_05(cursor.getFloat(7));
            avaliacao.setTeste_06(cursor.getFloat(8));
            avaliacao.setTeste_07(cursor.getFloat(9));
            avaliacao.setTeste_08(cursor.getFloat(10));
            avaliacao.setStatus_Envio(cursor.getString(11));

            return avaliacao;
        }else return null;
    }

    public void atualizarAvaliacao(Avaliacao avaliacao){
        ContentValues valores = new ContentValues();

        valores.put("id_avaliado", avaliacao.getID_Avaliado());
        valores.put("id_avaliador", avaliacao.getID_Avaliador());
        valores.put("teste_01", avaliacao.getTeste_01());
        valores.put("teste_02", avaliacao.getTeste_02());
        valores.put("teste_03", avaliacao.getTeste_03());
        valores.put("teste_04", avaliacao.getTeste_04());
        valores.put("teste_05", avaliacao.getTeste_05());
        valores.put("teste_06", avaliacao.getTeste_06());
        valores.put("teste_07", avaliacao.getTeste_07());
        valores.put("teste_08", avaliacao.getTeste_08());
        valores.put("status_envio", avaliacao.getStatus_Envio());

        banco.update("avaliacoes", valores, "_id = ? ", new String[]{""+avaliacao.getID()});
    }

    //funções para tabela avaliados
    public Long Inserir_NovoAvaliado(Avaliado avaliado){
        ContentValues valores = new ContentValues();
        valores.put("nome_avaliado", avaliado.getNome_avaliado());
        valores.put("altura", avaliado.getAltura());
        valores.put("peso", avaliado.getPeso());
        valores.put("idade", avaliado.getIdade());
        valores.put("sexo", avaliado.getSexo());
        valores.put("estado_fisico", avaliado.getEstado_fisico());

        Long id = banco.insert("avaliados", null, valores);
        return id;
    }

    public Avaliado consultarAvaliadoByID (Avaliacao avaliacao){
        String[] colunas = new String[]{"_id", "nome_avaliado", "altura", "peso", "idade", "sexo", "estado_fisico"};
        Cursor cursor = banco.query("avaliados", colunas, "_id = ?", new String[]{""+avaliacao.getID_Avaliado()}, null, null, "_id ASC");

        Avaliado avaliado = new Avaliado();

        if(cursor.getCount() > 0){
            cursor.moveToFirst();

            avaliado.setID(cursor.getLong(0));
            avaliado.setNome_avaliado(cursor.getString(1));
            avaliado.setAltura(cursor.getFloat(2));
            avaliado.setPeso(cursor.getFloat(3));
            avaliado.setIdade(cursor.getInt(4));
            avaliado.setSexo(cursor.getString(5));
            avaliado.setEstado_fisico(cursor.getString(6));

            return avaliado;
        }else return null;
    }

    public List<Avaliado> getAvaliacdosUmUsuario(Usuario usuario){
        List<Avaliado> avaliados = new ArrayList<Avaliado>();

        String[] colunas_avaliacoes = new String[]{"_id", "id_avaliado", "id_avaliador", "teste_01", "teste_02", "teste_03"
                , "teste_04", "teste_05" , "teste_06", "teste_07"," teste_08", "status_envio"};
        Cursor cursor_avaliacoes = banco.query("avaliacoes", colunas_avaliacoes, "id_avaliador = ?", new String[]{""+usuario.getID()}, null, null, "_id ASC");

        //String[] colunas_avaliados = new String[]{"_id", "nome_avaliado", "altura", "peso", "idade", "sexo", "estado_fisico"};
        //Cursor cursor_avalidos = banco.query("avaliados", colunas_avaliados, "id_avaliador = ?", new String[]{"" + usuario.getID()}, null, null, "_id ASC");

        if(cursor_avaliacoes.getCount() > 0) {
            cursor_avaliacoes.moveToFirst();
            do {
                Avaliacao avaliacao = new Avaliacao();
                avaliacao.setID_Avaliado(cursor_avaliacoes.getLong(1));
                Avaliado avaliado = consultarAvaliadoByID(avaliacao);

                avaliados.add(avaliado);
            }while(cursor_avaliacoes.moveToNext());
        }else{
            Log.i("MENSAGEM_E_BD_", "avaliados de um usuario. Ocorreu um erro.");
        }

        return avaliados;
    }

    //funções para a tabela de resultados final
    public Long Inserir_NovoResultado(Resultado resultado){
        ContentValues valores = new ContentValues();

        valores.put("id_avaliado", resultado.getID_avaliado());
        valores.put("id_avaliador", resultado.getID_avaliador());
        valores.put("id_avaliacao", resultado.getID_avaliacao());
        valores.put("imc", resultado.getImc());
        valores.put("teste_01", resultado.getTeste_01());
        valores.put("teste_02", resultado.getTeste_02());
        valores.put("teste_03", resultado.getTeste_03());
        valores.put("teste_04", resultado.getTeste_04());
        valores.put("teste_05", resultado.getTeste_05());
        valores.put("teste_06", resultado.getTeste_06());
        valores.put("teste_07", resultado.getTeste_07());
        valores.put("teste_08", resultado.getTeste_08());

        Long id = banco.insert("resultados", null, valores);
        return id;
    }
}
