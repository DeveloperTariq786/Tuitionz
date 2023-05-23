package com.example.tuitionz;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HomeFragment extends Fragment {
    ImageSlider slider;
    RecyclerView recyclerView;
    SearchView searchView;
    TuitionAdapter adapter;
    ArrayList<TuitionModalClass> list;
    FloatingActionButton filter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.TuitionRecycleView);
        searchView = view.findViewById(R.id.Search);
        list = new ArrayList<>();
        filter=view.findViewById(R.id.filter);
        filter.setOnClickListener(view1-> {
            TuitionFilterFragment fragment=new TuitionFilterFragment();
            fragment.show(getChildFragmentManager(), fragment.getTag());
            adapter = new TuitionAdapter(list, getContext());
            recyclerView.setAdapter(adapter);
            adapter.notifyDataSetChanged();
        });
        list.add(new TuitionModalClass(R.drawable.newimg, "Budgam", 3.5f));
        list.add(new TuitionModalClass(R.drawable.newimg, "Babapora", 3.0f));
        list.add(new TuitionModalClass(R.drawable.newimg, "Parnewa", 5.0f));
        list.add(new TuitionModalClass(R.drawable.newimg, "ParayPora", 4.6f));
        list.add(new TuitionModalClass(R.drawable.newimg, "KhemShora", 2.0f));
        adapter = new TuitionAdapter(list, getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        slider = view.findViewById(R.id.image_slider);
        ArrayList<SlideModel> modal = new ArrayList<>();
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses", ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses", ScaleTypes.FIT));
        modal.add(new SlideModel(R.drawable.newimg, "modalClasses", ScaleTypes.FIT));
        slider.setImageList(modal, ScaleTypes.FIT);
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
        return view;
    }
    public ArrayList<TuitionModalClass> applyfilters(ArrayList<TuitionModalClass> filter){
        ArrayList<TuitionModalClass> filterlist=applyfilters(filter);
        Collections.sort(filterlist, new Comparator<TuitionModalClass>() {
            @Override
            public int compare(TuitionModalClass t1, TuitionModalClass t2) {
                if (t1.getRating() > t2.getRating()) {
                    return -1;
                } else if (t1.getRating() < t2.getRating()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        adapter.UpDatelist(filterlist);
        return filterlist;
    }
}