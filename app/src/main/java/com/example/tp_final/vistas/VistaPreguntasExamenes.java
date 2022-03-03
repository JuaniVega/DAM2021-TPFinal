package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.libreriaDePreguntas.ContadorPreguntas;
import com.example.tp_final.libreriaDePreguntas.Preguntas;

public class VistaPreguntasExamenes extends AppCompatActivity {

    private Preguntas mPreguntas;
    private ContadorPreguntas contadorPreguntas;

    private TextView pregunta;
    private TextView tema;
    private TextView numPregunta;
    private TextView volver;
    private Button rta1;
    private Button rta2;
    private Button rta3;
    private Button siguientePreg;
    private Button ayuda;

    private String respuesta;
    private int puntos = 0;
    private int numeroDePregunta = 0;
    private int numeroRta = 0;
    private int cont=1;
    private int cantPreguntas;
    private long tiempoPresionado;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_preguntas_examenes);

        tema = (TextView) findViewById(R.id.txt_tema_exam);
        numPregunta = (TextView) findViewById(R.id.txt_numero_pregunta_vp);
        pregunta = (TextView) findViewById(R.id.pregunta_exam);
        rta1 = (Button) findViewById(R.id.btn_rta1_exam);
        rta2 = (Button) findViewById(R.id.btn_rta2_exam);
        rta3 = (Button) findViewById(R.id.btn_rta3_exam);
        siguientePreg = (Button) findViewById(R.id.btn_siguiente_preg_exam);
        volver =(TextView) findViewById(R.id.txt_volver_atras_exam);
        ayuda = (Button) findViewById(R.id.btn_ayuda_exam);

        mPreguntas = new Preguntas();
        contadorPreguntas = new ContadorPreguntas(getApplicationContext());
        mPreguntas = contadorPreguntas.getmPreguntas();
        cantPreguntas=mPreguntas.getmPreguntas().length;

        tema.setText(getIntent().getExtras().getString("tit_examen"));

        actualizarPreguntaRandom();

        ayuda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VistaPreguntasExamenes.this, "Ayuda solicitada", Toast.LENGTH_SHORT).show();
            }
        });

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tiempoPresionado+2000 > System.currentTimeMillis()){
                    VistaPreguntasExamenes.super.onBackPressed();
                    puntos=0;
                }else{
                    Toast.makeText(VistaPreguntasExamenes.this, "Presiona otra vez para volver", Toast.LENGTH_SHORT).show();
                }
                tiempoPresionado=System.currentTimeMillis();
            }
        });

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
                if(cont<cantPreguntas) {
                    switch (numeroRta) {
                        case 1:
                            if (rta1.getText() == respuesta) {
                                puntos = puntos + 1;
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            } else {
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            }
                            break;
                        case 2:
                            if (rta2.getText() == respuesta) {
                                puntos = puntos + 1;
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            } else {
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            }
                            break;
                        case 3:
                            if (rta3.getText() == respuesta) {
                                puntos = puntos + 1;
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta correcta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            } else {
                                Toast.makeText(VistaPreguntasExamenes.this, "Respuesta incorrecta", Toast.LENGTH_SHORT).show();
                                actualizarPreguntaRandom();
                            }
                            break;
                        default:
                            Toast.makeText(VistaPreguntasExamenes.this, "Debes seleccionar una respuesta", Toast.LENGTH_LONG).show();
                    }
                    numeroRta = 0;
                    rta1.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                    rta1.setTextColor(getResources().getColor(R.color.darkGrey));
                    rta2.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                    rta2.setTextColor(getResources().getColor(R.color.darkGrey));
                    rta3.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                    rta3.setTextColor(getResources().getColor(R.color.darkGrey));
                }else {
                    Intent i2=new Intent(VistaPreguntasExamenes.this, VistaPuntajes.class);
                    i2.putExtra("mat", tema.getText().toString());
                    i2.putExtra("punt", puntos);
                    startActivity(i2);
                }
            }
        });

    }

    private void actualizarPreguntaRandom(){
        int numDePregunta [] = numeroSinRepetir();

        pregunta.setText(mPreguntas.getPregunta(numDePregunta[cont-1]));
        rta1.setText(mPreguntas.getRespuesta1(numDePregunta[cont-1]));
        rta2.setText(mPreguntas.getRespuesta2(numDePregunta[cont-1]));
        rta3.setText(mPreguntas.getRespuesta3(numDePregunta[cont-1]));

        respuesta = mPreguntas.getRespuestaCorrecta(numDePregunta[cont-1]);

        numPregunta.setText("Pregunta N° " + cont);
        cont=cont+1;
        }

    private int[] numeroSinRepetir() {
        int i=0, arreglo[] = new int[cantPreguntas];

        arreglo[i]=(int) (Math.random() * (cantPreguntas));
        for(i=1; i<cantPreguntas;i++){
            arreglo[i]=(int) (Math.random() * (cantPreguntas));
            for(int j=0; j<i; j++){
                if(arreglo[i]==arreglo[j]){
                    i--;
                }
            }
        }
        return arreglo;
    }

    @Override
    public void onBackPressed (){

    }
}

