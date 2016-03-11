package com.ufpi.estagio.apphealth.FimTeste_tela;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ufpi.estagio.apphealth.Fragmentos_Dialogos.Fragmento_Dialogo;
import com.ufpi.estagio.apphealth.R;

public class FimTeste_activity extends AppCompatActivity {

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
                dialog.show(getSupportFragmentManager(), "Mensagen_erro");
            }
        });

    }


    //public void onClickSalvaEEnviar(View view){

   // }
}
