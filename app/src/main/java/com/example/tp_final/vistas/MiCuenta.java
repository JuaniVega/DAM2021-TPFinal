package com.example.tp_final.vistas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.tp_final.MainActivity;
import com.example.tp_final.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MiCuenta extends AppCompatActivity {

    private TextView flechaVolverAtras;
    private TextView volverAtras;
    private Button btnCerrarSesion;
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
        setContentView(R.layout.mi_cuenta);

        flechaVolverAtras = (TextView) findViewById(R.id.flecha);
        volverAtras = (TextView) findViewById(R.id.volver_atras_txt);
        btnCerrarSesion = (Button) findViewById(R.id.btn_cerrar_sesion);
        imgUsuario = (ImageView) findViewById(R.id.img_usuario);
        //sacarFoto = (Button) findViewById(R.id.btn_captura);
        sacarFoto = (TextView) findViewById(R.id.txt_tema1);

        flechaVolverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver_atras = new Intent(MiCuenta.this, PracticarPreguntas.class);
                startActivity(volver_atras);
                //TODO: ver como volver a las distintas pantallas (de practicar preg o examenes)
            }
        });

        volverAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver_atras = new Intent(MiCuenta.this, PracticarPreguntas.class);
                startActivity(volver_atras);
                //TODO: ver como volver a las distintas pantallas (de practicar preg o examenes)
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cerrar_sesion = new Intent(MiCuenta.this, MainActivity.class);
                startActivity(cerrar_sesion);
            }
        });

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

    private File createImageFile() throws IOException {
        // Create an image file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imageFileName,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
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
    }
}
