package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.Adapter.WomenViewAdapter;
import com.example.myapplication.HomeActivity;
import com.example.myapplication.Model.Women;
import com.example.myapplication.R;

import java.util.ArrayList;

public class WomenFragment extends Fragment {
    private ListView listView;
    private WomenViewAdapter womenViewAdapter;

    ArrayList<Women>womenArray=new ArrayList<Women>();

    Women w1=new Women(R.drawable.cat1,"Desi","100");
    Women w2=new Women(R.drawable.cat2,"Persian","200");
    Women w3=new Women(R.drawable.cat3,"German","300");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_women,container,false);
        listView=view.findViewById(R.id.womenList);
        womenArray.add(w2);
        womenArray.add(w3);
        womenArray.add(w1);
        womenViewAdapter=new WomenViewAdapter(getContext(),womenArray);
        listView.setAdapter(womenViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Women women=womenArray.get(position);
                HomeActivity hm=(HomeActivity)getActivity();
                Fragment fm=new CartFragment();
                Bundle bundle=new Bundle();
                //bundle.putString("medName",women.getWomenCompany());
                bundle.putString("medName","women");
                bundle.putString("medPrice",women.getWomenPrice());
                fm.setArguments(bundle);
                hm.replaceFragment(fm);
            }
        });
        return view;
    }
}
