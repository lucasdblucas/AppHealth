package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ufpi.estagio.apphealth.ItemCard;
import com.ufpi.estagio.apphealth.R;
import com.ufpi.estagio.apphealth.tela_Testes;

import java.util.List;

/**
 * Created by lucas on 03/03/2016.
 */
public class CardFragment extends android.support.v4.app.Fragment {

    private RecyclerView recyclerView;
    private List<ItemCard> listCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstancesState){
        View view = inflater.inflate(R.layout.fragment_card, container, false);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_Cards);
        //recyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
        //    @Override
         //   public void onScrollStateChanged(RecyclerView recyclerview, int newState) {
        //        super.onScrollStateChanged(recyclerView, newState);
         //   }

         //   @Override
        //    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
          //      super.onScrolled(recyclerView, dx, dy);

                //essa parte é no caso de querer que quando o list estiver no final da tela, porcurar mais itens
                //para ser mostrados e acrescentar a recyclerView

                //LinearLayoutManager llm = (LinearLayoutManager) recyclerView.getLayoutManager();
                //RecyclerView_Adapter adapter = (RecyclerView_Adapter) recyclerView.getAdapter();

                //if(listCard.size() == llm.findLastCompletelyVisibleItemPosition() + 1){
                //    List<ItemCard> listAux = ((tela_Testes)getActivity()).getCards();

                 //   for(int i = 0; i<listAux.size(); i++){
                 //       adapter.addListItem(listAux.get(i), listAux.size());
                 //   }
               // }
         //   }
       // });

        recyclerView.setHasFixedSize(true);//garante que o tamanhao da lista sempre será o mesmo

        LinearLayoutManager layout_aux = new LinearLayoutManager(getActivity());
        layout_aux.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layout_aux);

        listCard = ((tela_Testes) getActivity()).getCards();
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(getActivity(), listCard);
        recyclerView.setAdapter(adapter);

        return view;
    }
}
