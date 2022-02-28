package com.example.tp_final.vistas.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp_final.R;

public class PracticarPreguntasFragment extends Fragment {

    private String materiaElegida;
    private TextView materiaElegidaTV;

    public PracticarPreguntasFragment() {
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

        View view =inflater.inflate(R.layout.fragment_practicar_preguntas, container, false);

        materiaElegidaTV = (TextView) view.findViewById(R.id.txt_materia_elegida_PP);
        materiaElegidaTV.setText(materiaElegida);

        return view;
    }
}