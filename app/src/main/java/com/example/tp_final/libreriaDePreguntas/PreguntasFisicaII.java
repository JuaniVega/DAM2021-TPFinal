package com.example.tp_final.libreriaDePreguntas;

public class PreguntasFisicaII {

    private String mPreguntas [] = {
            "Se tiene un recipiente cilíndrico de 1m de altura. El diámetro de su base es 40 cm." +
                    "Se vierten en él 60l de agua. La presión manométrica en el fondo del recipiente es:",
            "Un cuerpo de masa 4kg está unido a un resorte vertical con k = 25 N/m. El otro extremo del" +
                    "resorte se encuentra fijo al techo. En t = 0, se estira el resorte 44 cm respecto de la" +
                    "posición de equilibrio del sistema. Determinar el instante en el cual el cuerpo pasa por primera" +
                    "vez por la posición de equilibrio.",
            "Los planetas P y Q son homogéneos. La masa del planeta P es el doble que la del planeta Q." +
                    "El radio de P el doble del de Q. Si llamamos g a la aceleración de la gravedad en la superficie" +
                    "de cada uno, entonces se cumple que:",
            "Un objeto atado a una cuerda de 0,9m de longitud, gira describiendo una circunferencia en un" +
                    "plano vertical. Calcular la velocidad mínima que puede tener ese objeto en la parte más alta" +
                    "de la trayectoria",
            "Un cuerpo que en la Tierra pesa 100N es llevado a un planeta cuya masa es el doble de la de" +
                    "la Tierra. Allí se verifica que el cuerpo pesa 800N. Entonces, si RT denota el radio terrestre," +
                    "el radio R del planeta es:",
            "La energía cinética de un fotoelectrón depende de:",
    };

    private String mRespuestas [][] = {
            {"10.000 Pa", "955 Pa", "4.775 Pa"},
            {"0.63 s", "2.51 s", "0.31 s"},
            {"GP = GQ/4", "GP = GQ/2", "GP = 2GQ"},
            {"0", "3 m/s", "6 m/s"},
            {"R = RT/2", "R = 2RT", "R = 4RT"},
            {"La velocidad de la luz", "La función de trabajo", "La intensidad de la luz"},
    };

    private String mRespuestasCorrectas [] = {
            "4.775 Pa",
            "0.63 s",
            "GP = GQ/2",
            "3 m/s",
            "R = RT/2",
            "La intensidad de la luz",
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

    public String[][] getmRespuestas() {
        return mRespuestas;
    }

    public String[] getmPreguntas() {
        return mPreguntas;
    }

    public String[] getmRespuestasCorrectas() {
        return mRespuestasCorrectas;
    }
}
