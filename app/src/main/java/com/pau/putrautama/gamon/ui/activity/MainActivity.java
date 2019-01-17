package com.pau.putrautama.gamon.ui.activity;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.fragment.AkunFragment;
import com.pau.putrautama.gamon.ui.fragment.BankFragment;
import com.pau.putrautama.gamon.ui.fragment.MapFragment;
import com.pau.putrautama.gamon.ui.fragment.TransaksiFragment;
import com.pau.putrautama.gamon.ui.riwayat.RiwayatFragment;

public class MainActivity extends AppCompatActivity implements LocationListener {
    AHBottomNavigation mBottomNavigation;

    private LocationManager locationManager;
    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private double gpsLatitude, gpsLongitude;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBottomNavigation = findViewById(R.id.bottom_navigation);

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        if(checkLocationPermission()){
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
        }


        //set bottom bar
        setBottomBar();

        // Set current item programmatically
//        loadFragment(new MapFragment());
        oadMapFragment();

        //selected bottom bar
        selectBottomBar();

    }

    private boolean checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_LOCATION);
            }
            return false;
        } else {
            return true;
        }
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
//                        String latitude = String.valueOf(gpsLatitude);
//                        String longitude = String.valueOf(gpsLongitude);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("latitude",latitude);
//                        bundle.putString("longitude",longitude);
                        fragment= new MapFragment();
//                        fragment.setArguments(bundle);
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

    private void oadMapFragment(){
        Fragment fragment = new MapFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        String latitude = String.valueOf(gpsLatitude);
        String longitude = String.valueOf(gpsLongitude);
        Bundle bundle = new Bundle();
        bundle.putString("latitude",latitude);
        bundle.putString("longitude",longitude);
        fragment.setArguments(bundle);
        ft.replace(R.id.fragment_container, fragment);
        ft.commit();
        Log.d("asu", "oadMapFragment: " +latitude);
    }

    @Override
    public void onLocationChanged(Location location) {
        gpsLatitude = location.getLatitude();
        gpsLongitude = location.getLongitude();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                    }
                } else {
                    Toast.makeText(this, "permission denied", Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }
}
