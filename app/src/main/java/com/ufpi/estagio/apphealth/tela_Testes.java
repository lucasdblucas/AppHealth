package com.ufpi.estagio.apphealth;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.ufpi.estagio.apphealth.Activity_telaTestes.CardFragment;

import java.util.ArrayList;
import java.util.List;

public class tela_Testes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela__testes);

        CardFragment frag = (CardFragment) getSupportFragmentManager().findFragmentByTag("tela_testes");
        if(frag == null){
            frag = new CardFragment();
            FragmentTransaction f = getSupportFragmentManager().beginTransaction();
            f.replace(R.id.fragment_Container, frag, "tela_testes");
            f.commit();
        }

    }

    public List<ItemCard> getCards(){
        String[] cards = new String[]{"Relação Cintura Para Quadril", "Instrumentos", "Procedimento", "Cuidados", "Observações"};
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

    public void onClick_arrowDown(View view){

    }
}
