package com.example.secondpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class stuNoticeDetails extends AppCompatActivity {
    TextView Tid,Ttitle, Tdesc, Tdate;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_notice_details);

        Tid = findViewById(R.id.Tid);
        Ttitle = findViewById(R.id.Ttitle);
        Tdesc = findViewById(R.id.Tdesc);
        Tdate = findViewById(R.id.Tdate);

        Intent intent= getIntent();
        position = intent.getExtras().getInt("position");

        Tid.setText("Id: "+StuNotice.noticeArrayList.get(position).getId());
        Ttitle.setText("Title: "+StuNotice.noticeArrayList.get(position).getTitle());
        Tdesc.setText("Description: "+StuNotice.noticeArrayList.get(position).getDesc());
        Tdate.setText("Date: "+StuNotice.noticeArrayList.get(position).getDate());
    }
}