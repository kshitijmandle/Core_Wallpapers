package com.learn.corewallpapers;


import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.JsonRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.learn.corewallpapers.adapters.ImageAdapter;
import com.learn.corewallpapers.adapters.ImageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MainActivity extends AppCompatActivity {
    ArrayList<ImageModel> photos;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView btn = findViewById(R.id.list_image);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " In Development Thank You ", Toast.LENGTH_SHORT).show();
            }
        });

        ImageView btn2 = findViewById(R.id.share_view);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), " In Development Comming Soon  ", Toast.LENGTH_SHORT).show();
            }
        });
        getimageapidata();
        photos = new ArrayList<>();
        TextView tooltxt = findViewById(R.id.tool_text);
        tooltxt.setText("HD Wallpapers");
        recyclerView = findViewById(R.id.ImageRecyclerview);




    }
    void getimageapidata(){
        String url = "https://api.unsplash.com/photos/?client_id=wo7f5-hNMfbAuGiOPxr4lit4_aZhe-Uq9h45u_kc75E";
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for(int i=0;i<response.length();i++){
                    try {
                        ImageModel img = new ImageModel();
                        JSONObject imageobject = response.getJSONObject(i);
                        img.setInfo(imageobject.getString("description"));
                        JSONObject urlobject = imageobject.getJSONObject("urls");
                        img.setUrl(urlobject.getString("regular"));
                        photos.add(img);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    ImageAdapter adapter = new ImageAdapter(getApplication(),photos);
                    recyclerView.setAdapter(adapter);
                    recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));

                }

            }
        },new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Something Went's Wrong Check Your Internet", Toast.LENGTH_SHORT).show();

            }
        });
        queue.add(jsonArrayRequest);

    }

}