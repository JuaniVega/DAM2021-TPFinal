package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.R;

public class VistaPuntajes extends AppCompatActivity {

    //Botones de la vista "vista_puntaje"
    private Button volverAExamenes;
    private TextView examenElegido;
    private TextView puntaje;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vista_puntaje);

        //De la vista "vista_puntaje"
        volverAExamenes = (Button) findViewById(R.id.btn_volver_a_examenes);
        examenElegido= (TextView) findViewById(R.id.txt_tema_pant_puntaje);
        puntaje = (TextView) findViewById(R.id.txt_puntos);

        puntaje.setText(String.valueOf(getIntent().getExtras().getInt("punt")));
        examenElegido.setText(getIntent().getExtras().getString("mat"));

        volverAExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(VistaPuntajes.this, Practicar.class);
                i3.putExtra("practica", "examenes");
                startActivity(i3);
            }
        });


    }

}

