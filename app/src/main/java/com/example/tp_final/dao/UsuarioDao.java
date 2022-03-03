package com.example.tp_final.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.tp_final.Usuario;

import java.util.List;

@Dao
public interface UsuarioDao {

    @Query("SELECT * FROM usuario WHERE mail= :mail")
    List<Usuario> validarMailExistente(String mail);

    @Query("SELECT * FROM usuario WHERE dni= :dni")
    List<Usuario> validarDniExistente(int dni);

    @Query ("SELECT * FROM usuario WHERE mail= :mail AND contraseña= :contraseña")
    List<Usuario> validarSesion(String mail, String contraseña);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void agregar(Usuario usuario);

    @Query("UPDATE Usuario SET mail = :mail, contraseña = :cont WHERE dni = :dni")
    void actualizarUsuario(String mail, String cont, long dni);

}
