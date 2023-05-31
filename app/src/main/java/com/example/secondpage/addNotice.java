package com.example.secondpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class addNotice extends AppCompatActivity {
TextInputEditText noticeTitle, noticeDesc, date ;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_notice);
        

        noticeTitle = findViewById(R.id.noticeTitle);
        noticeDesc = findViewById(R.id.noticeDesc);
        date = findViewById(R.id.date);
        button = findViewById(R.id.button);
    }
    
    public void addNotice(View v)
    {
        if (noticeTitle.getText().toString().isEmpty()) {
            noticeTitle.setError("Add the Notice Title");
        } else if (noticeDesc.getText().toString().isEmpty()) {
            noticeDesc.setError("Add the Notice Description");
        } else if (date.getText().toString().isEmpty()) {
            date.setError("Mention the date please");
        }
        else{
            String url = "https://catoptric-wood.000webhostapp.com/addNotice.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(addNotice.this, ""+response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(addNotice.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Override
                public Map<String, String> getParams() {
                    Map<String,String> params= new HashMap<String,String>();
                    params.put("title",noticeTitle.getText().toString());
                    params.put("desc",noticeDesc.getText().toString());
                    params.put("date",date.getText().toString());
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
            Intent i = new Intent(addNotice.this,TeaNotice.class);
            startActivity(i);
        }
    }
}