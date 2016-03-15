package com.ufpi.estagio.apphealth.Cadastro_tela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.R;

public class Cadastro_tela_activity extends AppCompatActivity {


    EditText edit_Nome;
    EditText edit_Senha;
    EditText edit_ConfirmarSenha;
    //public final static String EXTRA_MESSAGE_ERRO = "com.ufpi.estagio.apphealth.MESSAGE_ERRO";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_tela_activity);

        edit_Nome = (EditText) findViewById(R.id.edit_Nome);
        edit_Senha = (EditText) findViewById(R.id.edit_Senha);
        edit_ConfirmarSenha = (EditText) findViewById(R.id.edit_ConfirmarSenha);

    }

    public void onClick_Cadastrar(View view){

        if(edit_Senha.getText().toString().equals(edit_ConfirmarSenha.getText().toString())){
            Usuario usuario = new Usuario();
            usuario.setNome(edit_Nome.getText().toString());
            usuario.setSenha(edit_Senha.getText().toString());

            Conver_App_Banco banco = new Conver_App_Banco(this);
            Long id = banco.Cadastrar_NovoUsuario(usuario);

            if(id == null){
                Toast.makeText(this, "Nome de Usuário em uso. Escolha outro nome!", Toast.LENGTH_LONG).show();
            }else {
                usuario.setID(id);
                Toast.makeText(this, "Usuário Cadastrado com sucesso ID: " + usuario.getID(), Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Senhas não coincidem. Tente novamente.", Toast.LENGTH_LONG).show();
        }

    }
}
