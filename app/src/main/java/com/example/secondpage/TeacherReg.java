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

public class TeacherReg extends AppCompatActivity {
TextInputEditText teachid, name, email, dep, pass;
Button Register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_reg);

        teachid = findViewById(R.id.teachid);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        dep = findViewById(R.id.dep);
        pass = findViewById(R.id.pass);
        Register = findViewById(R.id.Register);
    }
    public void teareg(View view) {
        if(teachid.getText().toString().isEmpty())
        {
            teachid.setError("Enter the id");
        } else if (name.getText().toString().isEmpty()) {
            name.setError("Enter the Name");
        } else if (email.getText().toString().isEmpty()) {
            email.setError("Enter the mail");
        } else if (dep.getText().toString().isEmpty()) {
            dep.setError("Enter the department");
        } else if (pass.getText().toString().isEmpty()) {
            pass.setError("Enter the Password");
        } else {
            String url = "https://catoptric-wood.000webhostapp.com/teareg.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(TeacherReg.this, ""+response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(TeacherReg.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }){
                @Override
                public Map<String, String> getParams() {
                    Map<String,String> params= new HashMap<String,String>();
                    params.put("id",teachid.getText().toString());
                    params.put("name",name.getText().toString());
                    params.put("email",email.getText().toString());
                    params.put("department",dep.getText().toString());
                    params.put("password",pass.getText().toString());

                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(stringRequest);

            Intent i = new Intent(TeacherReg.this, TeacherLogin.class);
            startActivity(i);
        }
    }
    public void teaLog(View view) {
        Intent i2 = new Intent(TeacherReg.this,TeacherLogin.class);
        startActivity(i2);
    }
}