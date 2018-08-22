package com.example.taller.triviapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //https://github.com/ozwaldo/triviapp

    private Button mVerdaderoBoton;
    private Button mFalsoBoton;
    private Button mSiguienteBoton;
    private TextView mPregunta_text_view;

    private Pregunta[] mPreguntas = new Pregunta[] {
            new Pregunta(R.string.pregunta_uno_text, true),
            new Pregunta(R.string.pregunta_dos_text, false),
            new Pregunta(R.string.pregunta_tres_text, false),
            new Pregunta(R.string.pregunta_cuatro_text, true),
            new Pregunta(R.string.pregunta_cinco_text, false),
    };

    private int mIndiceActual = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPregunta_text_view = (TextView) findViewById(R.id.pregunta_tv);

        int pregunta = mPreguntas[mIndiceActual].getPreguntaId();
        
        mVerdaderoBoton = (Button) findViewById(R.id.verdadero_btn);
        mFalsoBoton = (Button) findViewById(R.id.falso_btn);
        mSiguienteBoton = (Button) findViewById(R.id.siguiente_btn);
        
        mVerdaderoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Verdadero", Toast.LENGTH_SHORT).show();
            }
        });
        mFalsoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Falso", Toast.LENGTH_SHORT).show();
            }
        });
        mSiguienteBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Siguiente", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
