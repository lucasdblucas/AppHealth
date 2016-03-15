package com.ufpi.estagio.apphealth.Fragmentos_Dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.FimTeste_tela.FimTeste_activity;
import com.ufpi.estagio.apphealth.Iniciar_tela.Iniciar_appHealth;
import com.ufpi.estagio.apphealth.R;

/**
 * Created by lucas on 11/03/2016.
 * por enquanto essa classe não esta sendo usada mas pode ser usada depois
 *
 */
public class Fragmento_Dialogo extends DialogFragment {
    public final static String EXTRA_MESSAGE_DIALOG = "com.ufpi.estagio.apphealth.MESSAGE_DIALOG";
    private String activity_volta;
    Usuario usuario;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //super.onCreateDialog(savedInstanceState);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //deve ter alguma função que faça isso sem esse gambiarra, dividir informações dever ser por extras e naõ pelas tag
        //que serve par identificação

        Intent intentExtras = getActivity().getIntent();
        Bundle extraBundle = intentExtras.getExtras();
        activity_volta = new String();

        if(!extraBundle.isEmpty()){
            if(extraBundle.containsKey(EXTRA_MESSAGE_DIALOG)){
                String[] arrayString = extraBundle.getStringArray(EXTRA_MESSAGE_DIALOG);

                if(arrayString.length > 0) {
                    Log.i("MENSAGEM", "entreamos aqui_dialogo");
                    String titulo = arrayString[0];
                    String subtitulo = arrayString[1];
                    activity_volta = arrayString[2];

                    builder.setTitle(titulo);
                    builder.setMessage(subtitulo);
                }
            }
        }


        if(extraBundle != null && !extraBundle.isEmpty()){
            if(extraBundle.containsKey(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID)) {
                String[] arrayString = extraBundle.getStringArray(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID);

                if(arrayString != null && arrayString.length > 0) {
                    Log.i("MENSAGEM_DO_BANCO_02", "entreamos aqui");
                    usuario = new Usuario();
                    usuario.setID(Long.parseLong(arrayString[0]));
                    usuario.setNome(arrayString[1]);
                    usuario.setSenha(arrayString[2]);

                }else Log.i("MENSAGEM_DO_BANCO_02", "Array recuperado não possui posições");
            }else Log.i("MENSAGEM_DO_BANCO_02", "bundley não possui mensagem EXTRA_MESSAGE_USUARIOID");
        }else Log.i("MENSAGEM_DO_BANCO_02", "bundley empty");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

                if(activity_volta.equals("activity_principal")) {
                    Intent intent = new Intent(getActivity(), activity_principal.class);
                    intent.putExtra(Iniciar_appHealth.EXTRA_MESSAGE_USUARIOID, new String[]{""+usuario.getID()
                            , usuario.getNome(), usuario.getSenha()});
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
                if(activity_volta.equals("ConsultaAvaliacao_tela")) {
                    Intent intent = new Intent(getActivity(), getActivity().getClass());
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
