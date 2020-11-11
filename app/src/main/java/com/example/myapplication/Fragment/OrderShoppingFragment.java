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

import com.example.myapplication.DashBoard;
import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class OrderShoppingFragment extends Fragment {

    Button btn,btnAddMore,btnLess;
    String url;
    EditText totalPrice;
    TextView tvPrice,quantity;

    private FirebaseAuth mAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.order_shopping_fragment,container,false);
        btn=view.findViewById(R.id.btnConfirmation);
        btnAddMore=view.findViewById(R.id.btnAddMore);
        btnLess=view.findViewById(R.id.btnLess);
        tvPrice=view.findViewById(R.id.tvPrice);
        totalPrice=view.findViewById(R.id.etTotalPrice);
        quantity=view.findViewById(R.id.tvQuantity);
        mAuth = FirebaseAuth.getInstance();
        final String link=mAuth.getCurrentUser().getUid();
        FirebaseDatabase database=FirebaseDatabase.getInstance();
        final String[] price = {""};
        final DatabaseReference databaseReference=database.getReference("Orders").child(link);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                url=dataSnapshot.child("Price").getValue().toString();
                tvPrice.setText(url);
                totalPrice.setText(url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Toast.makeText(getContext(),price[0],Toast.LENGTH_LONG).show();
        final int[] counter = {1};

        btnAddMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(url!="000")
               {
                   counter[0] += 1;
                   int priceNow=counter[0]*Integer.valueOf(url);
                   String nowQuantity=Integer.toString(counter[0]);
                   quantity.setText(nowQuantity);
                   String latestPrice=Integer.toString(priceNow);
                   totalPrice.setText(latestPrice);
               }
            }
        });

        btnLess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter[0]-=1;
                if(counter[0]>=1)
                {
                    if(url!="000")
                    {
                        int priceNow=counter[0]*Integer.valueOf(url);
                        String nowQuantity=Integer.toString(counter[0]);
                        quantity.setText(nowQuantity);
                        String latestPrice=Integer.toString(priceNow);
                        totalPrice.setText(latestPrice);
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Minimum Quantity 1",Toast.LENGTH_LONG).show();
                    counter[0]=1;
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random r = new Random();
                int i1 = r.nextInt(80 - 65) + 65;

                FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference1=firebaseDatabase.getReference();
                databaseReference1.child("Orders").child(link).child("Quantity").setValue(quantity.getText().toString());
                databaseReference1.child("Orders").child(link).child("TotalPrice").setValue(totalPrice.getText().toString());
                Toast.makeText(getContext(), "Order confirmed",Toast.LENGTH_LONG).show();


                DashBoard dashBoard=(DashBoard)getActivity();
                Fragment fm=new OnlineShoppingFragment();
                dashBoard.replaceFragment(fm);

            }
        });


        return view;

    }
}
