package com.example.tp_final.vistas.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.tp_final.Examen;
import com.example.tp_final.ExamenAdapter;
import com.example.tp_final.R;

import java.util.ArrayList;

public class PracticarExamenesFragment extends Fragment {

    private String materiaElegida;
    private TextView materiaElegidaTV;
    private ArrayList<Examen> examen;
    private RecyclerView recyclerView;

    public PracticarExamenesFragment() {
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

        examen = new ArrayList<>();

        materiaElegidaTV = (TextView) view.findViewById(R.id.txt_materia_elegida_PE);
        materiaElegidaTV.setText(materiaElegida);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_examenes);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        ExamenAdapter mAdapter= new ExamenAdapter(Examen.examenes(), getActivity());

        recyclerView.setAdapter(mAdapter);

        return view;
    }

}