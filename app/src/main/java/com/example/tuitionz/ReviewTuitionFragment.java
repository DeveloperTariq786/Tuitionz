package com.example.tuitionz;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.ArrayList;

public class ReviewTuitionFragment extends BottomSheetDialogFragment {
    RecyclerView rRrecyclerView;
    ArrayList<ReviewModal> rlist;
    ReviewRecyclerViewAdapter radapter;
    public ReviewTuitionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_review_tuition, container, false);
        rRrecyclerView=view.findViewById(R.id.TuitionReviewRecycleView);
        rlist=new ArrayList<>();
        rlist.add(new ReviewModal("Amazing Service",2.5f));
        rlist.add(new ReviewModal("One of the best app for tuition ",4.5f));
        rlist.add(new ReviewModal("Quit Impressive ",3.5f));
        rlist.add(new ReviewModal("best Buddy ever",3.0f));
        rlist.add(new ReviewModal("One of the best app for tuition selection",4.5f));
        rlist.add(new ReviewModal("Quit Impressive ",3.5f));
        rlist.add(new ReviewModal("One of the best app for tuition choice",4.5f));
        radapter=new ReviewRecyclerViewAdapter(getContext(), rlist);
        rRrecyclerView.setAdapter(radapter);
        rRrecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }
}