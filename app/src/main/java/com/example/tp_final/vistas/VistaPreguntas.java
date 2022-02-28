package com.example.tp_final.vistas;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tp_final.R;
import com.example.tp_final.libreriaDePreguntas.PreguntasFisicaI;
import com.google.android.material.navigation.NavigationView;

public class VistaPreguntas extends AppCompatActivity {

    private PreguntasFisicaI mPreguntasFisicaI = new PreguntasFisicaI();

    private TextView pregunta;
    private Button rta1;
    private Button rta2;
    private Button rta3;
    private Button siguientePreg;

    private String respuesta;
    private int puntos = 0;
    private int numeroDePregunta = 0;
    private int numeroRta = 0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_preguntas);

        pregunta = (TextView) findViewById(R.id.pregunta);
        rta1 = (Button) findViewById(R.id.btn_rta1);
        rta2 = (Button) findViewById(R.id.btn_rta2);
        rta3 = (Button) findViewById(R.id.btn_btn_rta3);
        siguientePreg = (Button) findViewById(R.id.btn_siguiente_preg);

        actualizarPregunta();

        rta1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroRta = 1;
                rta1.setBackgroundResource(R.drawable.btn_redondeado_color);
                rta1.setTextColor(getResources().getColor(R.color.white));
                rta2.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta2.setTextColor(getResources().getColor(R.color.darkGrey));
                rta3.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta3.setTextColor(getResources().getColor(R.color.darkGrey));
            }
        });

        rta2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroRta = 2;
                rta1.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta1.setTextColor(getResources().getColor(R.color.darkGrey));
                rta2.setBackgroundResource(R.drawable.btn_redondeado_color);
                rta2.setTextColor(getResources().getColor(R.color.white));
                rta3.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta3.setTextColor(getResources().getColor(R.color.darkGrey));
            }
        });

        rta3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numeroRta = 3;
                rta1.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta1.setTextColor(getResources().getColor(R.color.darkGrey));
                rta2.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta2.setTextColor(getResources().getColor(R.color.darkGrey));
                rta3.setBackgroundResource(R.drawable.btn_redondeado_color);
                rta3.setTextColor(getResources().getColor(R.color.white));
            }
        });

        siguientePreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (numeroRta) {
                    case 1:
                        if(rta1.getText() == respuesta) {
                            puntos = puntos + 1;
                            Toast.makeText(VistaPreguntas.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        } else {
                            Toast.makeText(VistaPreguntas.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        }
                        break;
                    case 2:
                        if(rta2.getText() == respuesta) {
                            puntos = puntos + 1;
                            Toast.makeText(VistaPreguntas.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        } else {
                            Toast.makeText(VistaPreguntas.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        }
                        break;
                    case 3:
                        if(rta3.getText() == respuesta) {
                            puntos = puntos + 1;
                            Toast.makeText(VistaPreguntas.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        } else {
                            Toast.makeText(VistaPreguntas.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                            actualizarPregunta();
                        }
                    default:
                        Toast.makeText(VistaPreguntas.this, "Debes seleccionar una respuesta", Toast.LENGTH_LONG).show();
                }
                numeroRta = 0;
            }
        });

    }

    private void actualizarPregunta(){
        pregunta.setText(mPreguntasFisicaI.getPregunta(numeroDePregunta));
        rta1.setText(mPreguntasFisicaI.getRespuesta1(numeroDePregunta));
        rta2.setText(mPreguntasFisicaI.getRespuesta2(numeroDePregunta));
        rta3.setText(mPreguntasFisicaI.getRespuesta3(numeroDePregunta));

        respuesta = mPreguntasFisicaI.getRespuestaCorrecta(numeroDePregunta);
        numeroDePregunta++;
    }

}
