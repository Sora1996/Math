package com.example.imgapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    public UserAdapter(Context context, int resource, List<User> objects){
        super(context,resource,objects);
    }

//    提供了一个getView()方法的重载实现
    public View getView(int position, View convertView, ViewGroup parent){
        //获取数据
        final User user=getItem(position);
        // 创建布局
        View oneUserView = LayoutInflater.from(getContext()).inflate(R.layout.user_item, parent, false);

        // 获取ImageView和TextView
        ImageView imageView = (ImageView) oneUserView.findViewById(R.id.user_small_imageView);
        TextView textView = (TextView) oneUserView.findViewById(R.id.user_name_textView);

        // 根据老师数据设置ImageView和TextView的展现
        imageView.setImageResource(user.getImageId());
        textView.setText(user.getName());

        oneUserView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 初始化一个准备跳转到TeacherDetailActivity的Intent
                Intent intent = new Intent(getContext(), UserDetailActivity.class);
                // 往Intent中传入Teacher相关的数据，供TeacherDetailActivity使用
                intent.putExtra("teacher_image", user.getImageId());
                intent.putExtra("teacher_desc", user.getDesc());
                // 准备跳转
                getContext().startActivity(intent);
            }
        });

        return oneUserView;
    }
}
