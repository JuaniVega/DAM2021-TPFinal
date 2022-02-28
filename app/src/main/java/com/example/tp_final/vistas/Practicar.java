package com.example.tp_final.vistas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SurfaceControl;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tp_final.MainActivity;
import com.example.tp_final.MateriaRecycler;
import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.vistas.fragmentos.PracticarExamenesFragment;
import com.example.tp_final.vistas.fragmentos.PracticarPreguntasFragment;
import com.google.android.material.navigation.NavigationView;

public class Practicar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Button btnPracticarPreguntas;
    private Button btnPracticarExamenes;
    private TextView cambiarMateria;
    private TextView nombreUsuario;
    private ImageView imagenUsuario;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Fragment practicarPreguntasFrag, practicarExamenesFrag;
    private String matElegida;
    private String practicaElegida;
    private Bundle bundle;
    private PreferenciaDataSource preferenciaDataSource;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dl_practicar);

        practicarPreguntasFrag = new PracticarPreguntasFragment();
        practicarExamenesFrag = new PracticarExamenesFragment();
        bundle = new Bundle();
        preferenciaDataSource= new PreferenciaDataSource(this);

        btnPracticarPreguntas = (Button) findViewById(R.id.btn_practicar_preg);
        btnPracticarExamenes = (Button) findViewById(R.id.btn_practicar_examen);
        cambiarMateria = (TextView) findViewById(R.id.txt_cambiar_materia);
        imagenUsuario = (ImageView) findViewById(R.id.img_usuario);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_practicar);
        navigationView = (NavigationView) findViewById(R.id.menu_despl_prac);
        nombreUsuario = (TextView) findViewById(R.id.nombre_usuario);
        matElegida= preferenciaDataSource.recuperarMatElegida();

        if(getIntent().getExtras()==null) {
            practicaElegida = "";
        }else{
            practicaElegida=getIntent().getExtras().getString("practica");
        }

        nombreUsuario.setText(preferenciaDataSource.recuperarNombreUsuarioActual()+" "+preferenciaDataSource.recuperarApellidoUsuarioActual());

        configurarToolbar();

        configurarMenuDesplegable();

        configurarFragments();

        btnPracticarPreguntas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragments,practicarPreguntasFrag).commit();
                getSupportFragmentManager().beginTransaction().addToBackStack(null);
                marcarSeleccionadoPreg();
                /*Intent pracPreguntas = new Intent(Practicar.this, PracticarPreguntas.class);
                pracPreguntas.putExtra("materia", materiaElegida.getText());
                startActivity(pracPreguntas);*/
            }
        });

        btnPracticarExamenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getSupportFragmentManager().beginTransaction().replace(R.id.contenedor_fragments,practicarExamenesFrag).commit();
                getSupportFragmentManager().beginTransaction().addToBackStack(null);
                marcarSeleccionadoExam();
               /* Intent pracPreguntas = new Intent(Practicar.this, PracticarPreguntas.class);
                pracPreguntas.putExtra("materia", materiaElegida.getText());
                startActivity(pracPreguntas);*/
            }
        });

        cambiarMateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambiar_materia = new Intent(Practicar.this, MateriaRecycler.class);
                startActivityForResult(cambiar_materia, 1);
            }
        });

        imagenUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mi_cuenta = new Intent(Practicar.this, MiCuenta.class);
                startActivity(mi_cuenta);
            }
        });
    }

    private void marcarSeleccionadoExam() {
        Drawable botonDrPreg = btnPracticarPreguntas.getBackground();
        Drawable botonDrExam = btnPracticarExamenes.getBackground();

        DrawableCompat.setTint(botonDrPreg,getResources().getColor(R.color.teal));
        DrawableCompat.setTint(botonDrExam,getResources().getColor(R.color.grey));
       /* btnPracticarPreguntas.setBackground(getDrawable(R.drawable.input_txt));
        btnPracticarExamenes.setBackground(getDrawable(R.drawable.input_txt));*/
    }

    private void marcarSeleccionadoPreg() {
        Drawable botonDrPreg = btnPracticarPreguntas.getBackground();
        Drawable botonDrExam = btnPracticarExamenes.getBackground();
        DrawableCompat.setTint(botonDrPreg,getResources().getColor(R.color.grey));
        DrawableCompat.setTint(botonDrExam,getResources().getColor(R.color.teal));
      /*  btnPracticarPreguntas.setBackground(getDrawable(R.drawable.input_txt));
        btnPracticarExamenes.setBackground(getDrawable(R.drawable.input_txt));*/
    }

    //TODO: reparar botones que no se pintan bien, borrar clases innecesarias(practicarPreguntas, practicarExamenes, xml de prac_pregu, prac_exa, dl_prac_preg, dl_prac_exam)

    private void configurarFragments() {
        //Cargamos valores para pasar a los fragments
        bundle.putString("materia", matElegida);

        practicarPreguntasFrag.setArguments(bundle);
        practicarExamenesFrag.setArguments(bundle);
        if((practicaElegida.equals("preguntas")) || (practicaElegida.equals("")) ){
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, practicarPreguntasFrag).commit();
            marcarSeleccionadoPreg();
        }else if (practicaElegida.equals("examenes")){
            getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragments, practicarExamenesFrag).commit();
            marcarSeleccionadoExam();
        }
    }

    private void configurarToolbar() {
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
    }

    private void configurarMenuDesplegable() {
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                Practicar.this,
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
            Intent practicar = new Intent(Practicar.this, Practicar.class);
            preferenciaDataSource.guardarMatElegida(data.getDataString());
            startActivity(practicar);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){

            case R.id.mi_cuenta_menu:
                Intent i1 = new Intent(Practicar.this, MiCuenta.class);
                startActivity(i1);
                break;
            case R.id.prac_preg_menu:
                Intent i2 = new Intent(Practicar.this, Practicar.class);
                i2.putExtra("practica", "preguntas");
                startActivity(i2);
                break;
            case R.id.prac_exam_menu:
                Intent i3 = new Intent(Practicar.this, Practicar.class);
                i3.putExtra("practica", "examenes");
                startActivity(i3);
                break;
            case R.id.ayuda_menu:
                Toast.makeText(Practicar.this, "Ayuda solicitada", Toast.LENGTH_LONG).show();
                break;
            case R.id.cerrar_sesion_menu:
                borrarDatosUsuarioActual();
                Toast.makeText(Practicar.this, "Sesión finalizada", Toast.LENGTH_LONG).show();
                Intent cerrar_sesion = new Intent(Practicar.this, MainActivity.class);
                startActivity(cerrar_sesion);
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private void borrarDatosUsuarioActual() {
        preferenciaDataSource.guardarMailUsuarioActual("");
        preferenciaDataSource.guardarContUsuarioActual("");
        preferenciaDataSource.guardarNombreUsuarioActual("");
        preferenciaDataSource.guardarApellidoUsuarioActual("");
        preferenciaDataSource.guardarDniUsuarioActual(0);
    }
}