package com.example.tp_final.vistas.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp_final.R;

public class PracticarExamenesFragment extends Fragment {

    private String materiaElegida;
    private TextView materiaElegidaTV;

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

        return view;
    }
}