package com.example.testorderbroadcastapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        register();
        Button button=findViewById(R.id.send_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent("broadtest");
                sendOrderedBroadcast(intent,null);
            }
        });
    }

    private void register(){
        IntentFilter intentFilter=new IntentFilter();
        intentFilter.addAction("broadtest");
        myReceiver=new MyReceiver();
        registerReceiver(myReceiver,intentFilter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(myReceiver);
    }
}