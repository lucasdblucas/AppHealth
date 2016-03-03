package com.ufpi.estagio.apphealth.Activity_telaTestes;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ufpi.estagio.apphealth.ItemCard;
import com.ufpi.estagio.apphealth.R;

import java.util.List;

/**
 * Created by lucas on 03/03/2016.
 */
public class RecyclerView_Adapter extends RecyclerView.Adapter<RecyclerView_Adapter.MyViewHolder>{

    private List<ItemCard> minha_List;
    private LayoutInflater meu_LayoutInflater;

    public RecyclerView_Adapter (Context c, List<ItemCard> list){
        this.minha_List = list;
        this.meu_LayoutInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View v = meu_LayoutInflater.inflate(R.layout.item_cardview, viewGroup, false);
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

    public void addListItem(ItemCard c, int position){
        minha_List.add(c);
        notifyItemInserted(position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView titulo, conteudo;

        public MyViewHolder(View itemView){
            super(itemView);

            titulo = (TextView) itemView.findViewById(R.id.text_titulo);
            conteudo = (TextView) itemView.findViewById(R.id.text_conteudo);

        }
    }
}
