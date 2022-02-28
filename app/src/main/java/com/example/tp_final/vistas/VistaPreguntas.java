package com.example.tp_final.vistas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.libreriaDePreguntas.Preguntas;
import com.example.tp_final.libreriaDePreguntas.PreguntasAlgebra;
import com.example.tp_final.libreriaDePreguntas.PreguntasAnalisisMatematicoI;
import com.example.tp_final.libreriaDePreguntas.PreguntasAnalisisMatematicoII;
import com.example.tp_final.libreriaDePreguntas.PreguntasFisicaI;
import com.example.tp_final.libreriaDePreguntas.PreguntasFisicaII;

public class VistaPreguntas extends AppCompatActivity {

    private Preguntas mPreguntas;

    private TextView pregunta;
    private Button rta1;
    private Button rta2;
    private Button rta3;
    private Button siguientePreg;

    private String respuesta;
    private int puntos = 0;
    private int numeroDePregunta = 0;
    private int numeroRta = 0;

    private PreferenciaDataSource preferenciaDataSource;
    private String materiaElegida;

    private Object aux;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_preguntas);

        pregunta = (TextView) findViewById(R.id.pregunta);
        rta1 = (Button) findViewById(R.id.btn_rta1);
        rta2 = (Button) findViewById(R.id.btn_rta2);
        rta3 = (Button) findViewById(R.id.btn_btn_rta3);
        siguientePreg = (Button) findViewById(R.id.btn_siguiente_preg);

        preferenciaDataSource = new PreferenciaDataSource(this);
        materiaElegida = preferenciaDataSource.recuperarMatElegida();
        obtenerLibreriaDePreguntas(materiaElegida);

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
                        break;
                    default:
                        Toast.makeText(VistaPreguntas.this, "Debes seleccionar una respuesta", Toast.LENGTH_LONG).show();
                }
                numeroRta = 0;
                rta1.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta1.setTextColor(getResources().getColor(R.color.darkGrey));
                rta2.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta2.setTextColor(getResources().getColor(R.color.darkGrey));
                rta3.setBackgroundResource(R.drawable.btn_redondeado_sin_color);
                rta3.setTextColor(getResources().getColor(R.color.darkGrey));
            }
        });

    }

    private Preguntas obtenerLibreriaDePreguntas(String materia){
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
    }

    private void actualizarPregunta(){
        pregunta.setText(mPreguntas.getPregunta(numeroDePregunta));
        rta1.setText(mPreguntas.getRespuesta1(numeroDePregunta));
        rta2.setText(mPreguntas.getRespuesta2(numeroDePregunta));
        rta3.setText(mPreguntas.getRespuesta3(numeroDePregunta));

        respuesta = mPreguntas.getRespuestaCorrecta(numeroDePregunta);
        numeroDePregunta++;
    }

}
