package com.example.tp_final;


import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.vistas.IniciarSesion;
import com.example.tp_final.vistas.Registrarse;

public class MainActivity extends AppCompatActivity {

    //Pantalla principal
    private Button iniciarSesionBtn;
    private Button registrarseBtn;

    private TextView materiaSeleccionada;

    public static final String CANAL_MENSAJES_ID = "1001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pnt_principal);

        iniciarSesionBtn = (Button) findViewById(R.id.btn_iniciar_sesion);
        registrarseBtn = (Button) findViewById(R.id.btn_registrarse);

        iniciarSesionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ini_sesion = new Intent(MainActivity.this, IniciarSesion.class);
                startActivity(ini_sesion);
            }
        });

        registrarseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent registrarse = new Intent(MainActivity.this, Registrarse.class);
                startActivity(registrarse);
            }
        });

        /*MyReceiver1 rec = new MyReceiver1();
        IntentFilter intFilt = new IntentFilter();
        intFilt.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);
        intFilt.addAction(Intent.ACTION_SCREEN_OFF);
        intFilt.addAction(Intent.ACTION_BATTERY_LOW);

        this.registerReceiver(rec, intFilt);
        this.crearCanales();*/

        Intent i = new Intent(MainActivity.this, MyReceiver1.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        long updateInterval = AlarmManager.INTERVAL_DAY;
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + updateInterval, updateInterval, pendingIntent);
    }

    /*private void crearCanales() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
           // CharSequence name = getString(R.string.channel_name);
          //  String description = getString(R.string.channel_description);
            //int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel1 =
                    new NotificationChannel(CANAL_MENSAJES_ID, "canal1", NotificationManager.IMPORTANCE_DEFAULT);
                    //channel.setDescription(description);
                    channel1.setDescription("descripcion uno");
            NotificationManager notificationManager =
                getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
        }
    }*/

}