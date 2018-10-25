package com.pau.putrautama.gamonbanksampah;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.pau.putrautama.gamonbanksampah.Akun.AkunFragment;
import com.pau.putrautama.gamonbanksampah.fragment.BerandaFragment;
import com.pau.putrautama.gamonbanksampah.fragment.RiwayatFragment;
import com.pau.putrautama.gamonbanksampah.fragment.TransaksiFragment;

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
        loadFragment(new BerandaFragment());

        //selected bottom bar
        selectBottomBar();
    }

    private void setBottomBar() {
        // Create items
        AHBottomNavigationItem beranda = new AHBottomNavigationItem(R.string.beranda, R.drawable.gamon_icon_black, R.color.bottom_nav_green);
        AHBottomNavigationItem transaksi = new AHBottomNavigationItem(R.string.transaksi, R.drawable.ic_receipt, R.color.bottom_nav_green);
        AHBottomNavigationItem riwayat = new AHBottomNavigationItem(R.string.riwayat, R.drawable.ic_history, R.color.bottom_nav_green);
        AHBottomNavigationItem akun = new AHBottomNavigationItem(R.string.akun, R.drawable.ic_person, R.color.bottom_nav_green);

        // Add items
        mBottomNavigation.addItem(beranda);
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
                        fragment= new BerandaFragment();
                        break;
                    case 1:
                        fragment = new TransaksiFragment();
                        break;
                    case 2:
                        fragment = new RiwayatFragment();
                        break;
                    case 3:
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
