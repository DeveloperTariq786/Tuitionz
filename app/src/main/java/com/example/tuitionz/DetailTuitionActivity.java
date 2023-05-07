package com.example.tuitionz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class DetailTuitionActivity extends AppCompatActivity {
RecyclerView drecyclerview;
TextView about,review;

ArrayList<DepartmentModal> dlist;
DepartmentRecyclerViewAdapter dadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_tuition);
        about=findViewById(R.id.about);
        drecyclerview=findViewById(R.id.departmentrecycleview);
        review=findViewById(R.id.reviews);
        review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReviewTuitionFragment fragment=new ReviewTuitionFragment();
                fragment.show(getSupportFragmentManager(), fragment.getTag());
            }
        });
       dlist=new ArrayList<>();
       dlist.add(new DepartmentModal(R.drawable.newimg,"Physics",3.5f));
        dlist.add(new DepartmentModal(R.drawable.newimg,"Chemistry",4.5f));
        dlist.add(new DepartmentModal(R.drawable.newimg,"Biology",3.0f));
        dlist.add(new DepartmentModal(R.drawable.newimg,"Mathematics",4.0f));
        dadapter=new DepartmentRecyclerViewAdapter(this,dlist);
        drecyclerview.setAdapter(dadapter);
        drecyclerview.setLayoutManager(new GridLayoutManager(DetailTuitionActivity.this,2));
    }
}