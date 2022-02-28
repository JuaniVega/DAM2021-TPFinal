package com.example.tp_final.vistas.fragmentos;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp_final.R;
import com.example.tp_final.vistas.PracticarExamenes;
import com.example.tp_final.vistas.VistaPreguntas;

public class PracticarExamenesFragment extends Fragment {

    private String materiaElegida;
    private TextView materiaElegidaTV;
    private TextView examenes;

    public PracticarExamenesFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        if(getArguments()!=null){
            materiaElegida = (getArguments().getString("materia",""));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_practicar_examenes, container, false);

        materiaElegidaTV = (TextView) view.findViewById(R.id.txt_materia_elegida_PE);
        materiaElegidaTV.setText(materiaElegida);
        examenes = (TextView) view.findViewById(R.id.txt_examenes);

        examenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent practicar_examen = new Intent(getActivity(), VistaPreguntas.class);
                startActivity(practicar_examen);
            }
        });

        return view;
    }
}