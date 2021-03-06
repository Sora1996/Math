package com.example.math;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double result=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView=findViewById(R.id.tv1);
        TextView tv_version=findViewById(R.id.version);
        tv_version.setText("v1.1");
        Button button1=findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add();
                String str=String.format("%.2f", result);
                textView.setText(str);
            }
        });
    }

    public double add(){
        double sum=0;
        EditText editText1=findViewById(R.id.ed1);
        EditText editText2=findViewById(R.id.ed2);
        EditText editText3=findViewById(R.id.ed3);
        EditText editText4=findViewById(R.id.ed4);
        EditText editText5=findViewById(R.id.ed5);
        //double num1=Double.parseDouble(editText1.getText().toString());
        double num1,num2,num3,num4,num5;
        if(editText1.getText().toString().isEmpty()) num1=0;
        else num1=Double.parseDouble(editText1.getText().toString());
        if(editText2.getText().toString().isEmpty()) num2=0;
        else num2=Double.parseDouble(editText2.getText().toString());
        if(editText3.getText().toString().isEmpty()) num3=0;
        else num3=Double.parseDouble(editText3.getText().toString());
        if(editText4.getText().toString().isEmpty()) num4=0;
        else num4=Double.parseDouble(editText4.getText().toString());
        if(editText5.getText().toString().isEmpty()) num5=0;
        else num5=Double.parseDouble(editText5.getText().toString());
        sum = num1 * 10000;
        while(num2>0){
            if(num2>12){
                for(int i=0;i<12;i++){
                    sum +=num4;
                    sum *=(100+num3/12)/100;
                }
            }else{
                for(int i=0;i<num2;i++){
                    sum +=num4;
                    sum *=(100+num3/12)/100;
                }
            }
            num4+=num5;
            num2-=12;
        }
        result = sum /10000;
        return result;
    }

}