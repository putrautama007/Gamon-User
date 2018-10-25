package com.pau.putrautama.gamon.ui.activity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.fragment.AkunFragment;
import com.pau.putrautama.gamon.ui.fragment.BankFragment;
import com.pau.putrautama.gamon.ui.fragment.MapFragment;
import com.pau.putrautama.gamon.ui.fragment.RiwayatLangsungFragment;
import com.pau.putrautama.gamon.ui.fragment.TransaksiFragment;
import com.pau.putrautama.gamon.ui.riwayat.RiwayatFragment;

public class MainActivity extends AppCompatActivity {
    AHBottomNavigation mBottomNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigation = findViewById(R.id.bottom_navigation);


        //set bottom bar
        setBottomBar();

        // Set current item programmatically
        loadFragment(new MapFragment());

        //selected bottom bar
        selectBottomBar();

    }

    private void setBottomBar(){
        // Create items
        AHBottomNavigationItem beranda = new AHBottomNavigationItem(R.string.beranda, R.drawable.gamon_icon_black, R.color.bottom_nav_green);
        AHBottomNavigationItem bank = new AHBottomNavigationItem(R.string.bank_sampah,R.drawable.logo_black,R.color.bottom_nav_green);
        AHBottomNavigationItem transaksi = new AHBottomNavigationItem(R.string.transaksi, R.drawable.ic_receipt, R.color.bottom_nav_green);
        AHBottomNavigationItem riwayat = new AHBottomNavigationItem(R.string.riwayat, R.drawable.ic_history, R.color.bottom_nav_green);
        AHBottomNavigationItem akun = new AHBottomNavigationItem(R.string.akun, R.drawable.ic_person, R.color.bottom_nav_green);

        // Add items
        mBottomNavigation.addItem(beranda);
        mBottomNavigation.addItem(bank);
        mBottomNavigation.addItem(transaksi);
        mBottomNavigation.addItem(riwayat);
        mBottomNavigation.addItem(akun);

        // Set background color
        mBottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.bottom_nav_green));

        // Manage titles
        mBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);

        // Change colors
        mBottomNavigation.setAccentColor(getResources().getColor(R.color.colorPrimaryDark));
        mBottomNavigation.setInactiveColor(getResources().getColor(R.color.inactive_button));
    }

    private void selectBottomBar(){
        mBottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {
                Fragment fragment = null;
                switch (position){
                    case 0:
                        fragment= new MapFragment();
                        break;
                    case 1:
                        fragment = new BankFragment();
                        break;
                    case 2:
                        fragment = new TransaksiFragment();
                        break;
                    case 3:
                        fragment = new RiwayatFragment();

                        break;
                    case 4:
                        fragment = new AkunFragment();
                        break;
                }
                return loadFragment(fragment);
            }
        });
    }

    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment_container, fragment);
            ft.commit();
            return true;
        }
        return false;
    }

}
