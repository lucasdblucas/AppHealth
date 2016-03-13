package com.ufpi.estagio.apphealth.ConsultaAvaliacao_tela;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ufpi.estagio.apphealth.Activity_telaTestes.ItemCard;
import com.ufpi.estagio.apphealth.R;

import java.util.List;

/**
 * Created by lucas on 13/03/2016.
 */
public class CardFragment_Consulta extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<ItemCard_Consulta> listCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstancesState){
        View view = inflater.inflate(R.layout.fragment_card_consulta, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_CardsConsulta);


        recyclerView.setHasFixedSize(true);//garante que o tamanhao da lista sempre será o mesmo

        LinearLayoutManager layout_aux = new LinearLayoutManager(getActivity());
        layout_aux.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layout_aux);

        listCard = ((ConsultaAvaliacao_tela) getActivity()).getCardConsulta();
        RecyclerViewAdapter_Consulta adapter = new RecyclerViewAdapter_Consulta(getActivity(), listCard);
        recyclerView.setAdapter(adapter);

        recyclerView.setVerticalScrollBarEnabled(false);
        return view;
    }
}
