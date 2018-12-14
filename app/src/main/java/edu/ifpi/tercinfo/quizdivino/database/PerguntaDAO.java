package edu.ifpi.tercinfo.quizdivino.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.Collections;

public class PerguntaDAO {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static PerguntaDAO instance;


    private PerguntaDAO(Context context){
        this.openHelper = new OpenHelper(context);
    }

    public static PerguntaDAO getInstance(Context context){
        if(instance == null){
            instance = new PerguntaDAO(context);
        }
        return instance;
    }

    public void abrir(){
        this.db = openHelper.getWritableDatabase();
    }

    public void fechar(){
        if(this.db != null){
            this.db.close();
        }
    }

    public ArrayList<Pergunta> pegarPerguntas(int dia){
        ArrayList<Pergunta> perguntas = new ArrayList<>();
        ArrayList<Pergunta> allPerguntas = new ArrayList<>();
        Cursor cursor;
        if(dia!=3) {
            cursor = db.query(OpenHelper.TABLE_NAME, null, "Dia = ?", new String[]{String.valueOf(dia)}, null, null, null);
        }else{
            cursor = db.query(OpenHelper.TABLE_NAME, null, null, null, null, null, null);
        }
        if(cursor.moveToFirst()){
            while (!cursor.isAfterLast()) {
                Pergunta pergunta = new Pergunta();
                pergunta.setId(cursor.getLong(cursor.getColumnIndex(OpenHelper.COL_ID)));
                pergunta.setPergunta(cursor.getString(cursor.getColumnIndex(OpenHelper.COL_PERG)));
                String[] alternativas = new String[3];
                alternativas[0] = cursor.getString(cursor.getColumnIndex(OpenHelper.ALT_A));
                alternativas[1] = cursor.getString(cursor.getColumnIndex(OpenHelper.ALT_B));
                alternativas[2] = cursor.getString(cursor.getColumnIndex(OpenHelper.ALT_C));
                pergunta.setAlternativas(alternativas);
                pergunta.setCorreta(cursor.getInt(cursor.getColumnIndex(OpenHelper.ALT_CERTA)));
                pergunta.setDia(cursor.getInt(cursor.getColumnIndex(OpenHelper.DIA)));
                allPerguntas.add(pergunta);
                cursor.moveToNext();
            }
        }
        cursor.close();
        Collections.shuffle(allPerguntas);
        for (int i = 0; i<5; i++){
            perguntas.add(allPerguntas.get(i));
        }
        return perguntas;
    }

}
