package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufpi.estagio.apphealth.Activity_telaTestes.CardFragment;
import com.ufpi.estagio.apphealth.Activity_telaTestes.ItemCard;
import com.ufpi.estagio.apphealth.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class tela_Testes extends AppCompatActivity {

    public final static String EXTRA_MESSAGE = "com.ufpi.estagio.apphealth.MESSAGE";
    public static HashMap<String, HashMap<String, String>> ListaTestes;
    public int contAux = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__testes);

        if (contAux == 1) iniciarHashTestes();

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
        HashMap<String, String> auxHash = new HashMap<String, String>();

        auxHash.put("Relação Cintura Para Quadril", "Teste tal do tal la de tal");
        auxHash.put("Procedimento","corte sem se cortar tudo que ver pela frente, depois bla bla bla bla bla bla");

        ListaTestes.put("1", auxHash);



        ListaTestes.put("1", auxHash);

    }
    public List<ItemCard> getCards(){
        String[] cards = new String[]{"Relação Cintura Para Quadril","Procedimento"};
        String[] conteudo = new String[]{"Teste tal do tal la de tal", "faca, cola e tesoura sem ponta" ,
                "corte sem se cortar tudo que ver pela frente, depois bla bla bla bla bla bla",
                "Cuidado com os dedos e para não furar o olho do coleguinha", "Obsevamos observações de que observando" +
                "se observa mais ainda"};

        List<ItemCard> listAux = new ArrayList<>();

        for(int i=0; i < cards.length; i++){
            ItemCard itemCard_Aux = new ItemCard(cards[i], conteudo[i]);
            listAux.add(itemCard_Aux);
        }
        return listAux;
    }

    public void onClick_proximoTeste(View view){
        Intent intent = new Intent( view.getContext(), tela_Testes.class);

        intent.putExtra(EXTRA_MESSAGE, new String());

        startActivity(intent);
        //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        //      .setAction("Action", null).show();
    }
}
