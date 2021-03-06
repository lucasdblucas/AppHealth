package com.ufpi.estagio.apphealth.ConsultaAvaliacao_tela;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ufpi.estagio.apphealth.R;

import java.util.List;

/**
 * Created by lucas on 13/03/2016.
 */
public class RecyclerViewAdapter_Consulta extends RecyclerView.Adapter<RecyclerViewAdapter_Consulta.MyViewHolder>{

    private List<ItemCard_Consulta> minha_List;
    private LayoutInflater meu_LayoutInflater;
    public View v;

    public RecyclerViewAdapter_Consulta (Context c, List<ItemCard_Consulta> list){
        this.minha_List = list;
        this.meu_LayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        v = meu_LayoutInflater.inflate(R.layout.item_cardview_consulta, viewGroup, false);

        MyViewHolder mvh = new MyViewHolder(v);

        return mvh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position){
        myViewHolder.titulo.setText(minha_List.get(position).getTitulo());
        myViewHolder.conteudo.setText(minha_List.get(position).getConteudo());

    }

    @Override
    public int getItemCount(){
        return minha_List.size();
    }

    public void addListItem(ItemCard_Consulta c, int position){
        minha_List.add(c);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView titulo, conteudo;

        public MyViewHolder(View itemView){
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.text_TituloConsulta);
            conteudo = (TextView) itemView.findViewById(R.id.text_ConteudoConsulta);

        }
    }
}
