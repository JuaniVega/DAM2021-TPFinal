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

import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;

public class Registrarse2 extends AppCompatActivity {

    private EditText nombre;
    private EditText apellido;
    private EditText dni;
    private EditText universidad;
    private Spinner pais;
    private Button btnRegistrarse;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registrarse_p2);

        nombre = (EditText) findViewById(R.id.edtxt_nombre);
        apellido = (EditText) findViewById(R.id.edtxt_apellido);
        dni = (EditText) findViewById(R.id.edtxt_dni);
        universidad = (EditText) findViewById(R.id.edtxt_universidad);
        pais = (Spinner) findViewById(R.id.sp_paises);
        btnRegistrarse = (Button) findViewById(R.id.btn_sgte);

        btnRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(Registrarse2.this, MateriaRecycler.class);

                if(nombre.getText().toString().trim().length() > 0) {
                    if(apellido.getText().toString().trim().length() > 0) {
                        if(dni.getText().toString().trim().length() > 0) {
                            if(universidad.getText().toString().trim().length() > 0) {
                                if(pais.getSelectedItemPosition() != 0) {
                                    startActivityForResult(registrarse, 1);
                                } else {
                                    Toast.makeText(Registrarse2.this, "Debes seleccionar un país", Toast.LENGTH_LONG).show();
                                    return;
                                }
                            } else {
                                Toast.makeText(Registrarse2.this, "Debes ingresar tu universidad", Toast.LENGTH_LONG).show();
                                return;
                            }
                        } else {
                            Toast.makeText(Registrarse2.this, "Debes ingresar tu dni", Toast.LENGTH_LONG).show();
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
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            Intent practicar_preg = new Intent(Registrarse2.this, PracticarPreguntas.class);
            startActivity(practicar_preg);
            //TODO: deberia cambiar esta linea por un intent que redirija a la pantalla correspondiente
        }
    }
}
