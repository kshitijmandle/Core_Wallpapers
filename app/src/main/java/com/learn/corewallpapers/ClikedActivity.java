package com.learn.corewallpapers;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.io.IOException;

public class ClikedActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliked);
        String URL_IMG = getIntent().getStringExtra("WALLPAPER");
        String URL_DESC = getIntent().getStringExtra("WALLPAPER_INFO");
        ImageView back = findViewById(R.id.backbuuten);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ImageView photo = findViewById(R.id.home_photo);
        Glide.with(getApplicationContext()).load(URL_IMG).into(photo);

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