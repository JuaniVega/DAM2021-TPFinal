package com.example.tp_final.libreriaDePreguntas;

import java.util.ArrayList;

public class Preguntas {

    public Preguntas(){}

    private String mPreguntas [];
    private String mRespuestas [][];
    private String mRespuestasCorrectas [];

    public String getPregunta(int a) {
        String pregunta = mPreguntas[a];
        return pregunta;
    }

    public String getRespuesta1(int a){
        String respuesta0 = mRespuestas[a][0];
        return respuesta0;
    }

    public String getRespuesta2(int a){
        String respuesta1 = mRespuestas[a][1];
        return respuesta1;
    }

    public String getRespuesta3(int a){
        String respuesta2 = mRespuestas[a][2];
        return respuesta2;
    }

    public String getRespuestaCorrecta(int a){
        String rtaCorrecta = mRespuestasCorrectas[a];
        return rtaCorrecta;
    }

    public void setmPreguntas(String[] mPreguntas) {
        this.mPreguntas = mPreguntas;
    }

    public void setmRespuestas(String[][] mRespuestas) {
        this.mRespuestas = mRespuestas;
    }

    public void setmRespuestasCorrectas(String[] mRespuestasCorrectas) {
        this.mRespuestasCorrectas = mRespuestasCorrectas;
    }
}
