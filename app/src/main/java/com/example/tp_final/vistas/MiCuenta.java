package com.example.tp_final.vistas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.example.tp_final.MainActivity;
import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.example.tp_final.repositorio.UsuarioRepo;
import com.google.android.material.navigation.NavigationView;

public class MiCuenta extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private TextView flechaVolverAtras;
    private TextView volverAtras;
    private Button btnCerrarSesion;
    private Button btnGuardar;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private EditText nuevoMailtxt, nuevaConttxt;
    private PreferenciaDataSource preferenciaDataSource;
    private ImageView imgUsuario;
    //private Button sacarFoto;
    private TextView sacarFoto;

    //Datos para configurar cámara
    static final int REQUEST_IMAGE_CAPTURE = 0;
    static final int REQUEST_TAKE_PHOTO = 1;
    String currentPhotoPath;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dl_mi_cuenta);

        preferenciaDataSource= new PreferenciaDataSource(this);

        //flechaVolverAtras = (TextView) findViewById(R.id.flecha);
       // volverAtras = (TextView) findViewById(R.id.volver_atras_txt);
        btnCerrarSesion = (Button) findViewById(R.id.btn_cerrar_sesion);
        imgUsuario = (ImageView) findViewById(R.id.img_usuario);
        //sacarFoto = (Button) findViewById(R.id.btn_captura);
        sacarFoto = (TextView) findViewById(R.id.txt_tema1);
        btnGuardar = (Button) findViewById(R.id.btn_guardar);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        nuevoMailtxt = (EditText) findViewById(R.id.edtxt_nuevo_mail);
        nuevaConttxt = (EditText) findViewById(R.id.edtxt_nueva_cont);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_mi_cuenta);
        navigationView = (NavigationView) findViewById(R.id.menu_despl_mi_cuenta);
        UsuarioRepo usuarioRepo = new UsuarioRepo(this.getApplicationContext());

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
                borrarDatosUsuarioActual();
                Toast.makeText(MiCuenta.this, "Sesión finalizada", Toast.LENGTH_LONG).show();
                Intent cerrar_sesion = new Intent(MiCuenta.this, MainActivity.class);
                startActivity(cerrar_sesion);
            }
        });

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               usuarioRepo.actualizarUsuario(nuevoMailtxt.getText().toString().trim(), nuevaConttxt.getText().toString().trim(), preferenciaDataSource.recuperarDniUsuarioActual());
               limpiarCamposDeTexto();
               Toast.makeText(MiCuenta.this, "Actualización exitosa", Toast.LENGTH_LONG).show();
            }
        });

        //TODO: ver los inputs de mail y contraseña PARA AGREGAR LAPIZ (asi se entiende q es para editar)
        sacarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cambiar_foto = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                if(cambiar_foto.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(cambiar_foto, REQUEST_IMAGE_CAPTURE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap bmp = (Bitmap) extras.get("data");
            imgUsuario.setImageBitmap(bmp);
        }
    }

    /*private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  *//* prefix *//*
                ".jpg",         *//* suffix *//*
                storageDir      *//* directory *//*
        );

        // Save a file: path for use with ACTION_VIEW intents
        currentPhotoPath = image.getAbsolutePath();
        return image;
    }

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            // Create the File where the photo should go
            File photoFile = null;
            try {
                photoFile = createImageFile();
            } catch (IOException ex) {
                // Error occurred while creating the File
            }
            // Continue only if the File was successfully created
            if (photoFile != null) {
                Uri photoURI = FileProvider.getUriForFile(this,
                        "com.example.android.fileprovider",
                        photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI);
                startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
            }
        }
    }*/

    private void borrarDatosUsuarioActual() {
        preferenciaDataSource.guardarMailUsuarioActual("");
        preferenciaDataSource.guardarContUsuarioActual("");
        preferenciaDataSource.guardarNombreUsuarioActual("");
        preferenciaDataSource.guardarApellidoUsuarioActual("");
        preferenciaDataSource.guardarDniUsuarioActual(0);
    }

    private void limpiarCamposDeTexto() {
        nuevoMailtxt.setText("");
        nuevaConttxt.setText("");
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
            case R.id.mi_cuenta_menu:
                Intent i1 = new Intent(MiCuenta.this, MiCuenta.class);
                startActivity(i1);
                break;
            case R.id.prac_preg_menu:
                Intent i2 = new Intent(MiCuenta.this, Practicar.class);
                i2.putExtra("practica", "preguntas");
                startActivity(i2);
                break;
            case R.id.prac_exam_menu:
                Intent i3 = new Intent(MiCuenta.this, Practicar.class);
                i3.putExtra("practica", "examenes");
                startActivity(i3);
                break;
            case R.id.config_menu:
                Intent i4 = new Intent(MiCuenta.this, Configuracion.class);
                startActivity(i4);
                break;
            case R.id.ayuda_menu:
                Toast.makeText(MiCuenta.this, "Ayuda solicitada", Toast.LENGTH_LONG).show();
                break;
            case R.id.cerrar_sesion_menu:
                borrarDatosUsuarioActual();
                Toast.makeText(MiCuenta.this, "Sesión finalizada", Toast.LENGTH_LONG).show();
                Intent cerrar_sesion = new Intent(MiCuenta.this, MainActivity.class);
                startActivity(cerrar_sesion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
