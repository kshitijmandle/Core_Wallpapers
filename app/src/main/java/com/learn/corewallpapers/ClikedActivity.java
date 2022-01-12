package com.learn.corewallpapers;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class ClikedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliked);
        String URL_IMG = getIntent().getStringExtra("WALLPAPER");
        String URL_DESC = getIntent().getStringExtra("WALLPAPER_INFO");
        int n = URL_DESC.compareTo("null");
        if(n==1){
            URL_DESC = "No Description";
        }
        ImageButton backbutten = findViewById(R.id.backbutten);
        ImageView photo = findViewById(R.id.home_photo);
        Glide.with(getApplicationContext()).load(URL_IMG).into(photo);
        backbutten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        TextView setwallpaper = findViewById(R.id.setwallpaper);
        setwallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = ((BitmapDrawable)photo.getDrawable()).getBitmap();
                WallpaperManager manager = WallpaperManager.getInstance(getApplicationContext());
                try {
                    manager.setBitmap(bitmap);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(getApplicationContext(), " WallPaper Set SuccessFully ! ", Toast.LENGTH_SHORT).show();
            }
        });

        TextView description = findViewById(R.id.des_info);
        description.setText(URL_DESC);


    }




}