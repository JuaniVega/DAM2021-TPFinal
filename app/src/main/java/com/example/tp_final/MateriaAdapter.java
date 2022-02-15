package com.example.tp_final;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MateriaAdapter extends RecyclerView.Adapter<MateriaAdapter.ViewHolder> {

    private ArrayList<Materia> mDataSet;
    Activity context;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        TextView materia;
        View v;

        public ViewHolder(View a) {
            super(a);
            materia=a.findViewById(R.id.txt_materia);
            v=a;
        }
    }

    public MateriaAdapter(ArrayList<Materia> adapter, Activity act) {
        mDataSet=adapter;
        context=act;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_materia, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Materia materia1= mDataSet.get(position);
        holder.materia.setText(materia1.getNombre());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String materia =(String) holder.materia.getText();
                Intent i2 = new Intent();
                i2.setData(Uri.parse(materia));
                context.setResult(Activity.RESULT_OK, i2);
                context.finish();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }


}
