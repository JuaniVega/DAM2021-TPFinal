package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;

public class PracticarExamenes extends AppCompatActivity {

    private Button btnPracticarPreguntas;
    private TextView cambiarMateria;
    private ImageView imagenUsuario;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practicar_examenes);

        btnPracticarPreguntas = (Button) findViewById(R.id.btn_practicar_preg);
        cambiarMateria = (TextView) findViewById(R.id.txt_cambiar_materia);
        imagenUsuario = (ImageView) findViewById(R.id.img_usuario);

        btnPracticarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pracExamenes = new Intent(PracticarExamenes.this, PracticarPreguntas.class);
                startActivity(pracExamenes);
            }
        });

        cambiarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambiar_materia = new Intent(PracticarExamenes.this, MateriaRecycler.class);
                startActivityForResult(cambiar_materia, 1);
            }
        });

        imagenUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mi_cuenta = new Intent(PracticarExamenes.this, MiCuenta.class);
                startActivity(mi_cuenta);
            }
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            Intent practicar_preg = new Intent(PracticarExamenes.this, PracticarPreguntas.class);
            startActivity(practicar_preg);
            //TODO: deberia cambiar esta linea por un intent que redirija a la pantalla correspondiente
        }
    }
}
