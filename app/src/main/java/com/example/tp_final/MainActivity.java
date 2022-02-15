package com.example.tp_final;


import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.model.Subtemas;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_preguntas);

        /** creando subtemas **/
       /* ArrayList<Subtemas> subt = new ArrayList<>();
        Subtemas sub1 = new Subtemas ( s -> {
            s.setTitulo("MRU");
            s.setsetCantidad_preguntas(5);
        });
        subt.add(sub1);
        Subtemas sub2 = new Subtemas ( s -> {
            s.setTitulo("MRUA");
            s.setsetCantidad_preguntas(3);
        });
        subt.add(sub2);*/
    }
}