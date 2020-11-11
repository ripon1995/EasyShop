package com.example.myapplication.Fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.Random;

public class OnlineShoppingFragment extends Fragment {

    Button btnAmazon,btnFlipCart,btnWalmart,btnAdd;
    EditText etLink;
    private StorageReference mStorageRef;


    private FirebaseAuth mAuth;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_onlineshop,container,false);
        btnAmazon=view.findViewById(R.id.amazon);
        btnFlipCart=view.findViewById(R.id.flipcart);
        btnWalmart=view.findViewById(R.id.wallmart);
        btnAdd=view.findViewById(R.id.btnNext);
        etLink=view.findViewById(R.id.etLink);

        mAuth = FirebaseAuth.getInstance();
        mStorageRef = FirebaseStorage.getInstance().getReference();

        //Toast.makeText(getContext(),mAuth.getCurrentUser().getUid(),Toast.LENGTH_LONG).show();

        btnAmazon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.amazon.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });

        btnWalmart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.walmart.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });
        btnFlipCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://www.flipkart.com/";
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);

            }
        });


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random r = new Random();
                int i1 = r.nextInt(80 - 65) + 65;
                String s="Ord"+(i1);
                String str=etLink.getText().toString();
                String id=mAuth.getCurrentUser().getUid();
                FirebaseDatabase database=FirebaseDatabase.getInstance();
                DatabaseReference databaseReference=database.getReference();
                databaseReference.child("Orders").child(id).child("Link").setValue(str);
                databaseReference.child("Orders").child(id).child("Price").setValue("0");
                databaseReference.child("Orders").child(id).child("Quantity").setValue("0");
                databaseReference.child("Orders").child(id).child("TotalPrice").setValue("0");

                etLink.setText("");
                Toast.makeText(getContext(),"Item added",Toast.LENGTH_LONG).show();
                //databaseReference.child("Orders").child(id).child(s).child("Link").setValue(str);
                //databaseReference.child("Orders").child(id).child(s).child("Code").setValue("ZERO");
            }
        });


        return view;
    }
}
