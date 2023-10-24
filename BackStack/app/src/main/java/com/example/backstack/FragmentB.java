package com.example.backstack;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FragmentB extends Fragment {
    private Button buttonB;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        buttonB = view.findViewById(R.id.button_b);
        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity activityB = (MainActivity) getActivity();
                activityB.replaceFragment(new FragmentA(), true);
            }
        });
        return view;
    }
//    public void renderFragmentA(View view)
//    {
//        MainActivity activityB = (MainActivity) getActivity();
//        activityB.replaceFragment(new FragmentA(), true);
//
//    }
}
