package com.example.imgapp;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int imageId;
    private String desc;

    public User(String name,int imageId,String desc){
        this.name=name;
        this.imageId=imageId;
        this.desc=desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public static List<User> getAllUsers(){
        List<User> users=new ArrayList<User>();
        //没关联数据库，手动加
        users.add(new User("admin",R.drawable.ic_launcher_foreground,"admin管理员详细信息"));
        users.add(new User("user1",R.drawable.ic_launcher_foreground,"user用户详细信息1"));
        users.add(new User("user2",R.drawable.ic_launcher_foreground,"user用户详细信息2"));
     return users;
    }
}
