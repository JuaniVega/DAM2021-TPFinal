package com.example.tp_final;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp_final.vistas.VistaPreguntasExamenes;
import com.example.tp_final.vistas.VistaPreguntasUnicas;

import java.util.ArrayList;

public class TemaAdapter extends RecyclerView.Adapter<TemaAdapter.ViewHolder> {
    private ArrayList<String> mDataSet;
    Activity context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tema;
        TextView num_preg;
        TextView txt_preguntas;
        /*ContadorPreguntas contadorPreguntas;
        Preguntas preguntas;*/
        View v;

        public ViewHolder(View a) {
            super(a);
            tema=a.findViewById(R.id.txt_tema);
            num_preg=a.findViewById(R.id.txt_num_preguntas);
            txt_preguntas=a.findViewById(R.id.txt_preguntas);
            /*contadorPreguntas = new ContadorPreguntas(a.getContext());
            preguntas = contadorPreguntas.getmPreguntas();*/
            v=a;
        }
    }

    public TemaAdapter(ArrayList<String> adapter, Activity act) {
        mDataSet=adapter;
        context=act;
    }

    public TemaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_tema, parent, false);
        return new TemaAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String tema1= mDataSet.get(position);
        holder.tema.setText(tema1.toString());
        holder.num_preg.setText("");
        holder.txt_preguntas.setText("");

        //int posicion_selec= position;

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tema =(String) holder.tema.getText();
                int posicion_selec=holder.getLayoutPosition();

               //System.out.println("posicion seleccionada: "+posicion_selec);

                Intent i2 = new Intent(context, VistaPreguntasUnicas.class);
                i2.putExtra("tit_tema", tema);
                i2.putExtra("num_preg", posicion_selec);
                context.startActivity(i2);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


}

