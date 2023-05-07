package com.example.tuitionz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewRecyclerViewAdapter extends RecyclerView.Adapter<ReviewRecyclerViewAdapter.viewHolder> {
    Context context;
    ArrayList<ReviewModal> list;

    public ReviewRecyclerViewAdapter(Context context, ArrayList<ReviewModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.reviewlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ReviewModal modal=list.get(position);
        holder.review.setText(modal.getReview());
        holder.trating.setRating(modal.getTutRate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView review;
        RatingBar trating;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            review=itemView.findViewById(R.id.tutreview);
            trating=itemView.findViewById(R.id.tuitionrating);


        }
    }
}
