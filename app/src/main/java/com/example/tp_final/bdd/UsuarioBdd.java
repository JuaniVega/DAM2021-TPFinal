package com.example.tp_final.bdd;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tp_final.dao.UsuarioDao;

public abstract class UsuarioBdd extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();

    private static final String NOMBRE_BDD = "usuarios-bdd";

    private static UsuarioBdd INSTANCE;

    public static UsuarioBdd getInstance(final Context context){
        if(INSTANCE == null){
            INSTANCE= Room.databaseBuilder(
                    context.getApplicationContext(),
                    UsuarioBdd.class, NOMBRE_BDD).build();
        }
        return INSTANCE;
    }
}
