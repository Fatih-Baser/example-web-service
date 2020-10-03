package com.example.webbaglama6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {

    ArrayList<Example> examples;
    Context mContext;

    public Adapter(ArrayList<Example> examples, Context mContext) {
        this.examples = examples;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater=LayoutInflater.from(mContext);
        View view=layoutInflater.inflate(R.layout.row,parent,false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Example example=examples.get(position);
        holder.textView.setText(example.getTitle());
        String poster=example.getThumbnailUrl() ;
        Glide.with(mContext).load(poster).apply(RequestOptions.centerInsideTransform().placeholder(R.drawable.ic_launcher_background))
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView    textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView=(ImageView) itemView.findViewById(R.id.images);
            textView=(TextView) itemView.findViewById(R.id.texts);
        }
    }
}
