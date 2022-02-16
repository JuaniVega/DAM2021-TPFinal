package com.example.tp_final;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Usuario")
public class Usuario {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name="dni")
    private int dni;

    @NonNull
    @ColumnInfo(name="nombre")
    private String nombre;

    @NonNull
    @ColumnInfo(name="apellido")
    private String apellido;

    @NonNull
    @ColumnInfo(name="mail")
    private String mail;

    @NonNull
    @ColumnInfo(name="contraseña")
    private String cont;

    @ColumnInfo(name="universidad")
    private String universidad;

    @ColumnInfo(name="pais")
    private String pais;

    public Usuario(String mail, String cont, String nombre, String apellido, String universidad, String pais, int dni){
        this.mail=mail;
        this.cont=cont;
        this.nombre=nombre;
        this.apellido=apellido;
        this.universidad=universidad;
        this.pais=pais;
        this.dni=dni;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
