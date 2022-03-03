package com.example.tp_final;

import androidx.core.util.Consumer;

import java.util.ArrayList;

public class Examen {
    private String nombre;
    private int id;

    public Examen(){};

    public Examen(Consumer<Examen> e){e.accept(this);}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public static ArrayList<Examen> examenes(){
        ArrayList<Examen> exam= new ArrayList<>();

        exam.add(new Examen(
                e->{
                    e.setNombre("Examen 1");
                    e.setId(1);
                }
        ));

        exam.add(new Examen(
                e->{
                    e.setNombre("Examen 2");
                    e.setId(2);
                }
        ));

        exam.add(new Examen(
                e->{
                    e.setNombre("Examen 3");
                    e.setId(3);
                }
        ));

        exam.add(new Examen(
                e->{
                    e.setNombre("Examen 4");
                    e.setId(4);
                }
        ));

        exam.add(new Examen(
                e->{
                    e.setNombre("Examen 5");
                    e.setId(5);
                }
        ));
        return exam;
    }
}
