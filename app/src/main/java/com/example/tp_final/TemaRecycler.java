package com.example.tp_final;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class TemaRecycler extends AppCompatActivity {

    protected RecyclerView mRecyclerView;
    protected TemaAdapter mAdapter;
    protected LinearLayoutManager mLayoutManager;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practicar_preguntas);

        mRecyclerView=findViewById(R.id.rv_preguntas);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager=new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter= new TemaAdapter(Tema.temas(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

}
