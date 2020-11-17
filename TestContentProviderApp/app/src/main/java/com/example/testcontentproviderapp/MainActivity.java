package com.example.testcontentproviderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button add=findViewById(R.id.btn_add);
        Button search =findViewById(R.id.btn_search);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickAddName(view);
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickRetrieveStudents(view);
            }
        });
    }

    public void onClickAddName(View view){
        ContentValues values=new ContentValues();
        values.put(StudentsProvider.NAME,((EditText)findViewById(R.id.ed1)).getText().toString());
        values.put(StudentsProvider.GRADE,((EditText)findViewById(R.id.ed2)).getText().toString());

        Uri uri=getContentResolver().insert(StudentsProvider.CONTENT_URI,values);
        Toast.makeText(getBaseContext(),uri.toString(),Toast.LENGTH_LONG).show();
    }

    //查询记录
    public void onClickRetrieveStudents(View view) {

        // Retrieve student records
        String URL = "content://com.example.testcontentproviderapp/students";

        Uri students = Uri.parse(URL);
        Cursor c = getContentResolver().query(students, null, null, null, "name");

        if (c.moveToFirst()) {
            do{
                Toast.makeText(this,
                        c.getString(c.getColumnIndex(StudentsProvider._ID)) +
                                ", " +  c.getString(c.getColumnIndex( StudentsProvider.NAME)) +
                                ", " + c.getString(c.getColumnIndex( StudentsProvider.GRADE)),
                        Toast.LENGTH_SHORT).show();
            } while (c.moveToNext());
        }
    }
}