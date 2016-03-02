package com.ufpi.estagio.apphealth;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class tela_NovaAvaliacao extends AppCompatActivity {

    private Toolbar toolbar;

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
                Intent intent = new Intent(this, activity_principal.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);//se a activity do intent ja estiver "rodando", ela será
                                                                //reaproveitada e todas as activitys acima dela na pilhas
                                                                //serão "limpas"
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
