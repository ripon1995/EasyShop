package com.example.myapplication.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DiscoverFragment extends Fragment {

    TextView tvName,tvPrice,tvTotalPrice,tvQuantity;

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_discover, container, false);
        tvName=view.findViewById(R.id.tvName);
        tvPrice=view.findViewById(R.id.tvPrice);
        tvTotalPrice=view.findViewById(R.id.tvTotalPrice);
        tvQuantity=view.findViewById(R.id.tvQuantity);

        mAuth = FirebaseAuth.getInstance();
        final String link=mAuth.getCurrentUser().getUid();

        FirebaseDatabase database=FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=database.getReference("Orders").child(link);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("Link").getValue().toString();
                String price=dataSnapshot.child("Price").getValue().toString();
                String quantity=dataSnapshot.child("Quantity").getValue().toString();
                String totalPrice=dataSnapshot.child("TotalPrice").getValue().toString();

                tvName.setText(name);
                tvPrice.setText(price);
                tvTotalPrice.setText(totalPrice);
                tvQuantity.setText(quantity);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }
}
