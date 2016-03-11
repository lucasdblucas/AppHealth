package com.ufpi.estagio.apphealth.Fragmentos_Dialogos;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;
import com.ufpi.estagio.apphealth.R;

/**
 * Created by lucas on 11/03/2016.
 * por enquanto essa classe não esta sendo usada mas pode ser usada depois
 *
 */
public class Fragmento_Dialogo extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        //super.onCreateDialog(savedInstanceState);

        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        //builder.setTitle("App Title");

        //deve ter alguma função que faça isso sem esse gambiarra, dividir informações dever ser por extras e naõ pelas tag
        //que serve par identificação
        builder.setTitle("Confirmação");
        builder.setMessage("Confirmação de Envio de Avaliaçaõ");

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getActivity(), activity_principal.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                // You don't have to do anything here if you just want it dismissed when clicked
            }
        });

        // Create the AlertDialog object and return it
        return builder.create();
    }
}
