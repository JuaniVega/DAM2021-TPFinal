package com.example.tp_final;


import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tp_final.vistas.IniciarSesion;
import com.example.tp_final.vistas.Registrarse;

public class MainActivity extends AppCompatActivity {

    //Pantalla principal
    private Button iniciarSesionBtn;
    private Button registrarseBtn;
    private TextView materiaSeleccionada;
    private String horaNotifiacion;
    private PreferenciaDataSource preferenciaDataSource;
    private Switch switchConfig;
    private SharedPreferences.OnSharedPreferenceChangeListener listener;

    public static final String CANAL_MENSAJES_ID = "1001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pnt_principal);

        iniciarSesionBtn = (Button) findViewById(R.id.btn_iniciar_sesion);
        registrarseBtn = (Button) findViewById(R.id.btn_registrarse);
        preferenciaDataSource= new PreferenciaDataSource(this);


       /* switchConfig= (Switch) findViewById(R.id.sw_notif);

        boolean valorConfig;
        valorConfig=preferenciaDataSource.recuperarAlarmaCreada();

        switchConfig.setChecked(valorConfig);

        switchConfig.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(switchConfig.isChecked()) {
                    horaNotifiacion = "06:17:00";
                    crearNotificacion(horaNotifiacion);
                }else{
                    cancelarNotif();
                }
            }
        });*/

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

        /*Intent i = new Intent(MainActivity.this, NotificacionReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, i, 0);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        long updateInterval = AlarmManager.INTERVAL_DAY;
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + updateInterval, updateInterval, pendingIntent);*/
    }

    /*private void cancelarNotif() {
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(MainActivity.this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);
        am.cancel(pendingIntent);
    }

    private void createNotificationChannel () {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 =
                    new NotificationChannel(CANAL_MENSAJES_ID, "CANAL 1", NotificationManager.IMPORTANCE_DEFAULT);
            channel1.setDescription("description");
            NotificationManager notificationManager =
                    getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel1);
        }
    }

    private void crearNotificacion(String horaNotifiacion) {
        long horaMilis;
        long updateInterval = AlarmManager.INTERVAL_DAY;
        horaMilis=convertirHoraAMilis(horaNotifiacion);

        this.createNotificationChannel();
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(MainActivity.this, NotificacionReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);

        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+1000*10*//*horaMilis + updateInterval*//*, *//*1000*5*//*updateInterval, pendingIntent);

        System.out.println("Aca salimos");

    }

    private long convertirHoraAMilis(String horaNotifiacion) {
        String[] horaNotif = horaNotifiacion.split(":");
        long secondsToMs = Integer.parseInt(horaNotif[2]) * 1000;
        long minutesToMs = Integer.parseInt(horaNotif[1]) * 60000;
        long hoursToMs = Integer.parseInt(horaNotif[0]) * 3600000;
        long total = secondsToMs + minutesToMs + hoursToMs;

        return total;
    }*/

    /*@Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {

        System.out.println("ALGO CAMBIO:"+s);

        if(s.equals("alarma")){
            if(!preferenciaDataSource.recuperarAlarmaCreada()) {
                horaNotifiacion = "03:10:00";
                crearNotificacion(horaNotifiacion);
                System.out.println("SE CREO:");
            }else{
                cancelarNotif();
                System.out.println("SE CANCElo:");
            }
        }
    }*/

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