package com.example.testlocalbroadcastapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;
    private LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register();
        Button button=findViewById(R.id.send_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("localbroadcast");
                localBroadcastManager.sendBroadcast(intent);//本地广播
            }
        });
    }

    private void register(){
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("localbroadcast");
        myReceiver=new MyReceiver();
        localBroadcastManager.registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}