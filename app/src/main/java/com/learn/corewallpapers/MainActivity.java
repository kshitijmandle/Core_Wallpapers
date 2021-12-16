package com.learn.corewallpapers;


import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.learn.corewallpapers.adapters.ImageAdapter;
import com.learn.corewallpapers.adapters.ImageModel;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

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
        TextView tooltxt = findViewById(R.id.tool_text);
        tooltxt.setText("HD WallPaper");
        RecyclerView recyclerView = findViewById(R.id.ImageRecyclerview);
        ArrayList<ImageModel> data = new ArrayList<>();
        data.add(new ImageModel(R.drawable.wallpaper3,"BlackEye"));
        data.add(new ImageModel(R.drawable.fbimg10,"Crushmika"));
        data.add(new ImageModel(R.drawable.wallpaper7,"Mustang Dodge"));
        data.add(new ImageModel(R.drawable.wallpaper4,"CyberHacker"));
        data.add(new ImageModel(R.drawable.fbimg8,"Crushmika"));
        data.add(new ImageModel(R.drawable.fbimg9,"Crushmika"));
        data.add(new ImageModel(R.drawable.wallpaper1,"Night"));
        data.add(new ImageModel(R.drawable.wallpaper5,"Rami malek"));
        data.add(new ImageModel(R.drawable.fbimg,"Crushmika"));
        //data.add(new ImageModel(R.drawable.wallpaper6,"Elliot"));
        data.add(new ImageModel(R.drawable.fbimg11,"Crushmika"));
        data.add(new ImageModel(R.drawable.fbimg3,"Crushmika"));
        data.add(new ImageModel(R.drawable.fbimg1,"Crushmika"));
        data.add(new ImageModel(R.drawable.fbimg4,"Crushmika"));
        data.add(new ImageModel(R.drawable.fbimg5,"Crushmika"));
        //data.add(new ImageModel(R.drawable.wallpaper2,"Alone"));
        data.add(new ImageModel(R.drawable.wallpaper8,"Rami malek"));
        ImageAdapter adapter = new ImageAdapter(getApplication(),data);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));




    }
  public void ImageAPICALL(){
      String url = "http://my-json-feed";

      JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
              (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                  @Override
                  public void onResponse(JSONObject response) {
                     // JSONArray Arr = response.getJSONArray();

                  }
              }, new Response.ErrorListener() {

                  @Override
                  public void onErrorResponse(VolleyError error) {
                      // TODO: Handle error

                  }
              });

              // Access the RequestQueue through your singleton class.



  }
}