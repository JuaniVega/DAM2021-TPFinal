package com.example.tp_final.vistas;

import static com.example.tp_final.MainActivity.CANAL_MENSAJES_ID;

import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.tp_final.MainActivity;
import com.example.tp_final.NotificacionReceiver;
import com.example.tp_final.PreferenciaDataSource;
import com.example.tp_final.R;
import com.google.android.material.navigation.NavigationView;

public class Configuracion extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private Switch config;
    private PreferenciaDataSource preferenciaDataSource;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private String horaNotifiacion;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dl_configuracion);

        config = (Switch) findViewById(R.id.sw_notif);
        preferenciaDataSource= new PreferenciaDataSource(this);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.dl_config);
        navigationView = (NavigationView) findViewById(R.id.menu_despl_config);

        boolean valorConfig;
        valorConfig=preferenciaDataSource.recuperarAlarmaCreada();

        config.setChecked(valorConfig);

        config.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(config.isChecked()) {
                    horaNotifiacion = "10:00:00";
                    crearNotificacion(horaNotifiacion);
                    Toast.makeText(Configuracion.this, "Notificaciones activadas", Toast.LENGTH_LONG).show();
                }else{
                    cancelarNotif();
                    Toast.makeText(Configuracion.this, "Notificaciones desactivadas", Toast.LENGTH_LONG).show();
                }

                preferenciaDataSource.guardarAlarmaCreada(config.isChecked());
            }
        });

        configurarToolbar();

        configurarMenuDesplegable();
    }

    private void cancelarNotif() {
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
        Intent i = new Intent(Configuracion.this, MainActivity.class);
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
        Intent i = new Intent(Configuracion.this, NotificacionReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(), 0, i, 0);

        am.setInexactRepeating(AlarmManager.RTC_WAKEUP, /*System.currentTimeMillis()*/horaMilis + updateInterval, /*1000*2*/updateInterval, pendingIntent);
    }

    private long convertirHoraAMilis(String horaNotifiacion) {
        String[] horaNotif = horaNotifiacion.split(":");
        long secondsToMs = Integer.parseInt(horaNotif[2]) * 1000;
        long minutesToMs = Integer.parseInt(horaNotif[1]) * 60000;
        long hoursToMs = Integer.parseInt(horaNotif[0]) * 3600000;
        long total = secondsToMs + minutesToMs + hoursToMs;

        return total;
    }

    private void borrarDatosUsuarioActual() {
        preferenciaDataSource.guardarMailUsuarioActual("");
        preferenciaDataSource.guardarContUsuarioActual("");
        preferenciaDataSource.guardarNombreUsuarioActual("");
        preferenciaDataSource.guardarApellidoUsuarioActual("");
        preferenciaDataSource.guardarDniUsuarioActual(0);
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
                Configuracion.this,
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mi_cuenta_menu:
                Intent i1 = new Intent(Configuracion.this, MiCuenta.class);
                startActivity(i1);
                break;
            case R.id.prac_preg_menu:
                Intent i2 = new Intent(Configuracion.this, Practicar.class);
                i2.putExtra("practica", "preguntas");
                startActivity(i2);
                break;
            case R.id.prac_exam_menu:
                Intent i3 = new Intent(Configuracion.this, Practicar.class);
                i3.putExtra("practica", "examenes");
                startActivity(i3);
                break;
            case R.id.config_menu:
                Intent i4 = new Intent(Configuracion.this, Configuracion.class);
                startActivity(i4);
                break;
            case R.id.ayuda_menu:
                Toast.makeText(Configuracion.this, "Ayuda solicitada", Toast.LENGTH_LONG).show();
                break;
            case R.id.cerrar_sesion_menu:
                borrarDatosUsuarioActual();
                Toast.makeText(Configuracion.this, "Sesión finalizada", Toast.LENGTH_LONG).show();
                Intent cerrar_sesion = new Intent(Configuracion.this, MainActivity.class);
                startActivity(cerrar_sesion);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
