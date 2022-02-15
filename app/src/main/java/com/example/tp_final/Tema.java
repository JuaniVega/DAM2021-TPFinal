package com.example.tp_final;

import androidx.core.util.Consumer;

import java.util.ArrayList;

public class Tema {
    private String nombre;
    private String cantPreguntas;

    public Tema(){};

    public Tema(Consumer<Tema> m){m.accept(this);}

    public String getCantPreguntas() {
        return cantPreguntas;
    }

    public void setCantPreguntas(String cantPreguntas) {
        this.cantPreguntas = cantPreguntas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<Tema> temas(){
        ArrayList<Tema> tem= new ArrayList<>();

        tem.add(new Tema(
                m->{
                    m.setNombre("MRU");
                    m.setCantPreguntas("8");
                }
        ));

        tem.add(new Tema(
                m->{
                    m.setNombre("MRUA");
                    m.setCantPreguntas("7");
                }
        ));

        tem.add(new Tema(
                m->{
                    m.setNombre("Movimiento circular");
                    m.setCantPreguntas("9");
                }
        ));
        return tem;
    }
}
