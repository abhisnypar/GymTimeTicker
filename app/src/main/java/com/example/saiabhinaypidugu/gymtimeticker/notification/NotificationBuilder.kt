package com.example.saiabhinaypidugu.gymtimeticker.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import com.example.saiabhinaypidugu.gymtimeticker.MainActivity
import com.example.saiabhinaypidugu.gymtimeticker.R

class NotificationBuilder {

    companion object {
        fun build(context: Context) {
            val channelId = "CHANNEL_ID"
            val notificationId = 0
            val intent = Intent(context, MainActivity::class.java)
            val builder = NotificationCompat.Builder(context, channelId)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentTitle(context.getString(R.string.notification_title))
                    .setContentText(context.getString(R.string.notification_body))
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                    .setContentIntent(PendingIntent.getActivity(context, 0, intent, 0))
                    .setAutoCancel(true)


            val channel = NotificationChannel(channelId, "GYM", NotificationManager.IMPORTANCE_DEFAULT)

            val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)

            with(NotificationManagerCompat.from(context)) {
                notify(notificationId, builder.build())
            }
        }
    }
}