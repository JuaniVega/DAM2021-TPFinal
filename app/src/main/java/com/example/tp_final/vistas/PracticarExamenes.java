package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.R;
import com.google.android.material.navigation.NavigationView;

public class PracticarExamenes extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnPracticarPreguntas;
    private TextView cambiarMateria;
    private ImageView imagenUsuario;
    private TextView materiaElegida;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dl_practicar_examenes);

        btnPracticarPreguntas = (Button) findViewById(R.id.btn_practicar_preg);
        cambiarMateria = (TextView) findViewById(R.id.txt_cambiar_materia);
        imagenUsuario = (ImageView) findViewById(R.id.img_usuario);
        materiaElegida = (TextView) findViewById(R.id.txt_materia_elegida_PE);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_practicar_examenes);
        navigationView = (NavigationView) findViewById(R.id.menu_despl_prac_exam);

        materiaElegida.setText(getIntent().getExtras().getString("materia"));

        configurarToolbar();

        configurarMenuDesplegable();

        btnPracticarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pracPreguntas = new Intent(PracticarExamenes.this, PracticarPreguntas.class);
                pracPreguntas.putExtra("materia", materiaElegida.getText());
                startActivity(pracPreguntas);
            }
        });

        cambiarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambiar_materia = new Intent(PracticarExamenes.this, MateriaRecycler.class);
                startActivityForResult(cambiar_materia, 1);
            }
        });

        imagenUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mi_cuenta = new Intent(PracticarExamenes.this, MiCuenta.class);
                startActivity(mi_cuenta);
            }
        });
    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void configurarMenuDesplegable() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                PracticarExamenes.this,
                drawerLayout,
                toolbar,
                R.string.abrir_menu_desplegable,
                R.string.cerrar_menu_desplegable
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 1) && (resultCode == RESULT_OK)) {
            Intent practicar_preg = new Intent(PracticarExamenes.this, PracticarExamenes.class);
            startActivity(practicar_preg);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
}
