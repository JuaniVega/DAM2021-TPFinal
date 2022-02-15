package com.example.tp_final;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.vistas.IniciarSesion;
import com.example.tp_final.vistas.Registrarse;

public class MainActivity extends AppCompatActivity {

    //Pantalla principal
    private Button iniciarSesionBtn;
    private Button registrarseBtn;

    private TextView materiaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pnt_principal);

        iniciarSesionBtn = (Button) findViewById(R.id.btn_iniciar_sesion);
        registrarseBtn = (Button) findViewById(R.id.btn_registrarse);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini_sesion = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(ini_sesion);
            }
        });

        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(MainActivity.this, Registrarse.class);
                startActivity(registrarse);
            }
        });


        materiaSeleccionada = (TextView) findViewById(R.id.txt_prueba);

       /* Intent i1= new Intent(MainActivity.this, MateriaRecycler.class);
        startActivityForResult(i1, 1);

        Intent i1= new Intent(MainActivity.this, TemaRecycler.class);
        startActivityForResult(i1, 1); */
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            materiaSeleccionada.setText(data.getDataString());  //TODO: deberia cambiar esta linea por un intent que redirija a la pantalla correspondiente
        }
    }
}