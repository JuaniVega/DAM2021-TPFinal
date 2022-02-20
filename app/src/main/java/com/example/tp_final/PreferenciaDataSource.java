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

    public Boolean recuperarValCB(){
        Boolean defaultValue=false;
        Boolean valCB=sharedPreferences.getBoolean("val",defaultValue);
        return valCB;
    }

    public String recuperarMail(){
        String defaultValue="aaa";
        String mail=sharedPreferences.getString("mail",defaultValue);
        return mail;
    }

    public String recuperarCont(){
        String defaultValue="";
        String cont=sharedPreferences.getString("cont",defaultValue);
        return cont;
    }
}
