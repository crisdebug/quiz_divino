package edu.ifpi.tercinfo.quizdivino;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import edu.ifpi.tercinfo.quizdivino.database.Pergunta;
import edu.ifpi.tercinfo.quizdivino.database.PerguntaDAO;

public class StartActivity extends AppCompatActivity {

    private Button iniciar;
    private int data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        iniciar = findViewById(R.id.iniciar);
        data = getIntent().getIntExtra("dia", 3);
        PerguntaDAO dao = PerguntaDAO.getInstance(this);
        dao.abrir();
        final ArrayList<Pergunta> perguntas = dao.pegarPerguntas(data);
        dao.fechar();
        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                intent.putExtra("perguntas", perguntas);
                startActivity(intent);
            }
        });

    }
}
