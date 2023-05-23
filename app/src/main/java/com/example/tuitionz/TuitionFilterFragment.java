package com.example.tuitionz;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import java.util.ArrayList;
public class TuitionFilterFragment extends BottomSheetDialogFragment {
    CheckBox checkBox1,checkBox2;
    TuitionAdapter adapter;
    ArrayList<TuitionModalClass> list;
    Button button;
    HomeFragment homeFragment;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        View view= inflater.inflate(R.layout.fragment_tuition_filter, container, false);
        checkBox1=view.findViewById(R.id.HighRating);
        checkBox2=view.findViewById(R.id.LowRating);
        button=view.findViewById(R.id.apply);
        homeFragment=new HomeFragment();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkBox1.isChecked()){
                    ArrayList<TuitionModalClass> filters= list;
                    homeFragment.applyfilters(filters);
                }
                else if(checkBox2.isChecked()){
                }
            }
        });
        return view;

    }

}