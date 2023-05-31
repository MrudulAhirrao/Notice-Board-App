package com.example.secondpage;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class TeacherLogin extends AppCompatActivity {
TextInputEditText users, pass;
Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher_login);

        users = findViewById(R.id.users);
        pass = findViewById(R.id.pass);
        button = findViewById(R.id.button);
    }
    public void teaLog(View view)
    {

//        Toast.makeText(TeacherLogin.this, ""+users.getText().toString()+"\n"+pass.getText().toString(), Toast.LENGTH_SHORT).show();
        if(users.getText().toString().isEmpty())
        {
            users.setError("Username will be mandatory");
            return;
        } else if (pass.getText().toString().isEmpty()) {
            pass.setError("Password will be mandatory");
        }
        else{
//            String url = "https://catoptric-wood.000webhostapp.com/teaLog.php";
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
//                    new Response.Listener<String>() {
//                        @Override
//                        public void onResponse(String response) {
//                            Toast.makeText(TeacherLogin.this, ""+response, Toast.LENGTH_SHORT).show();
//                            if(response.equals("Success"))
//                            {
//                                Intent i = new Intent(TeacherLogin.this,StuNotice.class);
//                                startActivity(i);
//                            }
//                            else
//                                Toast.makeText(TeacherLogin.this, "Invalid Login", Toast.LENGTH_SHORT).show();
//                        }
//                    },
//                    new Response.ErrorListener() {
//                        @Override
//                        public void onErrorResponse(VolleyError error) {
//                            Toast.makeText(TeacherLogin.this, "Unable to Login"+" "+error.toString(), Toast.LENGTH_SHORT).show();
//                            Log.d("TeacherLoginError",error.toString());
//                        }
//                    }){
//                @Override
//                public Map<String, String> getParams() {
//                    Map<String,String> params= new HashMap<String,String>();
//                    params.put("id",users.getText().toString());
//                    params.put("password",pass.getText().toString());
//                    return params;`
//            };
//            RequestQueue requestQueue = Volley.newRequestQueue(this);
//            requestQueue.add(stringRequest);
            Intent i = new Intent(TeacherLogin.this,TeaNotice.class);
                           startActivity(i);
        }
    }
    public void teareg(View v){
        Intent i = new Intent(TeacherLogin.this,TeacherReg.class);
        startActivity(i);
    }
}