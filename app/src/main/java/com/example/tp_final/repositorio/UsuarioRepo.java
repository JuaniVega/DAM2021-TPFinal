package com.example.tp_final.repositorio;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.tp_final.Usuario;
import com.example.tp_final.bdd.UsuarioBdd;
import com.example.tp_final.dao.UsuarioDao;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepo {
    private final UsuarioDao usuarioDao;

    public UsuarioRepo(Context context){
        UsuarioBdd usuarioBdd= UsuarioBdd.getInstance(context);
        usuarioDao = usuarioBdd.usuarioDao();
    }

    public void insertar(Usuario usuario){
        UsuarioBdd.dbExecutor.execute(
                ()->usuarioDao.agregar(usuario)
        );
    }

    public void actualizarUsuario(String mail, String cont, long dni){
        UsuarioBdd.dbExecutor.execute(
                ()->usuarioDao.actualizarUsuario(mail, cont, dni)
        );
    }

    public List<Usuario> validarSesion(String mail, String cont){
           List<Usuario> listaUsuario= usuarioDao.validarSesion(mail, cont);
            return listaUsuario;
        }


    public List<Usuario> validarMailExistente(String mail){
        List<Usuario> listaUsuario= usuarioDao.validarMailExistente(mail);
        return listaUsuario;
    }


    public List<Usuario> validarDniExistente(int dni){
        List<Usuario> listaUsuario= usuarioDao.validarDniExistente(dni);
        return listaUsuario;
    }
}
