package com.adinall.aptdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.adinall.anno.MyAnno;


public class MainActivity extends AppCompatActivity {

    @MyAnno
    private String  name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }
}
