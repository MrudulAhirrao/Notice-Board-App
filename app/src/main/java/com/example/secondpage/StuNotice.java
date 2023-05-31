package com.example.secondpage;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.secondpage.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StuNotice extends AppCompatActivity {
ListView listView;
TextView text;
ImageView img;
NoticeAdapter adapter;
Notice notice;
public static ArrayList<Notice> noticeArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_notice);

        text = findViewById(R.id.text);
        img = findViewById(R.id.img);
        listView = findViewById(R.id.listview);
        adapter = new NoticeAdapter(this, noticeArrayList);
        listView.setAdapter(adapter);
        retrieveData();
    }

    private void retrieveData() {
        String url = "https://catoptric-wood.000webhostapp.com/retrieveNotice.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        noticeArrayList.clear();
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray =jsonObject.getJSONArray("notice");

                            if(success.equals("1")){

                                for (int i = 0; i < jsonArray.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);

                                    String id = object.getString("id");
                                    String title = object.getString("title");
                                    String desc = object.getString("desc");
                                    String date = object.getString("date");

                                    notice = new Notice(id,title, desc, date);
                                    noticeArrayList.add(notice);
                                    adapter.notifyDataSetChanged();
                                }
                            }

                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(StuNotice.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void back(View view) {
        Intent i = new Intent(StuNotice.this,MainActivity.class);
        startActivity(i);
    }
}