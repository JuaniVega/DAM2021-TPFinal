package com.example.tp_final.model;

public class Subtemas { //clase para setear los distintos subtemas de cada tema
    private String titulo;
    private int cantidad_preguntas;

    public Subtemas(String titulo, int cantidad_preguntas) {
        this.titulo = titulo;
        this.cantidad_preguntas = cantidad_preguntas;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getCantidad_preguntas() {
        return cantidad_preguntas;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setCantidad_preguntas(int cantidad_preguntas) {
        this.cantidad_preguntas = cantidad_preguntas;
    }
}
