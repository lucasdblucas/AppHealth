package com.ufpi.estagio.apphealth.FimTeste_tela;

import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.Fragmentos_Dialogos.Fragmento_Dialogo;
import com.ufpi.estagio.apphealth.Iniciar_tela.Iniciar_appHealth;
import com.ufpi.estagio.apphealth.R;

public class FimTeste_activity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE_DIALOG = "com.ufpi.estagio.apphealth.MESSAGE_DIALOG";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fim_teste_activity);

        button = (Button) findViewById(R.id.button_SalvarEEnviarTeste);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new Fragmento_Dialogo();
                String[] aux = new String[]{"Mensagem de confirmação", "Avaliação enviada com Sucesso!", "activity_principal"};
                getIntent().putExtra(EXTRA_MESSAGE_DIALOG, aux);

                dialog.show(getSupportFragmentManager(), "Mensagem_Confirmacao");
            }
        });

    }

}
