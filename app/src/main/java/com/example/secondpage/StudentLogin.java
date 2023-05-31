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

public class StudentLogin extends AppCompatActivity {
TextInputEditText user, pass;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);

        user = findViewById(R.id.user);
        pass = findViewById(R.id.pass);
        button = findViewById(R.id.button);
    }
    public void studhome(View view) {

        if(user.getText().toString().isEmpty())
        {
            user.setError("Username will be mandatory");
            return;
        } else if (pass.getText().toString().isEmpty()) {
            pass.setError("Password will be mandatory");
        }
        else{
//            String url = "https://catoptric-wood.000webhostapp.com/stuLog.php";
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Toast.makeText(StudentLogin.this, ""+response, Toast.LENGTH_SHORT).show();
//                            if(response.equals("Success"))
//                            {
                                Intent i = new Intent(StudentLogin.this,StuNotice.class);
                                startActivity(i);
//                            }
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(StudentLogin.this, "Unable to Login"+" "+error.toString(), Toast.LENGTH_SHORT).show();
//                        }
//                    }){
//                @Override
//                public Map<String, String> getParams() {
//                    Map<String,String> params= new HashMap<String,String>();
//                    params.put("name",user.getText().toString());
//                    params.put("password",pass.getText().toString());
//
//                    return params;
//                }
//            };
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            requestQueue.add(stringRequest);
        }
    }
    public void stureg(View view) {
        Intent i = new Intent(StudentLogin.this,studReg.class);
        startActivity(i);
    }

}