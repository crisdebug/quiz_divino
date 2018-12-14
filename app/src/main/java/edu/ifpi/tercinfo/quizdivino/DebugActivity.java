package edu.ifpi.tercinfo.quizdivino;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DebugActivity extends AppCompatActivity {

    private Button dia1;
    private Button dia2;
    private Button dia3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debug);

        dia1 = findViewById(R.id.dia1);
        dia2 = findViewById(R.id.dia2);
        dia3 = findViewById(R.id.dia3);

        dia1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(1);
            }
        });
        dia2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(2);
            }
        });
        dia3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(3);

            }
        });
    }

    private void iniciar(int dia){
        Intent intent = new Intent(DebugActivity.this, StartActivity.class);
        intent.putExtra("dia", dia);
        startActivity(intent);
    }
}
