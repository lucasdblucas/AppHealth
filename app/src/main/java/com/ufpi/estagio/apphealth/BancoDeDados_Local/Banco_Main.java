package com.ufpi.estagio.apphealth.BancoDeDados_Local;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 13/03/2016.
 */
public class Banco_Main extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database_apphealth";
    private static final int DATABASE_VERSION = 1;
    private static final String CADASTRO_TABLE_NAME = "cadastros";
    private static final String CADASTRO_TABLE_CREATE =
            "CREATE TABLE " + CADASTRO_TABLE_NAME + " (_id integer primary key autoincrement not null, _nome text not null, senha text not" +
                    "null);";

    //se o banco não existir ele cria o banco
    public Banco_Main(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase banco){
        banco.execSQL(CADASTRO_TABLE_CREATE);// o null determina uma construção padrão do banco
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int oldVersion, int newVersion) {
        banco.execSQL("drop table "+CADASTRO_TABLE_NAME);
        onCreate(banco);
    }


}
