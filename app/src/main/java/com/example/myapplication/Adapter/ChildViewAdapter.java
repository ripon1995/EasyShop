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

import com.example.myapplication.Model.Child;
import com.example.myapplication.R;

import java.util.ArrayList;

public class ChildViewAdapter  extends ArrayAdapter<Child> {

    private Context context;
    private ArrayList<Child> list;///change

    public ChildViewAdapter(@NonNull Context context, ArrayList<Child> list) {
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
            view=layoutInflater.inflate(R.layout.child_item_row,parent,false);
        }

        Child child=list.get(position);
        ImageView img=view.findViewById(R.id.imgViewChild);
        TextView company=view.findViewById(R.id.tvCompanyChild);
        TextView price=view.findViewById(R.id.tvPriceChild);
        img.setImageResource(child.getChildPic());
        company.setText("Company: "+child.getChildCompany());
        price.setText("Price: "+child.getChildPrice());
        return view;
    }
}
