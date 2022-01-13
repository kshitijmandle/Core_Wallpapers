package com.learn.corewallpapers;


import static java.security.AccessController.getContext;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;
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
import com.learn.corewallpapers.adapters.CustumLoader;
import com.learn.corewallpapers.adapters.ImageAdapter;
import com.learn.corewallpapers.adapters.ImageModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    SearchView searchView;
    ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getimageapidata();
        recyclerView = findViewById(R.id.ImageRecyclerview);
        searchView = findViewById(R.id.search_q);
        searchView.setQueryHint("Search Here");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchimageapicall(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

               return false;
            }
        });
    }
    public void getimageapidata(){

        String RandomImages[] = {"cats","dogs","nature","nights","cars","computers","skys","sea","beach","plants","forests"};
        Random rand = new Random();
        int randomnumber = rand.nextInt(10);
        String QeryString = RandomImages[randomnumber];

        ArrayList<ImageModel> photos = new ArrayList<>();
        String url = "https://api.unsplash.com/search/photos/?client_id=wo7f5-hNMfbAuGiOPxr4lit4_aZhe-Uq9h45u_kc75E&page=1&per_page=100&query="+QeryString;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arr = response.getJSONArray("results");
                            Toast.makeText(getApplicationContext(), "Size is " + arr.length() , Toast.LENGTH_SHORT).show();
                            for(int i=0;i<arr.length();i++){
                                ImageModel img = new ImageModel();
                                JSONObject resultobject = (JSONObject) arr.get(i);
                                img.setInfo(resultobject.getString("description"));
                                JSONObject urlobject = resultobject.getJSONObject("urls");
                                img.setUrl(urlobject.getString("regular"));
                                photos.add(img);

                            }
                            adapter = new ImageAdapter(getApplication(),photos);
                            adapter.updatedata(photos);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);


    }
    void searchimageapicall(String a){
        ArrayList<ImageModel> photos = new ArrayList<>();
        String url = "https://api.unsplash.com/search/photos/?client_id=wo7f5-hNMfbAuGiOPxr4lit4_aZhe-Uq9h45u_kc75E&page=1&per_page=100&query="+a;
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray arr = response.getJSONArray("results");
                            for(int i=0;i<arr.length();i++){
                                ImageModel img = new ImageModel();
                                JSONObject resultobject = (JSONObject) arr.get(i);
                                img.setInfo(resultobject.getString("description"));
                                //Log.d("KALI-LEN", "onResponse: " + resultobject.getString("alt_description"));
                                JSONObject urlobject = resultobject.getJSONObject("urls");
                                img.setUrl(urlobject.getString("regular"));
                                photos.add(img);

                            }
                            adapter = new ImageAdapter(getApplication(),photos);
                            adapter.updatedata(photos);
                            recyclerView.setAdapter(adapter);
                            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }



                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO: Handle error

                    }
                });

        // Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);




    }


}