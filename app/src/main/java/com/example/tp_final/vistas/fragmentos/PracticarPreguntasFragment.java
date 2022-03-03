package com.example.tp_final.vistas.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp_final.Examen;
import com.example.tp_final.R;
import com.example.tp_final.Tema;
import com.example.tp_final.TemaAdapter;
import com.example.tp_final.libreriaDePreguntas.ContadorPreguntas;
import com.example.tp_final.libreriaDePreguntas.Preguntas;

import java.util.ArrayList;
import java.util.Arrays;

public class PracticarPreguntasFragment extends Fragment {

    private String materiaElegida;
    private TextView materiaElegidaTV;
    private ArrayList<String> temas;
    private RecyclerView recyclerView;
    private ContadorPreguntas contadorPreguntas;
    private Preguntas preguntas;

    public PracticarPreguntasFragment() {
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

        contadorPreguntas= new ContadorPreguntas(getContext());

        preguntas=contadorPreguntas.getmPreguntas();

        temas = new ArrayList<String>(Arrays.asList(preguntas.getmTemas()));

        materiaElegidaTV = (TextView) view.findViewById(R.id.txt_materia_elegida_PP);
        materiaElegidaTV.setText(materiaElegida);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_preguntas);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        TemaAdapter mAdapter= new TemaAdapter(temas,getActivity());

        recyclerView.setAdapter(mAdapter);

        return view;
    }
}