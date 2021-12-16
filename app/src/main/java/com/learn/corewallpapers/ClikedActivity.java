package com.learn.corewallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class ClikedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliked);
        int id = getIntent().getIntExtra("IMAGE",0);
        TextView txt = findViewById(R.id.tool_text);
        txt.setText("Set Wallpaper");
        ImageView image = findViewById(R.id.imageView);
        Button set = findViewById(R.id.btn_setwallpaper);
        image.setImageResource(id);
        setwallpaper(set,id);
    }
    public void setwallpaper(Button bSetWallpaper , int id){

        // creating the instance of the WallpaperManager
                final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getApplicationContext());

                // handle the set wallpaper button to set the desired wallpaper for home screen

                bSetWallpaper.setOnClickListener(new View.OnClickListener() {
                    @SuppressLint("ResourceType")
                    @Override
                    public void onClick(View v) {
                        try {
                            // set the wallpaper by calling the setResource function and
                            // passing the drawable file
                            wallpaperManager.setResource(id);
                            Toast.makeText(getApplicationContext(), " New Wallpaper sets ! ", Toast.LENGTH_LONG).show();
                            finish();
                        } catch (IOException e) {
                            // here the errors can be logged instead of printStackTrace
                            e.printStackTrace();
                        }
                    }
                });
            }
        }


