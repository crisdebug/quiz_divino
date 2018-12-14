package edu.ifpi.tercinfo.quizdivino;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import edu.ifpi.tercinfo.quizdivino.database.Pergunta;

public class MainActivity extends AppCompatActivity{

    private TextView msg;
    private TextView tempo;
    private TextView pergunta;
    private Button alt_a;
    private Button alt_b;
    private Button alt_c;

    private ArrayList<Pergunta> perguntas;

    private Button curr_correta;
    private int acertos;
    private int erros;
    HashMap<Button, Integer> alternativas = new HashMap<>();
    int dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        msg = findViewById(R.id.msg);
        tempo = findViewById(R.id.tempo);
        pergunta = findViewById(R.id.pergunta);
        alt_a = findViewById(R.id.alt_a);
        alt_b = findViewById(R.id.alt_b);
        alt_c = findViewById(R.id.alt_c);

        dia = getIntent().getIntExtra("dia", 0);

        perguntas = (ArrayList<Pergunta>) getIntent().getSerializableExtra("perguntas");


        setarPergunta();

    }

    private void setarPergunta() {
        Pergunta actualPergunta = new Pergunta();
        try {
            actualPergunta = perguntas.get(0);
        }catch (Exception e){
            proxTela();
        }

        msg.setVisibility(View.GONE);
        tempo.setVisibility(View.GONE);
        pergunta.setText(actualPergunta.getPergunta());
        alt_a.setText(actualPergunta.getAlternativas()[0]);
        alt_b.setText(actualPergunta.getAlternativas()[1]);
        alt_c.setText(actualPergunta.getAlternativas()[2]);
        alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));

        alternativas.put(alt_a,0);
        alternativas.put(alt_b,1);
        alternativas.put(alt_c,2);
        switch (actualPergunta.getCorreta()){
            case 0:
                curr_correta = alt_a;
                break;
            case  1:
                curr_correta = alt_b;
                break;
            case 2:
                curr_correta = alt_c;
                break;

        }
        alt_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_correta.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                if(alt_a == curr_correta){
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Correta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                    msg.setVisibility(View.VISIBLE);
                    acertos++;
                    checkPontos();
                }else if(alt_b == curr_correta){
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();
                }else{
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();
                }
                proxPergunta();
            }
        });
        alt_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_correta.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                if(alt_a == curr_correta){
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();
                }else if(alt_b == curr_correta){
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Correta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                    msg.setVisibility(View.VISIBLE);
                    acertos++;
                    checkPontos();
                }else{
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();
                }
                proxPergunta();
            }
        });
        alt_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                curr_correta.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
                if(alt_a == curr_correta){
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();
                }else if(alt_b == curr_correta){
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_c.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Incorreta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setVisibility(View.VISIBLE);
                    erros++;
                    checkPontos();

                }else{
                    alt_a.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    alt_b.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
                    msg.setText("Correta!");
                    msg.setTextColor(getResources().getColor(android.R.color.holo_green_light));
                    msg.setVisibility(View.VISIBLE);
                    acertos++;
                    checkPontos();
                }
                proxPergunta();
            }
        });
    }

    private void proxPergunta() {
        tempo.setVisibility(View.VISIBLE);
        new CountDownTimer(4000, 1000){
            @Override
            public void onTick(long millisUntilFinished) {
                tempo.setText(String.valueOf(millisUntilFinished/1000));
                Log.i("DATA", "thicc");
            }

            @Override
            public void onFinish() {
                tempo.setVisibility(View.GONE);
                perguntas.remove(0);
                setarPergunta();
            }
        }.start();


    }

    private void checkPontos(){

        if(erros == 2){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.putExtra("erros", erros);
            intent.putExtra("dia", dia);
            Log.i("DATA", "Erros: "+erros);
            startActivity(intent);
        }
    }
    private void proxTela(){
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        int questoes = 5 - perguntas.size();
        intent.putExtra("acertos", acertos);
        intent.putExtra("dia", dia);
        intent.putExtra("questoes", questoes);
        Log.i("DATA", "acertos: "+acertos);
        startActivity(intent);
    }
}
