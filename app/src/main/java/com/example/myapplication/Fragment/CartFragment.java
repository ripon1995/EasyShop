package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.HomeActivity;
import com.example.myapplication.R;

public class CartFragment extends Fragment {

    String location;
    TextView etPrice;
    TextView etQuantity;
    EditText etTotalPrice;

    Button btnAddMore;
    Button btnLess;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragmetnt_cart,container,false);
        etPrice=v.findViewById(R.id.tvPrice);
        etQuantity=v.findViewById(R.id.etQuantity);
        etTotalPrice=v.findViewById(R.id.etTotalPrice);
        btnAddMore=v.findViewById(R.id.btnAddMore);
        btnLess=v.findViewById(R.id.btnLess);

        location=getArguments().getString("medName");
        //String medicineName=getArguments().getString("medName");
        final String medicinePrice=getArguments().getString("medPrice");
       // Toast.makeText(getContext(),"MedicinePrice: "+medicinePrice,Toast.LENGTH_LONG).show();
        etPrice.setText(medicinePrice);
        etQuantity.setText("1");
        etTotalPrice.setText(medicinePrice);
        final int[] counter = {1};

        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter[0] += 1;
                int priceNow=counter[0]*Integer.valueOf(medicinePrice);
                String nowQuantity=Integer.toString(counter[0]);
                etQuantity.setText(nowQuantity);
                String latestPrice=Integer.toString(priceNow);
                etTotalPrice.setText(latestPrice);
            }
        });

        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter[0]-=1;
               if(counter[0]>=1)
               {
                   int priceNow=counter[0]*Integer.valueOf(medicinePrice);
                   String nowQuantity=Integer.toString(counter[0]);
                   etQuantity.setText(nowQuantity);
                   String latestPrice=Integer.toString(priceNow);
                   etTotalPrice.setText(latestPrice);
               }
               else
               {
                   Toast.makeText(getContext(),"Minimum Quantity 1",Toast.LENGTH_LONG).show();
                   counter[0]=1;
               }
            }
        });


        Button btn=v.findViewById(R.id.btnConfirmation);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(location=="medicine")
                {
                    HomeActivity hm=(HomeActivity)getActivity();
                    Fragment fm=new AccountFragment();
                    hm.replaceFragment(fm);
                }
                else if(location=="child")
                {
                    HomeActivity hm=(HomeActivity) getActivity();
                    Fragment fm=new ChildFragment();
                    hm.replaceFragment(fm);
                }
                else if(location=="protective")
                {
                    HomeActivity hm=(HomeActivity)getActivity();
                    Fragment fm=new ProtectiveFragment();
                    hm.replaceFragment(fm);
                }
                else if(location=="women")
                {
                    HomeActivity hm=(HomeActivity)getActivity();
                    Fragment fm=new WomenFragment();
                    hm.replaceFragment(fm);
                }
            }
        });
        return v;
    }
}
