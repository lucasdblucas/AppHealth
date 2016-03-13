package com.ufpi.estagio.apphealth.ConsultaAvaliacao_tela;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ufpi.estagio.apphealth.Fragmentos_Dialogos.Fragmento_Dialogo;
import com.ufpi.estagio.apphealth.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ConsultaAvaliacao_tela extends AppCompatActivity {
    public final static String EXTRA_MESSAGE_DIALOG = "com.ufpi.estagio.apphealth.MESSAGE_DIALOG";
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_avaliacao_tela);

        CardFragment_Consulta frag = (CardFragment_Consulta) getSupportFragmentManager().findFragmentByTag("tela_consulta");
        if(frag == null){
            frag = new CardFragment_Consulta();
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            f.replace(R.id.fragment_ContainerConsulta, frag, "tela_consulta");
            f.commit();
        }

        button = (Button) findViewById(R.id.button_Enviar);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment dialog = new Fragmento_Dialogo();
                String[] aux = new String[]{"Mensagem de confirmação", "Avaliação enviada com Sucesso!", "ConsultaAvaliacao_tela"};
                getIntent().putExtra(EXTRA_MESSAGE_DIALOG, aux);

                dialog.show(getSupportFragmentManager(), "Mensagem_Confirmacao");
            }
        });
    }

    //Essa classe quando implementado o banco de dados irá retorna dados de um avaliado de acordo com ID do mesmo no banco de dados
    public List<ItemCard_Consulta> getCardConsulta(){

        List<ItemCard_Consulta> listAux = new ArrayList<>();

        ItemCard_Consulta itemCard_Aux = new ItemCard_Consulta("Avaliado", "Dona Maria");
        listAux.add(itemCard_Aux);


        ItemCard_Consulta itemCard_Aux_02 = new ItemCard_Consulta("IMC", "Normal");
        listAux.add(itemCard_Aux_02);

        ItemCard_Consulta itemCard_Aux_03 = new ItemCard_Consulta("RCQ", "Risco Alto");
        listAux.add(itemCard_Aux_03);

        ItemCard_Consulta itemCard_Aux_04 = new ItemCard_Consulta("Teste de caminhada de 6 minutos", "Muito Fraco");
        listAux.add(itemCard_Aux_04);

        ItemCard_Consulta itemCard_Aux_05 = new ItemCard_Consulta("Teste de marcha estacionária de 2 minutos", "Não satisfatório");
        listAux.add(itemCard_Aux_05);

        ItemCard_Consulta itemCard_Aux_06 = new ItemCard_Consulta("Teste de levantar, caminhar e sentar", "Regular");
        listAux.add(itemCard_Aux_06);

        ItemCard_Consulta itemCard_Aux_07 = new ItemCard_Consulta("Flexão de cotovelo", "Bom");
        listAux.add(itemCard_Aux_07);

        ItemCard_Consulta itemCard_Aux_08 = new ItemCard_Consulta("Teste de sentar e levantar da cadeira em 30 segundos", "Muito Fraco");
        listAux.add(itemCard_Aux_08);

        ItemCard_Consulta itemCard_Aux_09 = new ItemCard_Consulta("Teste de sentar e alcançar", "Regular");
        listAux.add(itemCard_Aux_09);

        ItemCard_Consulta itemCard_Aux_10 = new ItemCard_Consulta("Teste de alcançar atrás das costas", "Fraco");
        listAux.add(itemCard_Aux_10);

        return listAux;
    }
}
