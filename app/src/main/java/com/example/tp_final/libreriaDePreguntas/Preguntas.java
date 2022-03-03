package com.example.tp_final.libreriaDePreguntas;

public class Preguntas {

    public Preguntas() {
    }

    private String mPreguntas [];
    private String mRespuestas [][];
    private String mRespuestasCorrectas [];
    private String mTemas [];

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

    public String getTemas(int a){
        String tema = mTemas[a];
        return tema;
    }

    public String[] getmPreguntas() {
        return mPreguntas;
    }

    public String[][] getmRespuestas() {
        return mRespuestas;
    }

    public String[] getmRespuestasCorrectas() {
        return mRespuestasCorrectas;
    }

    public String[] getmTemas() {
        return mTemas;
    }

    public void setmTemas(String[] mTemas) {
        this.mTemas = mTemas;
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
