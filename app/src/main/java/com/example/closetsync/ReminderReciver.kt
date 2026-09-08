package com.example.closetsync

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

class ReminderReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE)
                    as NotificationManager

        // Create notification channel
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                "closet_sync_reminder",
                "ClosetSync Reminders",
                NotificationManager.IMPORTANCE_HIGH
            )

            notificationManager.createNotificationChannel(channel)
        }

        val clothingName =
            intent.getStringExtra("clothingName")
                ?: "your clothing"

        val notification =
            NotificationCompat.Builder(
                context,
                "closet_sync_reminder"
            )
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("ClosetSync Reminder 🔔")
                .setContentText(
                    "Don't forget to maintain $clothingName 👕"
                )
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setAutoCancel(true)
                .build()

        notificationManager.notify(
            System.currentTimeMillis().toInt(),
            notification
        )
    }
}