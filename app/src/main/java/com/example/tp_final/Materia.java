package com.example.tp_final;

import androidx.core.util.Consumer;

import java.util.ArrayList;

public class Materia{
    private String nombre;
    private int id;

    public Materia(){};

    public Materia(Consumer<Materia> m){m.accept(this);}

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public static ArrayList<Materia> materias(){
        ArrayList<Materia> mat= new ArrayList<>();

        mat.add(new Materia(
                m->{
                    m.setNombre("Fisica I");
                    m.setId(1);
                }
        ));

        mat.add(new Materia(
                m->{
                    m.setNombre("Fisica II");
                    m.setId(2);
                }
        ));

        mat.add(new Materia(
                m->{
                    m.setNombre("Análisis matemático I");
                    m.setId(3);
                }
        ));

        mat.add(new Materia(
                m->{
                    m.setNombre("Análisis matemático II");
                    m.setId(4);
                }
        ));

        mat.add(new Materia(
                m->{
                    m.setNombre("Álgebra y geometría analítica");
                    m.setId(5);
                }
        ));
        return mat;
    }
}
