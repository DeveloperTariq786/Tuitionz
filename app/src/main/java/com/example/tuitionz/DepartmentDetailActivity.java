package com.example.tuitionz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class DepartmentDetailActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<FacultyDetailModal> list;
    FacultyDetailRecyclerviewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_detail);
        recyclerView=findViewById(R.id.FacultyRecycleview);
        list=new ArrayList<>();
        list.add(new FacultyDetailModal("Tariq Hameed",R.drawable.newimg,3.6f));
        list.add(new FacultyDetailModal("Tariq Hameed",R.drawable.newimg,3.6f));
        list.add(new FacultyDetailModal("Tariq Hameed",R.drawable.newimg,3.6f));
        list.add(new FacultyDetailModal("Tariq Hameed",R.drawable.newimg,3.6f));
        list.add(new FacultyDetailModal("Tariq Hameed",R.drawable.newimg,3.6f));
        adapter=new FacultyDetailRecyclerviewAdapter(this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}