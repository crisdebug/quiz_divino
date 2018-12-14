package edu.ifpi.tercinfo.quizdivino.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class OpenHelper extends SQLiteAssetHelper {

     private static final String DB_Name = "Questionario.db";
     private static final int VERSION = 1;
     public static final String TABLE_NAME = "Questao";
     public static final String COL_ID = "id";
     public static final String COL_PERG = "Pergunta";
     public static final String ALT_A = "Alt_A";
     public static final String ALT_B = "Alt_B";
     public static final String ALT_C = "Alt_C";
     public static final String ALT_CERTA = "Alt_Certa";
     public static final String DIA = "Dia";

    public OpenHelper(Context context) {
        super(context, DB_Name, null, VERSION);

    }
}
