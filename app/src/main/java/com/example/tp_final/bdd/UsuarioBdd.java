package com.example.tp_final.bdd;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.tp_final.Usuario;
import com.example.tp_final.dao.UsuarioDao;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Usuario.class}, version = 1)
public abstract class UsuarioBdd extends RoomDatabase {

    public abstract UsuarioDao usuarioDao();

    private static final String NOMBRE_BDD = "usuarios-bdd";

    private static UsuarioBdd INSTANCE;

    public static final ExecutorService dbExecutor = Executors.newFixedThreadPool(4);

    public static UsuarioBdd getInstance(final Context context){
        if(INSTANCE == null){
            synchronized (UsuarioBdd.class){
                    if(INSTANCE==null){
                        INSTANCE= Room.databaseBuilder(
                                context.getApplicationContext(),
                                UsuarioBdd.class, NOMBRE_BDD).allowMainThreadQueries().build();
                    }
            }

        }
        return INSTANCE;
    }
}
