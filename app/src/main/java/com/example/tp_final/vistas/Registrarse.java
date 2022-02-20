package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.R;
import com.example.tp_final.Usuario;
import com.example.tp_final.repositorio.UsuarioRepo;

import java.util.List;
import java.util.regex.Pattern;

public class Registrarse extends AppCompatActivity {

    private Button siguienteBtn;
    private EditText mailtxt;
    private EditText contraseñatxt;
    private CheckBox termYCondiciones;
    private TextView ingresar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_p1);

        siguienteBtn = (Button) findViewById(R.id.btn_sgte);
        mailtxt = (EditText) findViewById(R.id.edtxt_usuario);
        contraseñatxt = (EditText) findViewById(R.id.edtxt_cont);
        termYCondiciones = (CheckBox) findViewById(R.id.cb_term_cond);
        ingresar = (TextView) findViewById(R.id.txt_ingresa_aca);

        UsuarioRepo usuarioRepo = new UsuarioRepo(this.getApplicationContext());

        siguienteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent paso2 = new Intent(Registrarse.this, Registrarse2.class);

                if(mailtxt.getText().toString().trim().length() > 0) {
                    String correo = mailtxt.getText().toString();
                    if(validarEstructuraEmail(correo)){
                        if(validarEmailNoExistente(correo)) {
                            if (contraseñatxt.getText().toString().trim().length() > 0) {
                                String contra = contraseñatxt.getText().toString();
                                if (validarContraseña(contra)) {
                                    if (termYCondiciones.isChecked()) {

                                        paso2.putExtra("usuario", mailtxt.getText().toString());
                                        paso2.putExtra("contraseña", contraseñatxt.getText().toString());

                                        startActivity(paso2);

                                    } else {
                                        Toast.makeText(Registrarse.this, "Debes aceptar los términos y condiciones", Toast.LENGTH_LONG).show();
                                        return;
                                    }
                                } else {
                                    Toast.makeText(Registrarse.this, "Ingrese una contraseña que contenga entre 8 y 20 caracteres", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } else {
                                Toast.makeText(Registrarse.this, "El campo contraseña no puede ser vacío", Toast.LENGTH_LONG).show();
                                return;
                            }
                        }else{
                            Toast.makeText(Registrarse.this, "El mail ya se encuentra registrado", Toast.LENGTH_LONG).show();
                            return;
                        }
                    } else {
                        Toast.makeText(Registrarse.this, "Ingrese un correo electrónico válido", Toast.LENGTH_LONG).show();
                        return;
                    }
                } else {
                    Toast.makeText(Registrarse.this, "El campo usuario no puede ser vacío", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            //valida que el email sea de la forma asd@asd.com
            private boolean validarEstructuraEmail(String email) {
                Pattern pattern = Patterns.EMAIL_ADDRESS;
                return pattern.matcher(email).matches();
            }

            //valida que el email no se encuentre registrado
            private boolean validarEmailNoExistente(String email) {
                List<Usuario> lista_usu=usuarioRepo.validarMailExistente(email);
                if(lista_usu.size()>0) {
                    return false;
                }else {
                    return true;
                }
            }

            //valida que la contraseña contenga entre 8 y 20 caracteres
            private boolean validarContraseña(String contra) {
                if(contra.length() > 7 && contra.length() < 21) {
                    return true;
                } else return false;

            }
        });

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ingresar = new Intent(Registrarse.this, IniciarSesion.class);
                startActivity(ingresar);
            }
        });
    }
}
