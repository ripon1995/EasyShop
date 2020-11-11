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

import com.example.myapplication.Adapter.ProtectiveViewAdapter;
import com.example.myapplication.HomeActivity;
import com.example.myapplication.Model.Protective;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ProtectiveFragment extends Fragment {

    private ListView listView;
    private ProtectiveViewAdapter protectiveViewAdapter;
    ArrayList<Protective>protectiveArray=new ArrayList<Protective>();

    Protective p1=new Protective(R.drawable.cat3,"NNNN","100");
    Protective p2=new Protective(R.drawable.cat2,"MMMM","200");
    Protective p3=new Protective(R.drawable.cat1,"XXXX","300");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_protective,container,false);
        listView=view.findViewById(R.id.protectiveList);
        protectiveArray.add(p1);
        protectiveArray.add(p2);
        protectiveArray.add(p3);
        protectiveViewAdapter=new ProtectiveViewAdapter(getContext(),protectiveArray);
        listView.setAdapter(protectiveViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Protective protective=protectiveArray.get(position);
                HomeActivity hm=(HomeActivity)getActivity();
                Fragment fm=new CartFragment();
                Bundle bundle=new Bundle();
                //bundle.putString("medName",protective.getProtectiveCompany());
                bundle.putString("medName","protective");
                bundle.putString("medPrice",protective.getProtectivePrice());
                fm.setArguments(bundle);
                hm.replaceFragment(fm);
            }
        });
        return view;

    }
}
