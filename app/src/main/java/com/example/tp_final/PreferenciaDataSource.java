package com.example.tp_final;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenciaDataSource {

    private final SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public PreferenciaDataSource(Context context){
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor=sharedPreferences.edit();
    }

    //Pantalla de Inicio de Sesion

    public void guardarMail(String mail){
        editor.putString("mail", mail);
        editor.commit();
    }

    public void guardarCont(String cont){
        editor.putString("cont", cont);
        editor.commit();
    }

    public void guardarValCB(boolean val){
        editor.putBoolean("val", val);
        editor.commit();
    }

    public boolean recuperarValCB(){
        boolean defaultValue=false;
        boolean valCB=sharedPreferences.getBoolean("val",defaultValue);
        return valCB;
    }

    public String recuperarMail(){
        String defaultValue="";
        String mail=sharedPreferences.getString("mail",defaultValue);
        return mail;
    }

    public String recuperarCont(){
        String defaultValue="";
        String cont=sharedPreferences.getString("cont",defaultValue);
        return cont;
    }



    //Pantalla y fragmentos de Practicar
    public void guardarMatElegida(String mat){
        editor.putString("mat", mat);
        editor.commit();
    }

    public String recuperarMatElegida(){
        String defaultValue="";
        String matElegida=sharedPreferences.getString("mat",defaultValue);
        return matElegida;
    }



    //Datos del usuario con sesion iniciada
    public void guardarMailUsuarioActual(String mail){
        editor.putString("mailUsuActual", mail);
        editor.commit();
    }

    public String recuperarMailUsuarioActual(){
        String defaultValue="";
        String mail=sharedPreferences.getString("mailUsuActual",defaultValue);
        return mail;
    }

    public void guardarContUsuarioActual(String cont){
        editor.putString("contUsuActual", cont);
        editor.commit();
    }

    public String recuperarContUsuarioActual(){
        String defaultValue="";
        String cont=sharedPreferences.getString("contUsuActual",defaultValue);
        return cont;
    }

    public void guardarDniUsuarioActual(long dni){
        editor.putLong("dniUsuActual", dni);
        editor.commit();
    }

    public long recuperarDniUsuarioActual(){
        long defaultValue=-1;
        long dni=sharedPreferences.getLong("dniUsuActual",defaultValue);
        return dni;
    }

    public void guardarNombreUsuarioActual(String nombre){
        editor.putString("nombreUsuActual", nombre);
        editor.commit();
    }

    public String recuperarNombreUsuarioActual(){
        String defaultValue="";
        String nombre=sharedPreferences.getString("nombreUsuActual",defaultValue);
        return nombre;
    }

    public void guardarApellidoUsuarioActual(String apellido){
        editor.putString("apellidoUsuActual", apellido);
        editor.commit();
    }

    public String recuperarApellidoUsuarioActual(){
        String defaultValue="";
        String apellido=sharedPreferences.getString("apellidoUsuActual",defaultValue);
        return apellido;
    }


}
