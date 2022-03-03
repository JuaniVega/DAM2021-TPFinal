package com.example.tp_final.libreriaDePreguntas;

public class PreguntasAnalisisMatematicoI {

    private String mPreguntas [] = {
            "El resto de dividir a P(x) = 2x^3 - 5x^2 + 7x + 60 por" +
                    "Q(x) = x + 3 es:",
            "La función f(x) = x^4 + 8x^3 es creciente en",
            "La cantidad de soluciones de la ecuación 4 ln(x) = x es igual a:",
            "Sea f(x) = sen(2x)-k. Si el valor máximo de f es -3/5, entonces k es:",
            "Sea f(x) = 2 ln(x-2) + 3, dar su dominio.",
            "Qué es la derivada de una función en un punto?",
    };

    private String mRespuestas [][] = {
            {"90", "60", "-90"},
            {"(-6 ; infinito)", "(-6 ; 0)", "(0 ; infinito)"},
            {"4", "2", "1"},
            {"2/5", "1/5", "4/5"},
            {"(2 ; infinito)", "(0 ; 2)", "(-infinito ; 0)"},
            {"Pendiente de la recta tangente a esa función en ese punto",
                    "Pendiente de la recta tangente a esa función en cualquier punto",
                    "Pendiente de la recta tangente a cualquier función en ese punto"},
    };

    private String mRespuestasCorrectas [] = {
            "60",
            "(-6 ; infinito)",
            "2",
            "4/5",
            "(0 ; 2)",
            "Pendiente de la recta tangente a esa función en ese punto",
    };

    private String temas [] = {
            "Tema 1",
            "Tema 2",
            "Tema 3",
            "Tema 2",
            "Tema 3",
            "Tema 6",
    };

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

    public String[] getTemas() { return temas; }

    public String[] getmPreguntas() {
        return mPreguntas;
    }

    public String[][] getmRespuestas() {
        return mRespuestas;
    }

    public String[] getmRespuestasCorrectas() {
        return mRespuestasCorrectas;
    }
}
