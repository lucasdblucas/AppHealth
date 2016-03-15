package com.ufpi.estagio.apphealth.Iniciar_tela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.Cadastro_tela.Cadastro_tela_activity;
import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;

public class Iniciar_appHealth extends AppCompatActivity {

    EditText edit_usuario;
    EditText edit_senha;
    public final static String EXTRA_MESSAGE_USUARIOID = "com.ufpi.estagio.apphealth.MESSAGE_USUARIOID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_app_health);

        edit_usuario = (EditText) findViewById(R.id.field_Usuario);
        edit_senha = (EditText) findViewById(R.id.field_Senha);
    }

    public void onClick_Entrar(View view){
        Conver_App_Banco banco = new Conver_App_Banco(this);
        Usuario usuario = banco.consultarUsuarioByName(edit_usuario.getText().toString());

        if(usuario == null){
            Toast.makeText(this, "Usuario Inexistente", Toast.LENGTH_LONG).show();
        }else{
            if (usuario.getSenha().equals(edit_senha.getText().toString())){
                Intent intent = new Intent(this, activity_principal.class);

                intent.putExtra(EXTRA_MESSAGE_USUARIOID, new String[]{""+usuario.getID(), usuario.getNome(), usuario.getSenha()});

                startActivity(intent);
            }else Toast.makeText(this, "Senha incorreta", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick_IniciarCadastro(View view){
        Intent intent = new Intent (this, Cadastro_tela_activity.class);
        startActivity(intent);
    }
}
