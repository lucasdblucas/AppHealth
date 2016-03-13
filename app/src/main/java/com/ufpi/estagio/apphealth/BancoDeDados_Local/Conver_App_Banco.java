package com.ufpi.estagio.apphealth.BancoDeDados_Local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by lucas on 13/03/2016.
 */
public class Conver_App_Banco {
    private SQLiteDatabase banco;

    public Conver_App_Banco (Context context){
        Banco_Main auxBanco = new Banco_Main(context);
        banco = auxBanco.getWritableDatabase();
    }
}
