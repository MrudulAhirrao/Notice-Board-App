package com.example.secondpage;

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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class studReg extends AppCompatActivity {
TextInputEditText name, prn, email, div, year, pass;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_reg);

        name = findViewById(R.id.name);
        prn = findViewById(R.id.prn);
        email = findViewById(R.id.email);
        div = findViewById(R.id.div);
        year = findViewById(R.id.year);
        pass = findViewById(R.id.pass);
        button = findViewById(R.id.button);
    }

    public void studhome(View view) {
        if(name.getText().toString().isEmpty())
        {
            name.setError("Enter the Name");
            return;
        } else if (prn.getText().toString().isEmpty()) {
            prn.setError("Enter the Prn");
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Enter the E-mail");
        } else if (year.getText().toString().isEmpty()) {
            year.setError("Enter the Year");
        }
        else if (div.getText().toString().isEmpty()) {
            div.setError("Enter the Division");
        }
        else if (pass.getText().toString().isEmpty()) {
            pass.setError("Enter the Password");
        }
        else{
            String url = "https://catoptric-wood.000webhostapp.com/stureg.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(studReg.this, ""+response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(studReg.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Override
                public Map<String, String> getParams() {
                    Map<String,String> params= new HashMap<String,String>();
                    params.put("name",name.getText().toString());
                    params.put("prn",prn.getText().toString());
                    params.put("email",email.getText().toString());
                    params.put("year",year.getText().toString());
                    params.put("division",div.getText().toString());
                    params.put("password",pass.getText().toString());

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            Toast.makeText(this, "Successfully Registered", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(studReg.this,StudentLogin.class);
            startActivity(i);
        }
    }
    public void stulog(View view) {
        Intent i = new Intent(studReg.this,StudentLogin.class);
        startActivity(i);
    }

}