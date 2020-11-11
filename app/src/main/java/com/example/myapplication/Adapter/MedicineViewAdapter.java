package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Model.Medicines;
import com.example.myapplication.R;

import java.util.ArrayList;

public class MedicineViewAdapter extends ArrayAdapter<Medicines> {

    private Context context;
    private ArrayList<Medicines>list;///change

    public MedicineViewAdapter(@NonNull Context context, ArrayList<Medicines> list) {
        super(context, 0,list);
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view=convertView;
        if(view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            view=layoutInflater.inflate(R.layout.myrow,parent,false);
        }

        Medicines currentMedicine=list.get(position);
        TextView name=view.findViewById(R.id.medicineName);
        TextView cell=view.findViewById(R.id.medicineCompany);
        TextView price=view.findViewById(R.id.medicinePrice);
        name.setText(currentMedicine.getName());
        cell.setText(currentMedicine.getCompanyName());
        price.setText(currentMedicine.getMedPrice());
        return view;

    }
}
