package com.ufpi.estagio.apphealth.Iniciar_tela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;

public class Iniciar_appHealth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_app_health);

    }

    public void onClick_Entrar(View view){
        Intent intent = new Intent(this, activity_principal.class);
        startActivity(intent);
    }
}
