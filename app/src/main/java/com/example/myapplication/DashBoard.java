package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication.Fragment.DiscoverFragment;
import com.example.myapplication.Fragment.OnlineShoppingFragment;
import com.example.myapplication.Fragment.OrderShoppingFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

public class DashBoard extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        ChipNavigationBar chipNavigationBar=findViewById(R.id.menu_bottom);
        chipNavigationBar.setOnItemSelectedListener(listener);
        Fragment fm=new OnlineShoppingFragment();
        replaceFragment(fm);
        int i=chipNavigationBar.getSelectedItemId();


    }
    public ChipNavigationBar.OnItemSelectedListener listener=new ChipNavigationBar.OnItemSelectedListener() {
        @Override
        public void onItemSelected(int i) {

            Fragment selectedFragment=null;
            switch (i)
            {
                case R.id.home:
                    selectedFragment=new OnlineShoppingFragment();
                    break;
                case R.id.account:
                    selectedFragment=new DiscoverFragment();
                    break;
                case R.id.order:
                    selectedFragment =new OrderShoppingFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,selectedFragment).commit();

        }
    };
    public void replaceFragment(Fragment destFragment)
    {
        // First get FragmentManager object.
        FragmentManager fragmentManager = this.getSupportFragmentManager();

        // Begin Fragment transaction.
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Replace the layout holder with the required Fragment object.
        fragmentTransaction.replace(R.id.fragmentContainer, destFragment);

        // Commit the Fragment replace action.
        fragmentTransaction.commit();
    }

    public void removeFragment()
    {
        FragmentManager fm=this.getSupportFragmentManager();
        Fragment cur=fm.findFragmentById(R.id.fragmentContainer);
        FragmentTransaction ft=fm.beginTransaction();
        ft.remove(cur);
        ft.commit();

    }
}
