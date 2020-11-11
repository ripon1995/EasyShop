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

import com.example.myapplication.Model.Women;
import com.example.myapplication.R;

import java.util.ArrayList;

public class WomenViewAdapter extends ArrayAdapter<Women> {

    private Context context;
    private ArrayList<Women>list;
    public WomenViewAdapter(@NonNull Context context, ArrayList<Women>list) {
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
            view=layoutInflater.inflate(R.layout.women_item_row,parent,false);
        }

        Women women=list.get(position);
        ImageView img=view.findViewById(R.id.imgViewWomen);
        TextView com=view.findViewById(R.id.tvCompanyWomen);
        TextView pri=view.findViewById(R.id.tvPriceWomen);

        img.setImageResource(women.getWomenImg());
        com.setText("Company: "+women.getWomenCompany());
        pri.setText("Price: "+women.getWomenPrice());
        return view;
    }
}
