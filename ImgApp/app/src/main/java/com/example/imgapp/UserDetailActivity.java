package com.example.imgapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_detail);



        // 从Intent获取数据
        int imageId = getIntent().getIntExtra("teacher_name", 0);
        String desc = getIntent().getStringExtra("teacher_desc");

        // 获取特定的视图
        ImageView imageView = (ImageView) findViewById(R.id.user_large_imageView);
        TextView textView = (TextView) findViewById(R.id.user_desc_textView);

        // 根据数据设置视图展现
        imageView.setImageResource(imageId);
        textView.setText(desc);

    }
}