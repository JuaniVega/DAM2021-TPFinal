package com.example.tp_final.libreriaDePreguntas;

public class PreguntasAlgebra {

    private String mPreguntas [] = {
            "Cuándo dos vectores son coplanares?",
            "Una recta tiene pendiente 3 y pasa por el punto (3,2). La abcisa de otro punto" +
                    "de la recta es 4. Hallar su ordenada:",
            "Qué es álgebra y geometría analítica?",
            "Qué indica el coeficiente de un término?",
            "Resolver: 5x - 18 = 8 + 3x",
            "Hallar dos números sabiendo que su suma es de 78 unidades y su diferencia 42.",
    };

    private String mRespuestas [][] = {
            {"Dos vectores son coplanares si son linealmente dependientes", "Dos vectores son coplanares si son linealmente independientes", "Nunca dos vectores pueden ser coplanares"},
            {"2", "1", "5"},
            {"Rama de la geometría que estudia los cuerpos geométricos a través de un sistema de coordenadas",
                    "Rama de la geometría que estudia los sistemas de coordenadas",
                    "Las dos respuestas son correctas"},
            {"Las veces en que se multiplica la parte literal",
                    "Las veces que se repiten por sumando la parte literal",
                    "No indica nada"},
            {"x = 2", "x = 13", "x = 5"},
            {"x = 78; y = 42", "x = -60; y = 18", "x = 60; y = 18"},
    };

    private String mRespuestasCorrectas [] = {
            "Dos vectores son coplanares si son linealmente dependientes",
            "5",
            "Rama de la geometría que estudia los cuerpos geométricos a través de un sistema de coordenadas",
            "Las veces en que se multiplica la parte literal",
            "x = 13",
            "x = 60; y = 18",
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
}
