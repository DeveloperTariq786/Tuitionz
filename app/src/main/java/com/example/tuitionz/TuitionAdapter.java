package com.example.tuitionz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class TuitionAdapter extends RecyclerView.Adapter<TuitionAdapter.viewHolder> implements Filterable{
    ArrayList<TuitionModalClass> list;
    Context context;
    ArrayList<TuitionModalClass> newlist;

    public TuitionAdapter(ArrayList<TuitionModalClass> list, Context context) {
        this.list = list;
        this.context = context;
        newlist=new ArrayList<>(list);
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.fronttuitionlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        TuitionModalClass modalClass=list.get(position);
       holder.tuitionimg.setImageResource(modalClass.getTuitionImage());
       holder.address.setText(modalClass.getAddress());
       holder.rating.setRating(modalClass.getRating());
       holder.itemView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent=new Intent(context,DetailTuitionActivity.class);
               context.startActivity(intent);
           }
       });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return newFilter;
    }
    final Filter newFilter=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence keyword) {
           ArrayList<TuitionModalClass> filterlist = new ArrayList<>();
           if (keyword==null||keyword.length()==0){
               filterlist.addAll(list);
           }
           else {

               for (TuitionModalClass modalClass: newlist){
                   if (modalClass.Address.toLowerCase().trim().contains(keyword.toString().toLowerCase()))
                       filterlist.add(modalClass);
               }
           }
           FilterResults results=new FilterResults();
           results.values= filterlist;
           return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            list.clear();
          list.addAll((ArrayList)filterResults.values);
           notifyDataSetChanged();

        }
    };

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
