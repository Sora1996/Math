package com.example.testorderbroadcastapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context,"this is a message when they stop here",Toast.LENGTH_LONG).show();
        abortBroadcast();//中断广播
    }
}
