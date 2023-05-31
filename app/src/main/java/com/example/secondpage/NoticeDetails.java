package com.example.secondpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NoticeDetails extends AppCompatActivity {
TextView Tid,Ttitle, Tdesc, Tdate;
int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_details);

        Tid = findViewById(R.id.Tid);
        Ttitle = findViewById(R.id.Ttitle);
        Tdesc = findViewById(R.id.Tdesc);
        Tdate = findViewById(R.id.Tdate);

        Intent intent= getIntent();
        position = intent.getExtras().getInt("position");

        Tid.setText("Id: "+TeaNotice.noticesArrayList.get(position).getId());
        Ttitle.setText("Title: "+TeaNotice.noticesArrayList.get(position).getTitle());
        Tdesc.setText("Description: "+TeaNotice.noticesArrayList.get(position).getDesc());
        Tdate.setText("Date: "+TeaNotice.noticesArrayList.get(position).getDate());


    }
}