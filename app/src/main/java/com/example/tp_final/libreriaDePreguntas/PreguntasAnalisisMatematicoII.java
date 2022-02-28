package com.example.tp_final.libreriaDePreguntas;

public class PreguntasAnalisisMatematicoII {

    private String mPreguntas [] = {
            "Sea la función f(x, y) = (xe^1+y^2)^1/2. Se verifica que:",
            "Sea f una función diferenciable y homogénea de grado 3. Se verifica:",
            "Una función primitiva de la función f(x) = xe^x en el intervalo [0,10] es:",
            "Un cuerpo esférico de radio r = 2 tiene, en cada punto, una densidad directamente proporcional" +
                    "al doble de la distancia desde el punto al origen de coordenadas. Entonces, el flujo de" +
                    "rot(f) a través de E orientada hacia Z^+ resulta igual a:",
            "Dado f(x,y) = (x, 2x^3 + y) definido en R^2, una ecuación cartesiana para su familia de" +
                    "líneas de campo es:",
            "Dada f(x,y) = 2x + 8/x + 4/y definida en su dominio natural, si se analizan extremos locales" +
                    "de los valores de f se concluye que:",
    };

    private String mRespuestas [][] = {
            {"La curva de nivel 1 de f no existe", "El punto (1,1) pertenece a la curva de nivel e de f", "El punto (-1,0) pertenece al dominio de f"},
            {"f(1,0) = fx(1,0)", "f(2x,2y) = 2f(x,y)", "f(2x,2y) = 8f(x,y)"},
            {"G(x) = xe^x - 10e^x", "G(x) = xe^x", "G(x) = e^(x-1) + 3"},
            {"6kpi", "4kpi", "Ninguna es correcta"},
            {"y = x^3 + C x^2", "y = C x^3 + 2x", "y = x^3 + C x"},
            {"f(-2,-1) = -16 y f(2,1) = 16 son mínimos",
                    "f(-2,-1) = -16 es mínimo y f(2,1) = 16 es máximo",
                    "Ninguna es correcta"},
    };

    private String mRespuestasCorrectas [] = {
            "El punto (1,1) pertenece a la curva de nivel e de f",
            "f(2x,2y) = 8f(x,y)",
            "G(x) = e^(x-1) + 3",
            "Ninguna es correcta",
            "y = x^3 + C x^2",
            "f(-2,-1) = -16 y f(2,1) = 16 son mínimos",
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
