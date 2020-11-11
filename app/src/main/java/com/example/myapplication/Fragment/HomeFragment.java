package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    Button btnChild,btnProtective,btnWomen;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home,container,false);

        btnChild=view.findViewById(R.id.child);
        btnWomen=view.findViewById(R.id.women);
        btnProtective=view.findViewById(R.id.protective);

        btnChild.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getContext(),"INSIDE CHILD",Toast.LENGTH_LONG).show();
                HomeActivity hm=(HomeActivity) getActivity();
                Fragment fm=new ChildFragment();
                hm.replaceFragment(fm);

            }
        });

        btnWomen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              HomeActivity hm=(HomeActivity)getActivity();
              Fragment fm=new WomenFragment();
              hm.replaceFragment(fm);
            }
        });

        btnProtective.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeActivity hm=(HomeActivity)getActivity();
                Fragment fm=new ProtectiveFragment();
                hm.replaceFragment(fm);
            }
        });


        return view;


    }
}
