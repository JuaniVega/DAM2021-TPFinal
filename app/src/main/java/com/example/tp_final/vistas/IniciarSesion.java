package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MainActivity;
import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;

import java.util.regex.Pattern;

public class IniciarSesion extends AppCompatActivity {

    private Button iniciarSesionBtn;
    private EditText usuario;
    private EditText contraseña;
    private TextView registrarse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion);

        iniciarSesionBtn = (Button) findViewById(R.id.btn_iniciar_sesion);
        usuario = (EditText) findViewById(R.id.edtxt_usuario);
        contraseña = (EditText) findViewById(R.id.edtxt_cont);
        registrarse = (TextView) findViewById(R.id.txt_registrate_aca);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini_sesion= new Intent(IniciarSesion.this, MateriaRecycler.class);

                if(usuario.getText().toString().trim().length() > 0) {
                    String correo = usuario.getText().toString();
                    if(!validarEmail(correo)){
                        Toast.makeText(IniciarSesion.this, "Ingrese un correo electrónico valido", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        if(contraseña.getText().toString().trim().length() > 0) {
                            startActivityForResult(ini_sesion, 1);
                        } else {
                            Toast.makeText(IniciarSesion.this, "El campo contraseña no puede ser vacío", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }
                } else {
                    Toast.makeText(IniciarSesion.this, "El campo usuario no puede ser vacío", Toast.LENGTH_LONG).show();
                    return;
                }
            }

            //valida que el email sea de la forma asd@asd.com
            private boolean validarEmail(String email) {
                Pattern pattern = Patterns.EMAIL_ADDRESS;
                return pattern.matcher(email).matches();
            }
        });

        registrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(IniciarSesion.this, Registrarse.class);
                startActivity(registrarse);
            }
        });

    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            Intent practicar_preg = new Intent(IniciarSesion.this, PracticarPreguntas.class);
            startActivity(practicar_preg);
            //TODO: deberia cambiar esta linea por un intent que redirija a la pantalla correspondiente
        }
    }
}
