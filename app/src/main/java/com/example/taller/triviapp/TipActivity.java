package com.example.taller.triviapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TipActivity extends AppCompatActivity {

    private static final String EXTRA_RESP_MOSTRADA = "resp_mostrada";

    private Button mMostrarBoton;
    private TextView mTipView;
    private boolean mRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip);

        mTipView = (TextView) findViewById(R.id.resp_tip_text);
        mMostrarBoton = (Button) findViewById(R.id.ver_respuesta_boton);

        mRespuesta = getIntent().getBooleanExtra("RESPUESTA_TIP", false);

        mMostrarBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mRespuesta) {
                    mTipView.setText("Verdad");
                } else {
                    mTipView.setText("Falso");
                }
                setRespMostradaResult(true);
                //mTipView.setText(R.string.malo_text);
            }
        });

    }

    public void setRespMostradaResult(boolean respMostrada){
        Intent intent = new Intent();
        intent.putExtra(EXTRA_RESP_MOSTRADA, respMostrada);
        setResult(RESULT_OK,intent);

    }

    public static Intent nuevoIntent(Context contexto,
                                     boolean respuesta) {

        Intent intent = new Intent(contexto, TipActivity.class);
        intent.putExtra("RESPUESTA_TIP", respuesta);

        return intent;
    }

    public static boolean respMostrada(Intent intent) {
        return intent.getBooleanExtra(EXTRA_RESP_MOSTRADA, false);
    }


}
