package com.example.secondpage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TeaNotice extends AppCompatActivity {
ListView myListView;
NoticesAdapter adapter;
Notices notices;
ImageView img;
public static ArrayList<Notices> noticesArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tea_notice);

        myListView = findViewById(R.id.myListView);
        img = findViewById(R.id.img);
        adapter = new NoticesAdapter(this, noticesArrayList);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                ProgressDialog progressDialog = new ProgressDialog(view.getContext());

                CharSequence[] dialogItem = {"View Notice","Edit Data","Delete Data"};
                builder.setTitle(noticesArrayList.get(position).getTitle());
                builder.setItems(dialogItem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        switch (i)
                        {
                            case 0:
                                startActivity(new Intent(getApplicationContext(),NoticeDetails.class).putExtra("position",position));

                                break;
                            case 1:
                                startActivity(new Intent(getApplicationContext(),updateNotices.class).putExtra("position",position));
                                break;
                            case 2:
                                deleteData(noticesArrayList.get(position).getId());
                                break;
                        }
                    }
                });

                builder.create();
                builder.show();
            }
        });
        retrieveData();
    }

    private void deleteData(String id) {
        String url = "https://catoptric-wood.000webhostapp.com/deleteNotice.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                       if(response.equalsIgnoreCase("Data Deleted")){
                           Toast.makeText(TeaNotice.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                       }
                       else{
                           Toast.makeText(TeaNotice.this, "Data not deleted", Toast.LENGTH_SHORT).show();
                       }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(TeaNotice.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params= new HashMap<String,String>();
                params.put("id",id);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void retrieveData()
    {
        String url = "https://catoptric-wood.000webhostapp.com/retrieveNotice.php";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        noticesArrayList.clear();
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

                                    notices = new Notices(id, title, desc, date);
                                    noticesArrayList.add(notices);
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
                        Toast.makeText(TeaNotice.this, ""+error.toString(), Toast.LENGTH_SHORT).show();
                    }
                });
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void addData(View v)
    {
        Intent i = new Intent(TeaNotice.this,addNotice.class);
        startActivity(i);
    }


    public void back(View view) {
        Intent i2 = new Intent(TeaNotice.this,MainActivity.class);
        startActivity(i2);
    }
}