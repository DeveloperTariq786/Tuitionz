package com.example.tuitionz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.media.Rating;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
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
        recyclerView=findViewById(R.id.TuitionRecycleView);
        searchView=findViewById(R.id.Search);
        list=new ArrayList<>();
        list.add(new TuitionModalClass(R.drawable.newimg,"Budgam",3.5f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Babapora",3.0f));
        list.add(new TuitionModalClass(R.drawable.newimg,"Parnewa",5.0f));
        list.add(new TuitionModalClass(R.drawable.newimg,"ParayPora",4.6f));
        list.add(new TuitionModalClass(R.drawable.newimg,"KhemShora",2.0f));
        Collections.sort(list, new Comparator<TuitionModalClass>() {
            @Override
            public int compare(TuitionModalClass t1, TuitionModalClass t2) {
               if (t1.getRating()>t2.getRating()){
                   return -1;
               } else if (t1.getRating()<t2.getRating()) {
                   return 1;
               }
               else {
                   return 0;
               }
            }
        });
        adapter=new TuitionAdapter(list,this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        slider=findViewById(R.id.image_slider);
        ArrayList<SlideModel> modal=new ArrayList<>();
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses",ScaleTypes.FIT));
        slider.setImageList(modal,ScaleTypes.FIT);
        searchView.setQueryHint("Enter Address");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
}
