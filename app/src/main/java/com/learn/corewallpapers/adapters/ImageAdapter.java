package com.learn.corewallpapers.adapters;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.corewallpapers.ClikedActivity;
import com.learn.corewallpapers.R;

import java.util.ArrayList;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.viewholder>{
    Context ctx;
    ArrayList<ImageModel> data;
    public ImageAdapter(Context ctx , ArrayList<ImageModel> data){
        this.ctx = ctx;
        this.data = data;
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
        holder.Name.setText(temp.getName());
        holder.Image.setImageResource(temp.getTempimage());

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView Image;
        TextView Name;

        public viewholder(@NonNull View itemView) {
            super(itemView);
            Image = itemView.findViewById(R.id.WallpaperImage);
            Name = itemView.findViewById(R.id.WallpaperName);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int Image_position = this.getAdapterPosition();
            ImageModel temp = data.get(Image_position);
            //Toast.makeText(itemView.getContext(), "Onclik " + Image_position , Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ctx.getApplicationContext(), ClikedActivity.class);
            intent.putExtra("IMAGE", temp.getTempimage());
            ctx.startActivity(intent);

        }
    }


}
