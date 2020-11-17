package com.example.testsqlapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    private static Integer Version=1;

    public MySQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public MySQLiteOpenHelper(Context context,String name,int version){
        this(context,name,null,version);
    }

    public MySQLiteOpenHelper(Context context,String name){
        this(context,name,Version);
    }
    

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println("创建数据库");

        String sql="create table user(id int primary key,name varchar(200))";

        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("更新数据库版本为"+newVersion);
    }
}
