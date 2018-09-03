package com.example.taller.triviapp;

import android.app.Activity;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //https://github.com/ozwaldo/triviapp

    private static final String KEY_INDEX = "indice";
    private static final int REQUEST_CODE_TIP = 0;

    private Button mVerdaderoBoton;
    private Button mFalsoBoton;
    private Button mSiguienteBoton;
    private TextView mPregunta_text_view;
    private Button mTipBoton;

    private boolean mTipMostrado;

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

        mVerdaderoBoton = (Button) findViewById(R.id.verdadero_btn);
        mFalsoBoton = (Button) findViewById(R.id.falso_btn);
        mSiguienteBoton = (Button) findViewById(R.id.siguiente_btn);
        
        mVerdaderoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revisarRespuesta(true);
            }
        });
        mFalsoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revisarRespuesta(false);
            }
        });
        mSiguienteBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mIndiceActual = (mIndiceActual + 1) % mPreguntas.length;
                mTipMostrado = false;
                crearPregunta();
            }
        });
        mTipBoton = (Button) findViewById(R.id.tip_boton);
        mTipBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, TipActivity.class);

                boolean respuesta = mPreguntas[mIndiceActual].isRespuestaV();

                Intent intent = TipActivity.nuevoIntent(MainActivity.this,
                        respuesta);

                //startActivity(intent);

                startActivityForResult(intent, REQUEST_CODE_TIP);
            }
        });


        if (savedInstanceState != null) {
            mIndiceActual = savedInstanceState.getInt(KEY_INDEX,0);
        }

        crearPregunta();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mIndiceActual);
    }

    private void revisarRespuesta(boolean respUsuario) {
        boolean respTrue = mPreguntas[mIndiceActual].isRespuestaV();

        String menPreguntaId = null;

        if (mTipMostrado) {
            menPreguntaId = getResources().getString(R.string.malo_text);
        } else
            if (respUsuario == respTrue) {
                menPreguntaId = "Respuesta Correcta";
            } else {
                menPreguntaId = "Respuesta Incorrecta";
            }

        Toast.makeText(this, menPreguntaId, Toast.LENGTH_SHORT).show();

    }

    private void crearPregunta() {
        int pregunta = mPreguntas[mIndiceActual].getPreguntaId();
        mPregunta_text_view.setText(pregunta);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == REQUEST_CODE_TIP) {
            if (data == null) {
                return;
            }
            mTipMostrado = TipActivity.respMostrada(data);
        }
    }
}
