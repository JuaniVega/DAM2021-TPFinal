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
import androidx.lifecycle.LiveData;

import com.example.tp_final.MainActivity;
import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.Usuario;
import com.example.tp_final.repositorio.UsuarioRepo;

import java.util.List;
import java.util.regex.Pattern;

public class IniciarSesion extends AppCompatActivity {

    private Button iniciarSesionBtn;
    private EditText mailtxt;
    private EditText contraseñatxt;
    private TextView registrarse;
    private CheckBox recordar;
    private PreferenciaDataSource preferenciaDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.iniciar_sesion);

        iniciarSesionBtn = (Button) findViewById(R.id.btn_iniciar_sesion);
        mailtxt = (EditText) findViewById(R.id.edtxt_usuario);
        contraseñatxt = (EditText) findViewById(R.id.edtxt_cont);
        registrarse = (TextView) findViewById(R.id.txt_registrate_aca);
        recordar = (CheckBox) findViewById(R.id.cb_recordar);


        UsuarioRepo usuarioRepo = new UsuarioRepo(this.getApplicationContext());

        preferenciaDataSource= new PreferenciaDataSource(IniciarSesion.this);

        recordarDatos();

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini_sesion= new Intent(IniciarSesion.this, MateriaRecycler.class);

                if(mailtxt.getText().toString().trim().length() > 0) {
                    String correo = mailtxt.getText().toString();
                    if(!validarEmail(correo)){
                        Toast.makeText(IniciarSesion.this, "Ingrese un correo electrónico valido", Toast.LENGTH_LONG).show();
                        return;
                    } else {
                        if(contraseñatxt.getText().toString().trim().length() > 0) {

                            List<Usuario> lista_usu=usuarioRepo.validarSesion(mailtxt.getText().toString().trim(), contraseñatxt.getText().toString().trim());
                            if(lista_usu.size()>0){
                                guardarPreferenciasIncioSesion();
                                guardarUsuarioActual(lista_usu);
                                Toast.makeText(IniciarSesion.this, "Sesion iniciada correctamente", Toast.LENGTH_LONG).show();
                                startActivityForResult(ini_sesion, 1);

                            }else{
                                Toast.makeText(IniciarSesion.this, "Los datos no son correctos", Toast.LENGTH_LONG).show();
                                return;
                            }
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

    private void guardarUsuarioActual(List<Usuario> lista_usu) {
        preferenciaDataSource.guardarMailUsuarioActual(lista_usu.get(0).getMail());
        preferenciaDataSource.guardarContUsuarioActual(lista_usu.get(0).getCont());
        preferenciaDataSource.guardarDniUsuarioActual(lista_usu.get(0).getDni());
        preferenciaDataSource.guardarNombreUsuarioActual(lista_usu.get(0).getNombre());
        preferenciaDataSource.guardarApellidoUsuarioActual(lista_usu.get(0).getApellido());
    }

    private void recordarDatos(){
        recordar.setChecked(preferenciaDataSource.recuperarValCB());
        if(recordar.isChecked()){
            mailtxt.setText(preferenciaDataSource.recuperarMail());
            contraseñatxt.setText(preferenciaDataSource.recuperarCont());
        }
    }

    private void guardarPreferenciasIncioSesion(){
        if(recordar.isChecked()){
            preferenciaDataSource.guardarMail(mailtxt.getText().toString().trim());
            preferenciaDataSource.guardarCont(contraseñatxt.getText().toString().trim());
            preferenciaDataSource.guardarValCB(recordar.isChecked());
        }else {
            preferenciaDataSource.guardarValCB(false);
        }
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Intent practicar = new Intent(IniciarSesion.this, Practicar.class);
            preferenciaDataSource.guardarMatElegida(data.getDataString());
            startActivity(practicar);
        }
    }
}
