package com.example.tuitionz;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FacultyDetailRecyclerviewAdapter extends RecyclerView.Adapter<FacultyDetailRecyclerviewAdapter.viewHolder> {
    Context context;
    ArrayList<FacultyDetailModal> list;

    public FacultyDetailRecyclerviewAdapter(Context context, ArrayList<FacultyDetailModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.facultylayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FacultyDetailModal modal=list.get(position);
        holder.fprofile.setImageResource(modal.getFimage());
        holder.frate.setRating(modal.getFrating());
        holder.fname.setText(modal.getFname());
        holder.freview.setText(modal.getFreview());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView fprofile;
        RatingBar frate;
        TextView fname;
         TextView  freview;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            fprofile=itemView.findViewById(R.id.facultyProfile);
            frate=itemView.findViewById(R.id.facultyrate);
            fname=itemView.findViewById(R.id.facultyName);
            freview=itemView.findViewById(R.id.facultyReviews);
        }
    }
}
