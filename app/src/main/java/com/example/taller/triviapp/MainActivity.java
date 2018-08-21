package com.example.taller.triviapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    
    private Button mVerdaderoBoton;
    private Button mFalsoBoton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mVerdaderoBoton = (Button) findViewById(R.id.verdadero_btn);
        mFalsoBoton = (Button) findViewById(R.id.falso_btn);
        
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
    }
}
