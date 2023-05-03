package com.example.tuitionz;

import android.content.Context;
import android.media.Rating;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TuitionAdapter extends RecyclerView.Adapter<TuitionAdapter.viewHolder> {
    ArrayList<TuitionModalClass> list;
    Context context;

    public TuitionAdapter(ArrayList<TuitionModalClass> list, Context context) {
        this.list = list;
        this.context = context;
    }
    public void filterlist(List<TuitionModalClass> list1){
        this.list= (ArrayList<TuitionModalClass>) list1;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.example,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TuitionModalClass modalClass=list.get(position);
       holder.tuitionimg.setImageResource(modalClass.getTuitionImage());
       holder.address.setText(modalClass.getAddress());
       holder.rating.setRating(modalClass.getRating());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView tuitionimg;
        TextView address;
        RatingBar rating;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tuitionimg=itemView.findViewById(R.id.tuitionimage);
            address=itemView.findViewById(R.id.address);
            rating=itemView.findViewById(R.id.rating);
        }
    }
}
