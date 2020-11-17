package com.example.testserviceapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main,menu);
//        return true;
//    }

    public void buttonOnClickListener(View view){
        switch (view.getId()){
            case R.id.start_service1:
                Intent intentstart=new Intent(this,ServiceShow.class);
                startService(intentstart);
                break;
            case R.id.stop_service1:
                Intent intentstop=new Intent(this,ServiceShow.class);
                stopService(intentstop);
                break;
        }
    }
}