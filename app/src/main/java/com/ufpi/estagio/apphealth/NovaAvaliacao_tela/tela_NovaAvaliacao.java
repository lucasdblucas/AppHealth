package com.ufpi.estagio.apphealth.NovaAvaliacao_tela;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;
import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.Activity_telaTestes.tela_Testes;

public class tela_NovaAvaliacao extends AppCompatActivity {

    private Toolbar toolbar;
    public final static String EXTRA_MESSAGE = "com.ufpi.estagio.apphealth.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__nova_avaliacao);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        if(null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                iniciarOutraActivity(this, activity_principal.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void iniciarOutraActivity(Context context, Class classe, int flag){
        Intent intent = new Intent(context, classe);
        if (flag != -999) intent.addFlags(flag);//se a activity do intent ja estiver "rodando", ela será
        //reaproveitada e todas as activitys acima dela na pilhas
        //serão "limpas"

        String[] arrayAux = new String[]{"1", "Testes metabólicos", "Testes Aeróbicos"};
        intent.putExtra(EXTRA_MESSAGE, arrayAux);

        startActivity(intent);
    }

    public void onClick_SalvarEVoltar(View view){
        iniciarOutraActivity(this, activity_principal.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }

    public void onClick_SalvarEIniciarAvaliacao(View view){
        iniciarOutraActivity(this, tela_Testes.class, -999);
    }
}
