package com.example.tp_final.vistas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tp_final.MainActivity;
import com.example.tp_final.R;
import com.google.android.material.navigation.NavigationView;

public class MiCuenta extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView flechaVolverAtras;
    private TextView volverAtras;
    private Button btnCerrarSesion;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dl_mi_cuenta);

        //flechaVolverAtras = (TextView) findViewById(R.id.flecha);
       // volverAtras = (TextView) findViewById(R.id.volver_atras_txt);
        btnCerrarSesion = (Button) findViewById(R.id.btn_cerrar_sesion);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_mi_cuenta);
        navigationView = (NavigationView) findViewById(R.id.menu_despl_mi_cuenta);

        configurarToolbar();

        configurarMenuDesplegable();

        /*flechaVolverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver_atras = new Intent(MiCuenta.this, PracticarPreguntas.class);
                startActivity(volver_atras);
                //TODO: ver como volver a las distintas pantallas (de practicar preg o examenes)
            }
        });*/

        /*volverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver_atras = new Intent(MiCuenta.this, PracticarPreguntas.class);
                startActivity(volver_atras);
                //TODO: ver como volver a las distintas pantallas (de practicar preg o examenes)
            }
        });*/

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cerrar_sesion = new Intent(MiCuenta.this, MainActivity.class);
                startActivity(cerrar_sesion);
            }
        });

        //TODO: ver los inputs de mail y contraseña PARA AGREGAR LAPIZ (asi se entiende q es para editar)
    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.arrow);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("");
    }

    private void configurarMenuDesplegable() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                MiCuenta.this,
                drawerLayout,
                toolbar,
                R.string.abrir_menu_desplegable,
                R.string.cerrar_menu_desplegable
        );

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {return false;}

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
