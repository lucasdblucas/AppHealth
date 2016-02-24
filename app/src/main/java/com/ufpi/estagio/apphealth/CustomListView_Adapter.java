package com.ufpi.estagio.apphealth;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lucas on 23/02/2016.
 */
public class CustomListView_Adapter extends BaseAdapter {
    Context context;
    List<ItemLinha> itens_linha;

    public CustomListView_Adapter(Context context, List<ItemLinha> itens_linha) {
        this.context = context;
        this.itens_linha = itens_linha;
    }

    @Override
    public int getCount() {
        return itens_linha.size();
    }

    @Override
    public Object getItem(int position) {
        return itens_linha.get(position);
    }

    @Override
    public long getItemId(int position) {
        return itens_linha.indexOf(getItem(position));
    }

    /* classe para suporte */
    private class ViewSuporte {
        ImageView profile_pic;
        TextView nome_avaliado;
        //TextView status;
        TextView status_envio_cliente;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewSuporte suporte = new ViewSuporte();
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.custom_listview_item, null);

            suporte.nome_avaliado = (TextView) convertView.findViewById(R.id.nome_avaliado);
            suporte.profile_pic = (ImageView) convertView.findViewById(R.id.profile_pic);
            suporte.status_envio_cliente = (TextView) convertView.findViewById(R.id.status_evio_cliente);

            convertView.setTag(suporte);
        }
        else{
            suporte = (ViewSuporte) convertView.getTag();
        }

        ItemLinha linha_pos = itens_linha.get(position);

        suporte.profile_pic.setImageResource(linha_pos.getProfile_pic_ID());
        suporte.profile_pic.setImageResource(linha_pos.getProfile_pic_ID());
        suporte.nome_avaliado.setText(linha_pos.getNome_avaliado());
        suporte.status_envio_cliente.setText(linha_pos.getStatus_envio_cliente());
        //suporte.contactType.setText(row_pos.getContactType());

        return convertView;
    }

}
