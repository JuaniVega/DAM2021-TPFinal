package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MainActivity;
import com.example.tp_final.R;

public class MiCuenta extends AppCompatActivity {

    private TextView volverAtras;
    private Button btnCerrarSesion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mi_cuenta);

        volverAtras = (TextView) findViewById(R.id.volver_atras_txt);
        btnCerrarSesion = (Button) findViewById(R.id.btn_cerrar_sesion);

        volverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver_atras = new Intent(MiCuenta.this, PracticarPreguntas.class);
                startActivity(volver_atras);
                //TODO: ver como volver a las distintas pantallas (de practicar preg o examenes)
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cerrar_sesion = new Intent(MiCuenta.this, MainActivity.class);
                startActivity(cerrar_sesion);
            }
        });

        //TODO: ver los inputs de mail y contraseña PARA AGREGAR LAPIZ (asi se entiende q es para editar)
    }
}
