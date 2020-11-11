package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.myapplication.Model.Protective;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ProtectiveViewAdapter extends ArrayAdapter<Protective> {
    private Context context;
    private ArrayList<Protective>protectiveArrayList;
    public ProtectiveViewAdapter(@NonNull Context context, ArrayList<Protective>protectiveArrayList) {
        super(context, 0,protectiveArrayList);
        this.context=context;
        this.protectiveArrayList=protectiveArrayList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view=convertView;
        if(view==null)
        {
            LayoutInflater layoutInflater=LayoutInflater.from(getContext());
            view=layoutInflater.inflate(R.layout.protective_item_row,parent,false);
        }
        Protective protective=protectiveArrayList.get(position);
        ImageView imageView=view.findViewById(R.id.imgViewProtective);
        TextView com=view.findViewById(R.id.tvCompanyProtective);
        TextView pri=view.findViewById(R.id.tvPriceProtective);

        imageView.setImageResource(protective.getImgProtective());
        com.setText("Company: "+protective.getProtectiveCompany());
        pri.setText("Price: "+protective.getProtectivePrice());
        return view;
    }
}
