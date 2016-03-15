package com.ufpi.estagio.apphealth.NovaAvaliacao_tela;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

import com.ufpi.estagio.apphealth.Avaliacoes_tela.activity_principal;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliacao;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Avaliado;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Conver_App_Banco;
import com.ufpi.estagio.apphealth.BancoDeDados_Local.Usuario;
import com.ufpi.estagio.apphealth.Iniciar_tela.Iniciar_appHealth;
import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.Activity_telaTestes.tela_Testes;

public class tela_NovaAvaliacao extends AppCompatActivity {

    private Toolbar toolbar;
    private EditText edit_Nome, edit_Altura, edit_Peso, edit_Idade;
    private RadioButton radio_Homem, radio_Mulher, radio_Ativo, radio_Inativo;

    public final static String EXTRA_MESSAGE = "com.ufpi.estagio.apphealth.MESSAGE";
    public final static String EXTRA_MESSAGE_AVALIACAOID = "com.ufpi.estagio.apphealth.MESSAGE_USUARIOID_AVALIACAOID";

    private Usuario usuario;
    private Avaliacao avaliacao;
    private Avaliado avaliado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__nova_avaliacao);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        //recuperar informações de usuario
        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();
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

        edit_Nome = (EditText) findViewById(R.id.field_Nome);
        edit_Altura = (EditText) findViewById(R.id.field_Altura);
        edit_Peso = (EditText) findViewById(R.id.field_Peso);
        edit_Idade = (EditText) findViewById(R.id.field_Idade);
        radio_Homem = (RadioButton) findViewById(R.id.radio_Homem);
        radio_Mulher = (RadioButton) findViewById(R.id.radio_Mulher);
        radio_Ativo = (RadioButton) findViewById(R.id.radio_Ativo);
        radio_Inativo = (RadioButton) findViewById(R.id.radio_Inativo);

        setSupportActionBar(toolbar);
        if(null != getSupportActionBar()) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                iniciarOutraActivity(this, activity_principal.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, null, null);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void iniciarOutraActivity(Context context, Class classe, int flag, String tag, String[] mensage){
        Intent intent = new Intent(context, classe);
        if (flag != -999) intent.addFlags(flag);//se a activity do intent ja estiver "rodando", ela será
        //reaproveitada e todas as activitys acima dela na pilhas
        //serão "limpas"

        String[] arrayAux = new String[]{"1", "Testes metabólicos", "Testes Aeróbicos"};
        intent.putExtra(EXTRA_MESSAGE, arrayAux);
        intent.putExtra(tag, mensage);

        startActivity(intent);
    }

    public void onClick_SalvarEVoltar(View view){

        salvarAvaliadoAvaliacao();
        iniciarOutraActivity(this, activity_principal.class, Intent.FLAG_ACTIVITY_CLEAR_TOP,null, null);
    }

    public void onClick_SalvarEIniciarAvaliacao(View view){
        salvarAvaliadoAvaliacao();
        iniciarOutraActivity(this, tela_Testes.class, -999, EXTRA_MESSAGE_AVALIACAOID, new String[]{""+avaliacao.getID()});
    }

    public void salvarAvaliadoAvaliacao(){
        int flag;

        avaliado = new Avaliado();
        avaliado.setNome_avaliado(edit_Nome.getText().toString());

        String[] aux = edit_Altura.getText().toString().split(",");
        String aux2;
        if(aux.length > 1) {
            aux2 = aux[0]+"."+aux[1];
        }else{
            aux2 = edit_Altura.getText().toString();
        }
        avaliado.setAltura(Float.parseFloat(aux2));

        String[] aux3 = edit_Peso.getText().toString().split(",");
        String aux4;
        if(aux3.length > 1) {
            aux4 = aux3[0]+"."+aux3[1];
        }else{
            aux4 = edit_Peso.getText().toString();
        }
        avaliado.setPeso(Float.parseFloat(aux4));

        avaliado.setIdade(Integer.parseInt(edit_Idade.getText().toString()));
        if(radio_Homem.isChecked()) avaliado.setSexo("H");
        if(radio_Mulher.isChecked()) avaliado.setSexo("M");
        if(radio_Ativo.isChecked()) avaliado.setEstado_fisico("A");
        if(radio_Inativo.isChecked()) avaliado.setEstado_fisico("I");

        Conver_App_Banco banco = new Conver_App_Banco(this);
        avaliado.setID(banco.Inserir_NovoAvaliado(avaliado));

        avaliacao = new Avaliacao();
        avaliacao.setID_Avaliado(avaliado.getID());
        avaliacao.setID_Avaliador(usuario.getID());
        avaliacao.setStatus_Envio("Nao Enviado");

        avaliacao.setID(banco.Inserir_NovaAvaliacao(avaliacao));
    }
}
