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

import com.example.myapplication.Adapter.MedicineViewAdapter;
import com.example.myapplication.HomeActivity;
import com.example.myapplication.Model.Medicines;
import com.example.myapplication.R;

import java.util.ArrayList;

public class AccountFragment extends Fragment {

    private ListView listView;
    private MedicineViewAdapter medicineViewAdapter;
    ArrayList<Medicines>medArray=new ArrayList<Medicines>();

    Medicines m1=new Medicines("Napa","Beximco","100");
    Medicines m2=new Medicines("Histacin","Incepta","200");
    Medicines m3=new Medicines("Eye drop","Opsonin","300");
    Medicines m4=new Medicines("Ivera 12","Beximco","400");
    Medicines m5=new Medicines("D-Rise 20000","Incepta","500");
    Medicines m6=new Medicines("Xinc-B","Opsonin","600");

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_account,container,false);
        listView=view.findViewById(R.id.list);
        medArray.add(m1);
        medArray.add(m2);
        medArray.add(m3);
        medArray.add(m4);
        medArray.add(m5);
        medArray.add(m6);
        medicineViewAdapter = new MedicineViewAdapter(getContext(),medArray);
        listView.setAdapter(medicineViewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Medicines m=medArray.get(position);
                HomeActivity hm=(HomeActivity)getActivity();
                Fragment fm=new CartFragment();
                Bundle bundle=new Bundle();
                bundle.putString("medName","medicine");
                //bundle.putString("medName",m.getMedPrice());
                bundle.putString("medPrice",m.getMedPrice());
                fm.setArguments(bundle);
                hm.replaceFragment(fm);

            }
        });

        return view;
    }


}
