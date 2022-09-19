package com.example.service;

import android.app.Application;

import android.app.NotificationChannel;
import android.app.NotificationManager;

public class MyApplication extends Application {

    public static final String CHANNEL_ID = "Service Example";
    public static final String NAME = "My Service";

    @Override
    public void onCreate() {
        super.onCreate();
        createChanelNotification();
    }

    private void createChanelNotification() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, NAME, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            if (channel != null) {
                manager.createNotificationChannel(channel);
            }
        }
    }


}
