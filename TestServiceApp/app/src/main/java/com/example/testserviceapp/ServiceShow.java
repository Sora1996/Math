package com.example.testserviceapp;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class ServiceShow extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("Service Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        System.out.println("Service start command");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        System.out.println("Service Stop");
        super.onDestroy();
    }
}
