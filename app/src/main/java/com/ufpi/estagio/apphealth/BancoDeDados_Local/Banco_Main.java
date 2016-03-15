package com.ufpi.estagio.apphealth.BancoDeDados_Local;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lucas on 13/03/2016.
 */
public class Banco_Main extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "database_apphealth";
    private static final int DATABASE_VERSION = 6;
    private static final String CADASTRO_TABLE_NAME = "cadastros";
    private static final String AVALIACOES_TABLE_NAME = "avaliacoes";
    private static final String AVALIADOS_TABLE_NAME = "avaliados";
    private static final String RESULTADOS_TABLE_NAME = "avaliados";

    //o _id é usado, porque caso seja colocado outro nome, o autoincrement não irá funcionar
    private static final String CADASTRO_TABLE_CREATE =
            "CREATE TABLE " + CADASTRO_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, senha TEXT NOT " +
                    "NULL);";

    private static final String AVALIACOES_TABLE_CREATE =
            "CREATE TABLE " + AVALIACOES_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, id_avaliado INTEGER NOT NULL, id_avaliador" +
                    " INTEGER NOT NULL, teste_01 REAL, teste_02 REAL, teste_03 REAL, teste_04 REAL, teste_05 REAL, teste_06 REAL, teste_07 REAL," +
                    " teste_08 REAL, status_envio TEXT NOT NULL);";

    private static final String AVALIADOS_TABLE_CREATE =
            "CREATE TABLE " + AVALIADOS_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, nome_avaliado INTEGER NOT NULL, altura REAL" +
                    " NOT NULL, peso REAL NOT NULL, idade INTEGER NOT NULL, sexo CHARACTER(1) NOT NULL, estado_fisico CHARACTER(1) NOT NULL);";

    private static final String RESULTADOS_TABLE_CREATE =
            "CREATE TABLE " + RESULTADOS_TABLE_NAME + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, id_avaliado INTEGER NOT NULL, id_avaliador" +
                    " INTEGER NOT NULL, id_avaliacao INTEGER NOT NULL, imc TEXT, teste_01 TEXT, teste_02 TEXT, teste_03 TEXT, teste_04 TEXT," +
                    " teste_05 TEXT, teste_06 TEXT, teste_07 TEXT, teste_08 TEXT);";

    //se o banco não existir ele cria o banco
    public Banco_Main(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase banco){
        banco.execSQL(CADASTRO_TABLE_CREATE);
        banco.execSQL(AVALIACOES_TABLE_CREATE);
        banco.execSQL(AVALIADOS_TABLE_CREATE);
        banco.execSQL(RESULTADOS_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int oldVersion, int newVersion) {
        if(verificarSeExiste(banco, CADASTRO_TABLE_NAME)) banco.execSQL("DROP TABLE "+CADASTRO_TABLE_NAME);
        if(verificarSeExiste(banco, AVALIACOES_TABLE_NAME)) banco.execSQL("DROP TABLE "+AVALIACOES_TABLE_NAME);
        if(verificarSeExiste(banco, AVALIADOS_TABLE_NAME)) banco.execSQL("DROP TABLE "+AVALIADOS_TABLE_NAME);
        if(verificarSeExiste(banco,RESULTADOS_TABLE_NAME)) banco.execSQL("DROP TABLE "+RESULTADOS_TABLE_NAME);
        onCreate(banco);
    }

    public boolean verificarSeExiste(SQLiteDatabase banco, String table){
        boolean existe = false;

        try {
            Cursor c = banco.query(table, null, null, null, null, null, null);
            existe = true;
        }catch (Exception e){
        }

        return existe;
    }

}
