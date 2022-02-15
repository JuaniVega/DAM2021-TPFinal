package com.example.tp_final;


import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView materiaSeleccionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegir_materia);

        materiaSeleccionada = (TextView) findViewById(R.id.txt_prueba);

        Intent i1= new Intent(MainActivity.this, MateriaRecycler.class);
        startActivityForResult(i1, 1);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            materiaSeleccionada.setText(data.getDataString());  //TODO: deberia cambiar esta linea por un intent que redirija a la pantalla correspondiente
        }
    }
}