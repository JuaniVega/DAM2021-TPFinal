package com.example.tp_final;

import static com.example.tp_final.MainActivity.CANAL_MENSAJES_ID;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.example.tp_final.vistas.IniciarSesion;

public class NotificacionReceiver extends BroadcastReceiver {


    private PreferenciaDataSource preferenciaDataSource;

    @Override
    public void onReceive(Context context, Intent intent) {

        preferenciaDataSource= new PreferenciaDataSource(context.getApplicationContext());
        Intent i = new Intent(context, MainActivity.class);
        i.putExtra("valNotif", false);
        //preferenciaDataSource.guardarAlarmaCreada(false);
        PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0); //para que cuando se haga click en la notificacion entre en la pagina principal

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context.getApplicationContext(), CANAL_MENSAJES_ID)
                .setSmallIcon(R.drawable.logo_original)
                .setContentTitle("Es hora de estudiar!")
                .setContentText("Aprendien2 te está esperando")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);
        mBuilder.setContentIntent(pi);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
       // NotificationManagerCompat notificationManager = NotificationManagerCompat.from(context);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
        //notificationManager.notify(0, mBuilder.build());
    }
}