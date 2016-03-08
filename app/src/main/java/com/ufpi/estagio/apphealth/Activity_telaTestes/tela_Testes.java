package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.ufpi.estagio.apphealth.Activity_telaTestes.CardFragment;
import com.ufpi.estagio.apphealth.Activity_telaTestes.ItemCard;
import com.ufpi.estagio.apphealth.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class tela_Testes extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.ufpi.estagio.apphealth.MESSAGE";
    public static HashMap<String, HashMap<String, String>> ListaTestes;
    public static String ID_tela = "1";
    public static String titulo_tela = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__testes);

        Intent intentExtras = getIntent();
        Bundle extraBundle = intentExtras.getExtras();
        //boolean hasMyVectorString = false;

        if(!extraBundle.isEmpty()){
            if(extraBundle.containsKey(EXTRA_MESSAGE)) {
                String[] arrayString = extraBundle.getStringArray(EXTRA_MESSAGE);

                if(arrayString.length > 0) {
                    Log.i("MENSAGEM", "entreamos aqui");
                    ID_tela = arrayString[0];
                    titulo_tela = arrayString[1];
                    if (ID_tela.equals("1")) iniciarHashTestes();
                    getSupportActionBar().setTitle(titulo_tela);
                }
            }
        }


        CardFragment frag = (CardFragment) getSupportFragmentManager().findFragmentByTag("tela_testes");
        if(frag == null){
            frag = new CardFragment();
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            f.replace(R.id.fragment_Container, frag, "tela_testes");
            f.commit();
        }

    }

    public void iniciarHashTestes(){

        ListaTestes = new HashMap<String, HashMap<String, String>>();
        HashMap<String, String> auxHash_01 = new HashMap<String, String>();

        auxHash_01.put("1Relação Cintura Para Quadril", "Medidas circunferenciais com proposito de calcular o percentual de gordura e estimar o risco cardiovascular.");
        auxHash_01.put("2Procedimento","Fazer as medidas circunferencias da cintura e do quadril.");
        auxHash_01.put("3Resultados", "O resultado é a divisão: cintura/quadril do avaliado.");

        ListaTestes.put("1", auxHash_01);


        HashMap<String, String> auxHash_02 = new HashMap<String, String>();

        auxHash_02.put("1Teste de Caminhada de 6 minutos", "Teste aeróbico de caminhada");
        auxHash_02.put("2Instrumentos","cronômetro, cones, fita métrica, palitos de picolé, giz, fita crepe (ou outro tipo de marcador) " +
                "e cadeiras.");
        auxHash_02.put("3Procedimentos", "O teste propõe ao avaliado caminhar a maior distância possível em 6 minutos, em um percurso de " +
                "45,72m. Os cones são distribuídos no formato de um retângulo, um cone em cada aresta.");
        auxHash_02.put("4Cuidados", "A área do teste pode ser em espaço fício aberto ou fechado; porém, em uma superfície não derrapante");
        auxHash_02.put("5Cadeiras de Segunrança", "Podem ser colocadas cadeiras de segunrança ao longo do percurço, para que o avaliado" +
                "possa descansar, caso necessite, e logo após um pequeno descanso, continuar o teste.");
        auxHash_02.put("6Observações", "O teste pode ser interrompido a qualquer momento pelo avaliado, caso sinta tontura, dor, nausea etc." +
                "\n em caso de se avaliar grandes grupos, aconselha-se o tempo de 10 segundos entre a partida de cada indivíduo. O percurso tem" +
                "uma distância total de 45,72m, dividida em 10 segundos de 4,57m.");
        auxHash_02.put("7Resultado", "O campo resultados deve ser preenchido com os metros percorridos do avaliado");

        ListaTestes.put("2", auxHash_02);


        HashMap<String, String> auxHash_03 = new HashMap<String, String>();

        auxHash_03.put("1Teste da marcha estacionária de 2 minutos", "Marcha com o levantamento do juelho a uma marca indicada");
        auxHash_03.put("2Procedimento", "A altura adequado do juelho para realizar a marcha é o nível do ponto médio entre a patela e" +
                        "a crista ilíaca. A atividade inicia-se com o joelho direito; conta-se somente o núemro de vezes em que o juelho" +
                "direito encosta na fita.");
        auxHash_03.put("3Precauções", "O avaliador permanece ao lado do avaliado para, em caso de desequilíbrio segurá-lo");
        auxHash_03.put("4Resultados", "O campo resultados deve ser preechido com o número de steps do avaliado");

        ListaTestes.put("3", auxHash_03);

        HashMap<String, String> auxHash_04 = new HashMap<String, String>();

        auxHash_04.put("1Teste de levantar caminhar e setar", "Teste aeróbico de caminhada");
        auxHash_04.put("2Instrumentos","cronômetro, cones, fita métrica, palitos de picolé, giz, fita crepe (ou outro tipo de marcador) " +
                "e cadeiras.");
        auxHash_04.put("3Procedimentos", "O teste propõe ao avaliado caminhar a maior distância possível em 6 minutos, em um percurso de " +
                "45,72m. Os cones são distribuídos no formato de um retângulo, um cone em cada aresta.");
        auxHash_04.put("4Cuidados", "A área do teste pode ser em espaço fício aberto ou fechado; porém, em uma superfície não derrapante");
        auxHash_04.put("5Cadeiras de Segunrança", "Podem ser colocadas cadeiras de segunrança ao longo do percurço, para que o avaliado" +
                "possa descansar, caso necessite, e logo após um pequeno descanso, continuar o teste.");
        auxHash_02.put("6Observações", "O teste pode ser interrompido a qualquer momento pelo avaliado, caso sinta tontura, dor, nausea etc." +
                "\n em caso de se avaliar grandes grupos, aconselha-se o tempo de 10 segundos entre a partida de cada indivíduo. O percurso tem" +
                "uma distância total de 45,72m, dividida em 10 segundos de 4,57m.");
        auxHash_02.put("7Resultado", "O campo resultados deve ser preenchido com os metros percorridos do avaliado");

        ListaTestes.put("2", auxHash_02);
    }

    public List<ItemCard> getCards(){
        List<ItemCard> listAux = new ArrayList<>();
        int index;

        //esse for é nessesário porque o hash guarda os componentes desordenadamente
        for(int i = 1; i <= ListaTestes.get(ID_tela).size(); i ++) {
            String aux_03 = Integer.toString(i);
            Iterator in = ListaTestes.get(ID_tela).keySet().iterator();

            while (in.hasNext()){
                String aux = (String) in.next();
                String auxString = aux.substring(0, 1);
                String aux_02 = aux.substring(1);

                Log.i("ERROS_TESTES", aux + " __ " + auxString + " __ " + aux_02);


                if(auxString.equals(aux_03)) {
                    ItemCard itemCard_Aux = new ItemCard(aux_02, ListaTestes.get(ID_tela).get(aux));
                    listAux.add(itemCard_Aux);
                }
            }

        }

        return listAux;
    }

    public void onClick_proximoTeste(View view){
        Intent intent = new Intent( view.getContext(), tela_Testes.class);
        String type = new String();
        String id_str = new String();

        if(ID_tela.equals("1") || ID_tela.equals("2") || ID_tela.equals("3")){
            int id_int = Integer.parseInt(ID_tela) +1;
            id_str = Integer.toString(id_int);
            type = "Testes metabólicos";
        }
        String[] arrayAux = new String[]{id_str, type};

        intent.putExtra(EXTRA_MESSAGE, arrayAux);

        startActivity(intent);
        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //      .setAction("Action", null).show();
    }
}
