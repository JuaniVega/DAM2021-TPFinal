package com.example.tp_final;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TemaAdapter extends RecyclerView.Adapter<TemaAdapter.ViewHolder> {
    private ArrayList<Tema> mDataSet;
    Activity context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tema;
        TextView cant_materias;
        View v;

        public ViewHolder(View a) {
            super(a);
            tema=a.findViewById(R.id.txt_tema);
            cant_materias=a.findViewById(R.id.txt_num_preguntas);
            v=a;
        }
    }

    public TemaAdapter(ArrayList<Tema> adapter, Activity act) {
        mDataSet=adapter;
        context=act;
    }

    public TemaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_tema, parent, false);
        return new TemaAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Tema tema1= mDataSet.get(position);
        holder.tema.setText(tema1.getNombre());
        holder.cant_materias.setText(tema1.getCantPreguntas());

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


}

