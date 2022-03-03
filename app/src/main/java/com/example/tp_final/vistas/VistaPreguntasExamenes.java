package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MainActivity;
import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.libreriaDePreguntas.ContadorPreguntas;
import com.example.tp_final.libreriaDePreguntas.Preguntas;
import com.example.tp_final.libreriaDePreguntas.PreguntasAlgebra;
import com.example.tp_final.libreriaDePreguntas.PreguntasAnalisisMatematicoI;
import com.example.tp_final.libreriaDePreguntas.PreguntasAnalisisMatematicoII;
import com.example.tp_final.libreriaDePreguntas.PreguntasFisicaI;
import com.example.tp_final.libreriaDePreguntas.PreguntasFisicaII;

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

    private PreferenciaDataSource preferenciaDataSource;
    private String materiaElegida;



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
      //  preferenciaDataSource = new PreferenciaDataSource(this);
        mPreguntas = contadorPreguntas.getmPreguntas();
       // materiaElegida = preferenciaDataSource.recuperarMatElegida();
       // obtenerLibreriaDePreguntas(materiaElegida);
        cantPreguntas=mPreguntas.getmPreguntas().length;

        //mPreguntas = new Preguntas();
        //preferenciaDataSource = new PreferenciaDataSource(this);
        //materiaElegida = preferenciaDataSource.recuperarMatElegida();

       // obtenerLibreriaDePreguntas(materiaElegida);

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

    /*private Preguntas obtenerLibreriaDePreguntas(String materia){
        switch (materia){
            case "Fisica I":
                PreguntasFisicaI mPreguntasFisicaI = new PreguntasFisicaI();
                mPreguntas.setmPreguntas(mPreguntasFisicaI.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasFisicaI.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasFisicaI.getmRespuestasCorrectas());
                return mPreguntas;
            case "Fisica II":
                PreguntasFisicaII mPreguntasFisicaII = new PreguntasFisicaII();
                mPreguntas.setmPreguntas(mPreguntasFisicaII.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasFisicaII.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasFisicaII.getmRespuestasCorrectas());
                return mPreguntas;
            case "Análisis matemático I":
                PreguntasAnalisisMatematicoI mPreguntasAnalisisI = new PreguntasAnalisisMatematicoI();
                mPreguntas.setmPreguntas(mPreguntasAnalisisI.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAnalisisI.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAnalisisI.getmRespuestasCorrectas());
                return mPreguntas;
            case "Análisis matemático II":
                PreguntasAnalisisMatematicoII mPreguntasAnalisisII = new PreguntasAnalisisMatematicoII();
                mPreguntas.setmPreguntas(mPreguntasAnalisisII.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAnalisisII.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAnalisisII.getmRespuestasCorrectas());
                return mPreguntas;
            case "Álgebra y geometría analítica":
                PreguntasAlgebra mPreguntasAlgebra = new PreguntasAlgebra();
                mPreguntas.setmPreguntas(mPreguntasAlgebra.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAlgebra.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAlgebra.getmRespuestasCorrectas());
                return mPreguntas;
        }
        return null;
    }*/

    /*private void actualizarPregunta(){
        pregunta.setText(mPreguntas.getPregunta(numeroDePregunta));
        rta1.setText(mPreguntas.getRespuesta1(numeroDePregunta));
        rta2.setText(mPreguntas.getRespuesta2(numeroDePregunta));
        rta3.setText(mPreguntas.getRespuesta3(numeroDePregunta));

        respuesta = mPreguntas.getRespuestaCorrecta(numeroDePregunta);
        numeroDePregunta++;
    }*/

    private void actualizarPreguntaRandom(){
        numeroDePregunta = (int) (Math.random() * (cantPreguntas - 1));

        pregunta.setText(mPreguntas.getPregunta(numeroDePregunta));
        rta1.setText(mPreguntas.getRespuesta1(numeroDePregunta));
        rta2.setText(mPreguntas.getRespuesta2(numeroDePregunta));
        rta3.setText(mPreguntas.getRespuesta3(numeroDePregunta));

        respuesta = mPreguntas.getRespuestaCorrecta(numeroDePregunta);

        numPregunta.setText("Pregunta N° " + cont);
        cont=cont+1;
        }
    }

