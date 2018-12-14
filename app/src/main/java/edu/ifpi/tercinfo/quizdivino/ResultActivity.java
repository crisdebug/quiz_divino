package edu.ifpi.tercinfo.quizdivino;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ResultActivity extends AppCompatActivity {

    private int acertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        acertos = getIntent().getIntExtra("acertos", 0);

        if(acertos > 3){
            Log.i("DATA", "Parabéns, você acertou "+acertos+"/5");
        }else{
            Log.i("DATA", "Infelizmente você excedeu o número de erros");
        }

    }
}
