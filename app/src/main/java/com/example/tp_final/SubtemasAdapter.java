package com.example.tp_final;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.content.Context;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;
import com.example.tp_final.model.Subtemas;

public class SubtemasAdapter extends ArrayAdapter<Subtemas> {

    SubtemasAdapter(Context cont, List<Subtemas> datos) {
        super(cont, 0, datos);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View fila = inflater.inflate(R.layout.practicar_preguntas, parent, false);
        TextView titulo = fila.findViewById(R.id.rowTitulo);
      /*  TextView cantPreg = fila.findViewById(R.id.cant_preguntas);
        ImageView icono = fila.findViewById(R.id.img_row);
        Button btnFlecha = fila.findViewById(R.id.btn_flecha);*/

        Subtemas unSubtema = this.getItem(position);

        titulo.setText(unSubtema.getTitulo());
        /*cantPreg.setText(unSubtema.getCantidad_preguntas());
        icono.setImageResource(android.R.drawable.btn_plus);*/

        return super.getView(position, convertView, parent);
    }
}
