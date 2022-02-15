package com.example.tp_final;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MateriaRecycler extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected MateriaAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.elegir_materia);

        mRecyclerView=findViewById(R.id.rv_materias);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter= new MateriaAdapter(Materia.materias(), this);
        mRecyclerView.setAdapter(mAdapter);
    }


}
