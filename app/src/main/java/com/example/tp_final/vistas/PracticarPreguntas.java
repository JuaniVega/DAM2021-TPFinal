package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.MainActivity;
import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;

public class PracticarPreguntas extends AppCompatActivity {

    private Button btnPracticarExamenes;
    private TextView cambiarMateria;
    private ImageView imagenUsuario;
    private TextView materiaElegida;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practicar_preguntas);

        btnPracticarExamenes = (Button) findViewById(R.id.btn_practicar_examen);
        cambiarMateria = (TextView) findViewById(R.id.txt_cambiar_materia);
        imagenUsuario = (ImageView) findViewById(R.id.img_usuario);
        materiaElegida = (TextView) findViewById(R.id.txt_materia_elegida_PP);

        materiaElegida.setText(getIntent().getExtras().getString("materia"));

        btnPracticarExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent prac_examenes = new Intent(PracticarPreguntas.this, PracticarExamenes.class);
                prac_examenes.putExtra("materia", materiaElegida.getText());
                startActivity(prac_examenes);
            }
        });

        cambiarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambiar_materia = new Intent(PracticarPreguntas.this, MateriaRecycler.class);
                startActivityForResult(cambiar_materia, 1);
            }
        });

        imagenUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mi_cuenta = new Intent(PracticarPreguntas.this, MiCuenta.class);
                startActivity(mi_cuenta);
            }
        });
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data){
        if((requestCode==1) && (resultCode==RESULT_OK)){
            Intent practicar_preg = new Intent(PracticarPreguntas.this, PracticarPreguntas.class);
            practicar_preg.putExtra("materia", data.getDataString());
            startActivity(practicar_preg);
        }
    }
}
