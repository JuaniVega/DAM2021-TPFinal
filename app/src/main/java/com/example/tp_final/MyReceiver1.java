package com.example.tp_final;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        /*switch (intent.getAction()) {
            case Intent.ACTION_BATTERY_LOW:

                Intent i1 = new Intent(context, MainActivity.class);
                PendingIntent pi = PendingIntent.getActivity(context, 0, i1, 1); //para que cuando se haga click en la notificacion entre en la pagina principal

                NotificationCompat.Builder nBuilder = new NotificationCompat.Builder(context, MainActivity.CANAL_MENSAJES_ID)
                        .setSmallIcon(R.drawable.logo_original)
                        .setContentTitle("Es hora de estudiar!")
                        .setContentText("Aprendien2 te está esperando")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .setContentIntent(pi)
                        .setAutoCancel(true);

                NotificationManagerCompat notManager = NotificationManagerCompat.from(context);
                notManager.notify(99, nBuilder.build());

                break;
        }*/

        showNotification(context);
    }

    public void showNotification(Context context){
        Intent i = new Intent(context, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(context, 0, i, 0); //para que cuando se haga click en la notificacion entre en la pagina principal
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context, MainActivity.CANAL_MENSAJES_ID)
                .setSmallIcon(R.drawable.logo_original)
                .setContentTitle("Es hora de estudiar!")
                .setContentText("Aprendien2 te está esperando");
        mBuilder.setContentIntent(pi);
        mBuilder.setDefaults(Notification.DEFAULT_SOUND);
        mBuilder.setAutoCancel(true);
        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }
}