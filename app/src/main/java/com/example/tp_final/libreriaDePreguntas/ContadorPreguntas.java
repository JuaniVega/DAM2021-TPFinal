package com.example.tp_final.libreriaDePreguntas;

import android.content.Context;
import com.example.tp_final.PreferenciaDataSource;

public class ContadorPreguntas {

    private Preguntas mPreguntas;
    private int cantPreguntasTotales;

    private PreferenciaDataSource preferenciaDataSource;
    private String materiaElegida;

    public ContadorPreguntas(Context ctx){
        mPreguntas = new Preguntas();
        preferenciaDataSource = new PreferenciaDataSource(ctx);
        materiaElegida = preferenciaDataSource.recuperarMatElegida();
        obtenerLibreriaDePreguntas(materiaElegida);

        cantPreguntasTotales=mPreguntas.getmPreguntas().length;
    }


    public int getCantPreguntasTotales() {
        return cantPreguntasTotales;
    }

    public Preguntas getmPreguntas() {
        return mPreguntas;
    }

    private Preguntas obtenerLibreriaDePreguntas(String materia){
        switch (materia){
            case "Fisica I":
                PreguntasFisicaI mPreguntasFisicaI = new PreguntasFisicaI();
                mPreguntas.setmPreguntas(mPreguntasFisicaI.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasFisicaI.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasFisicaI.getmRespuestasCorrectas());
                mPreguntas.setmTemas(mPreguntasFisicaI.getTemas());
                return mPreguntas;
            case "Fisica II":
                PreguntasFisicaII mPreguntasFisicaII = new PreguntasFisicaII();
                mPreguntas.setmPreguntas(mPreguntasFisicaII.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasFisicaII.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasFisicaII.getmRespuestasCorrectas());
                mPreguntas.setmTemas(mPreguntasFisicaII.getTemas());
                return mPreguntas;
            case "Análisis matemático I":
                PreguntasAnalisisMatematicoI mPreguntasAnalisisI = new PreguntasAnalisisMatematicoI();
                mPreguntas.setmPreguntas(mPreguntasAnalisisI.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAnalisisI.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAnalisisI.getmRespuestasCorrectas());
                mPreguntas.setmTemas(mPreguntasAnalisisI.getTemas());
                return mPreguntas;
            case "Análisis matemático II":
                PreguntasAnalisisMatematicoII mPreguntasAnalisisII = new PreguntasAnalisisMatematicoII();
                mPreguntas.setmPreguntas(mPreguntasAnalisisII.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAnalisisII.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAnalisisII.getmRespuestasCorrectas());
                mPreguntas.setmTemas(mPreguntasAnalisisII.getTemas());
                return mPreguntas;
            case "Álgebra y geometría analítica":
                PreguntasAlgebra mPreguntasAlgebra = new PreguntasAlgebra();
                mPreguntas.setmPreguntas(mPreguntasAlgebra.getmPreguntas());
                mPreguntas.setmRespuestas(mPreguntasAlgebra.getmRespuestas());
                mPreguntas.setmRespuestasCorrectas(mPreguntasAlgebra.getmRespuestasCorrectas());
                mPreguntas.setmTemas(mPreguntasAlgebra.getTemas());
                return mPreguntas;
        }
        return null;
    }

}
