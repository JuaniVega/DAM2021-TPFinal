package com.example.tp_final.libreriaDePreguntas;

public class PreguntasFisicaI {

    private String mPreguntas [] = {
            "Un microgramo en kilogramos es igual a:",
            "El movimiento de un cuerpo es:",
            "Cuando se habla de la velocidad media, nos referimos a un movimiento:",
            "El cociente entre la variación de la velocidad y el tiempo en que se produce se llama:",
            "Señale la respuesta falsa. ¿Cuál de estos fenómenos pueden generar una onda electromagnética?",
            "¿Cuánto vale el peso neto y su incertidumbre cuando se realiza una pesada con una balanza de precisión y se obtiene " +
                    "el valor de 3,162 g, siendo la tara de 2,141 g. Utilice la composición cuadrática de errores. ",
    };

    private String mRespuestas [][] = {
            {"10^-8", "10^-10", "10^-9"},
            {"Absoluto", "Relativo", "Absoluto y relativo"},
            {"Uniforme", "Variado y uniforme", "Variado"},
            {"Velocidad uniforme", "Aceleración", "Velocidad y aceleración"},
            {"La aceleración de un Positrón", "La desexcitación de un núcleo atómico", "La vibración de un cristal piezoeléctrico"},
            {"-1,021 +- 0,050", "1,021 +- 0,050", "1,021 +- 0,029"},
    };

    private String mRespuestasCorrectas [] = {
            "10^-8",
            "Relativo",
            "Variado y uniforme",
            "Aceleración",
            "La vibración de un cristal piezoeléctrico",
            "1,021 +- 0,050",
    };

    private String temas [] = {
            "Tema 1",
            "Tema 2",
            "Tema 3",
            "Tema 3",
            "Tema 5",
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

    public String[] getmRespuestasCorrectas() {
        return mRespuestasCorrectas;
    }

    public String[][] getmRespuestas() {
        return mRespuestas;
    }
}
