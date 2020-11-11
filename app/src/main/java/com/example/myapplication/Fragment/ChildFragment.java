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

import com.example.myapplication.Adapter.ChildViewAdapter;
import com.example.myapplication.HomeActivity;
import com.example.myapplication.Model.Child;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ChildFragment extends Fragment {

    private ListView listView;
    private ChildViewAdapter childViewAdapter;
    ArrayList<Child> childArray=new ArrayList<Child>();

    Child child1=new Child(R.drawable.cat1,"Persian","100");
    Child child2=new Child(R.drawable.cat2,"Desi","200");
    Child child3=new Child(R.drawable.cat3,"Bideshi","300");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_child,container,false);
        ListView listView=view.findViewById(R.id.childList);
        childArray.add(child1);
        childArray.add(child2);
        childArray.add(child3);
        childViewAdapter=new ChildViewAdapter(getContext(),childArray);
        listView.setAdapter(childViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Child child=childArray.get(position);
                HomeActivity hm=(HomeActivity)getActivity();
                Fragment fm=new CartFragment();
                Bundle bundle=new Bundle();
                bundle.putString("medName","child");
                bundle.putString("medPrice",child.getChildPrice());
                fm.setArguments(bundle);
                hm.replaceFragment(fm);
            }
        });
        return view;
    }
}
