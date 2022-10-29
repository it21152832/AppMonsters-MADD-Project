package com.example.mylyric;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mylyric.Database.Request;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    Context context;
    ArrayList  name,song,type;

    public MyAdapter(Context context, ArrayList name, ArrayList song, ArrayList type) {
        this.context = context;
        this.name = name;
        this.song = song;
        this.type = type;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(String.valueOf(name.get(position)));
        holder.song.setText(String.valueOf(song.get(position)));
        holder.type.setText(String.valueOf(type.get(position)));
    }

    @Override
    public int getItemCount() {
        return name.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,song,type;

        public MyViewHolder(@NonNull View view){
            super(view);
            name = view.findViewById(R.id.name_text);
            song = view.findViewById(R.id.title_text);
            type = view.findViewById(R.id.type_text);

        }

    }
}
