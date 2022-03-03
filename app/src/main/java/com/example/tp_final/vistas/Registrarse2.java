package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MainActivity;
import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;
import com.example.tp_final.Usuario;
import com.example.tp_final.bdd.UsuarioBdd;
import com.example.tp_final.dao.UsuarioDao;
import com.example.tp_final.repositorio.UsuarioRepo;

import java.util.List;

public class Registrarse2 extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private EditText universidad;
    private Spinner pais;
    private Button btnRegistrarse;
    private Usuario usuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_p2);

        nombre = (EditText) findViewById(R.id.edtxt_nombre);
        apellido = (EditText) findViewById(R.id.edtxt_apellido);
        dni = (EditText) findViewById(R.id.edtxt_dni);
        universidad = (EditText) findViewById(R.id.edtxt_universidad);
        pais = (Spinner) findViewById(R.id.sp_paises);
        btnRegistrarse = (Button) findViewById(R.id.btn_registrarse_2);
        usuario = new Usuario();
        UsuarioRepo usuarioRepo = new UsuarioRepo(this.getApplicationContext());

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(Registrarse2.this, MainActivity.class);

                if(nombre.getText().toString().trim().length() > 0) {
                    if(apellido.getText().toString().trim().length() > 0) {
                        if(dni.getText().toString().trim().length() > 6 && dni.getText().toString().length()<9) {
                            if(validarDniNoExistente(dni.getText().toString().trim())) {
                                if (universidad.getText().toString().trim().length() > 0) {
                                    if (pais.getSelectedItemPosition() != 0) {

                                        usuario.setNombre(nombre.getText().toString());
                                        usuario.setApellido(apellido.getText().toString());
                                        usuario.setDni(Integer.parseInt(dni.getText().toString()));
                                        usuario.setUniversidad(universidad.getText().toString());
                                        usuario.setPais(pais.getSelectedItem().toString());
                                        usuario.setMail(getIntent().getExtras().getString("usuario"));
                                        usuario.setCont(getIntent().getExtras().getString("contraseña"));

                                        usuarioRepo.insertar(usuario);
                                        Toast.makeText(Registrarse2.this, "Usuario creado con ÉXITO", Toast.LENGTH_LONG).show();
                                        startActivity(registrarse);

                                    } else {
                                        Toast.makeText(Registrarse2.this, "Debes seleccionar un país", Toast.LENGTH_LONG).show();
                                        return;
                                    }
                                } else {
                                    Toast.makeText(Registrarse2.this, "Debes ingresar tu universidad", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            }else{
                                Toast.makeText(Registrarse2.this, "Ya existe un usuario relacionado con el DNI ingresado", Toast.LENGTH_LONG).show();
                                return;
                            }
                        } else {
                            Toast.makeText(Registrarse2.this, "El DNI debe tener 7 u 8 digitos", Toast.LENGTH_LONG).show();
                            return;
                        }
                    } else {
                        Toast.makeText(Registrarse2.this, "Debes ingresar tu apellido", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    Toast.makeText(Registrarse2.this, "Debes ingresar tu nombre", Toast.LENGTH_LONG).show();
                    return;
                }
            }

                private boolean validarDniNoExistente(String doc) {
                    List<Usuario> lista_usu=usuarioRepo.validarDniExistente(Integer.parseInt(doc));
                    if(lista_usu.size()>0) {
                        return false;
                    }else {
                        return true;
                    }
                }

        });
    }
}
