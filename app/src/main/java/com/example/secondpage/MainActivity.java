package com.example.secondpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void student(View view) {
        Intent i = new Intent(MainActivity.this,StudentLogin.class);
        startActivity(i);
    }

    public void teacher(View view) {
        Intent i2 = new Intent(MainActivity.this,TeacherLogin.class);
        startActivity(i2);
    }
}