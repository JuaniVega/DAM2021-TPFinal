package com.example.tp_final;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_final.libreriaDePreguntas.ContadorPreguntas;
import com.example.tp_final.vistas.VistaPreguntasExamenes;

import java.util.ArrayList;

public class ExamenAdapter extends RecyclerView.Adapter<ExamenAdapter.ViewHolder>{

    private ArrayList<Examen> mDataSet;
    private Activity context;


    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView examen;
        TextView num_preg;
        TextView txt_preguntas;
        ContadorPreguntas contadorPreguntas;
        int cantPreg;
        View v;

        public ViewHolder(View a) {
            super(a);
            examen=a.findViewById(R.id.txt_tema);
            num_preg=a.findViewById(R.id.txt_num_preguntas);
            txt_preguntas=a.findViewById(R.id.txt_preguntas);
            contadorPreguntas = new ContadorPreguntas(a.getContext());
            cantPreg= contadorPreguntas.getCantPreguntasTotales();

            v=a;
        }
    }

    public ExamenAdapter(ArrayList<Examen> adapter, Activity act) {
        mDataSet=adapter;
        context=act;
    }

    public ExamenAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_tema, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExamenAdapter.ViewHolder holder, int position) {

        Examen examen1= mDataSet.get(position);
        holder.examen.setText(examen1.getNombre());
        holder.num_preg.setText(String.valueOf(holder.cantPreg));

        /*Intent i1 = new Intent(context, ContadorPreguntas.class);
        context.startActivityForResult(i1, 1);*/

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String examen =(String) holder.examen.getText();

                Intent i2 = new Intent(context, VistaPreguntasExamenes.class);
                i2.putExtra("tit_examen", examen);
                context.startActivity(i2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }



}
