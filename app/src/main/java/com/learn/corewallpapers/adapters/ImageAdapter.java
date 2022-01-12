package com.learn.corewallpapers.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.learn.corewallpapers.ClikedActivity;
import com.learn.corewallpapers.R;

import java.util.ArrayList;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewholder>{
    Context ctx;
    ArrayList<ImageModel> data = new ArrayList<>();
    public ImageAdapter(Context ctx,ArrayList<ImageModel> data){
        this.ctx = ctx;


    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.model_imageview,null);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {
        ImageModel temp = data.get(position);
        Glide.with(holder.itemView.getContext()).load(temp.getUrl()).into(holder.Image);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void updatedata(ArrayList<ImageModel> kali){
        data.clear();
        data.addAll(kali);
        notifyDataSetChanged();
    }



    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView Image;


        public viewholder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.WallpaperImage);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int Image_position = this.getAdapterPosition();
            ImageModel temp = data.get(Image_position);
            //Toast.makeText(itemView.getContext(), "Onclik " + Image_position , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ctx.getApplicationContext(), ClikedActivity.class);
            intent.putExtra("WALLPAPER",temp.getUrl());
            intent.putExtra("WALLPAPER_INFO",temp.getInfo());

            ctx.startActivity(intent);

        }
    }


}
