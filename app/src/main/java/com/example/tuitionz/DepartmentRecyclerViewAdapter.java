package com.example.tuitionz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class DepartmentRecyclerViewAdapter extends RecyclerView.Adapter<DepartmentRecyclerViewAdapter.viewHolder> {
    Context context;
    ArrayList<DepartmentModal> list;

    public DepartmentRecyclerViewAdapter(Context context, ArrayList<DepartmentModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.departmentlayout,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        DepartmentModal modal=list.get(position);
        holder.courcename.setText(modal.getSubject());
        holder.courceimage.setImageResource(modal.getDimage());
        holder.crating.setRating(modal.Drating);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(context,DepartmentDetailActivity.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView courceimage;
        TextView courcename;
        RatingBar crating;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            courceimage=itemView.findViewById(R.id.Dimage);
            courcename=itemView.findViewById(R.id.subject);
            crating=itemView.findViewById(R.id.Drating);
        }
    }
}
