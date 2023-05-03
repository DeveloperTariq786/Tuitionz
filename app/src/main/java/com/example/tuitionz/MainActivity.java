package com.example.tuitionz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
ImageSlider slider;
RecyclerView recyclerView;
SearchView searchView;
TuitionAdapter adapter;
ArrayList<TuitionModalClass> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView=findViewById(R.id.Search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filterList(s);
                return true;
            }
        });
        recyclerView=findViewById(R.id.TuitionRecycleView);
        list=new ArrayList<>();
        adapter=new TuitionAdapter(list,this);
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",3.5f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",3.0f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",5.0f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",4.6f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",2.0f));
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        recyclerView.setAdapter(adapter);
        slider=findViewById(R.id.image_slider);
        ArrayList<SlideModel> modal=new ArrayList<>();
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        slider.setImageList(modal,ScaleTypes.FIT);
    }

    private void filterList(String s) {
        List<TuitionModalClass> filterlist =new ArrayList<>();
        for (TuitionModalClass modalClass: list){
            if (modalClass.getAddress().toLowerCase().contains(s.toLowerCase())){
                filterlist.add(modalClass);
            }
        }
        if (filterlist.isEmpty()){
            Toast.makeText(this, "No Match Found", Toast.LENGTH_SHORT).show();
        }
        else {
            adapter.filterlist(filterlist);
        }
    }
}