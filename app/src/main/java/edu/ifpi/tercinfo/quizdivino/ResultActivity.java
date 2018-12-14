package edu.ifpi.tercinfo.quizdivino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private int acertos;
    private int erros;
    private int questoes;

    private TextView mensagem;
    private TextView msgAcertos;
    private Button reiniciar;
    private int dia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        acertos = getIntent().getIntExtra("acertos", 0);
        erros = getIntent().getIntExtra("erros", 0);
        questoes = getIntent().getIntExtra("questoes", 0);
        dia = getIntent().getIntExtra("dia", 0);

        mensagem = findViewById(R.id.mensagem);
        msgAcertos = findViewById(R.id.acertos);
        reiniciar = findViewById(R.id.reiniciar);

        if(erros == 2){
            mensagem.setTextColor(getResources().getColor(android.R.color.holo_red_light));
            mensagem.setText("Que Pena!");
            msgAcertos.setText("Você atingiu o número limite de erros");
        }else{
            mensagem.setTextColor(getResources().getColor(android.R.color.holo_green_light));
            mensagem.setText("Parabéns!!");
            mensagem.setText("Você acertou "+acertos+" de "+questoes);
        }

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this, StartActivity.class);
                intent.putExtra("dia", dia);
                startActivity(intent);
            }
        });

    }
}