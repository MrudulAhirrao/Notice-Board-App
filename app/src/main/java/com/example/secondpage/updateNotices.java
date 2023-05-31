package com.example.secondpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;

public class updateNotices extends AppCompatActivity {
TextInputEditText nid,ntitle,ndesc,ndate;
Button button;
private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notices);

        nid = findViewById(R.id.nid);
        ntitle = findViewById(R.id.ntitle);
        ndesc = findViewById(R.id.ndesc);
        ndate = findViewById(R.id.ndate);
        button = findViewById(R.id.button);

        Intent intent = getIntent();
        position = intent.getExtras().getInt("position");


        nid.setText(TeaNotice.noticesArrayList.get(position).getId());
        ntitle.setText(TeaNotice.noticesArrayList.get(position).getTitle());
        ndesc.setText(TeaNotice.noticesArrayList.get(position).getDesc());
        ndate.setText(TeaNotice.noticesArrayList.get(position).getDate());


    }

    public void updateNotice(View view) {
        String title = ntitle.getText().toString();
        String desc = ndesc.getText().toString();
        String date = ndate.getText().toString();
            String url = "https://catoptric-wood.000webhostapp.com/updateNotices.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(updateNotices.this, ""+response, Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(updateNotices.this,TeaNotice.class);
                            startActivity(i);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(updateNotices.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params= new HashMap<String,String>();
                    params.put("id", String.valueOf(nid));
                    params.put("title", String.valueOf(ntitle));
                    params.put("desc", String.valueOf(ndesc));
                    params.put("date", String.valueOf(ndate));
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);
    }
}