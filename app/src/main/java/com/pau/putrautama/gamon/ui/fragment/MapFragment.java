package com.pau.putrautama.gamon.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.map.DetailMapActivity;
import com.pau.putrautama.gamon.ui.model.MapList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback {

    SupportMapFragment supportMapFragment;
    private GoogleMap mMap, bankSampahMap;
    View mView;


    private ArrayList<MapList> mapLists = new ArrayList<>();



    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_map, container, false);

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        supportMapFragment.getMapAsync(this);
//        setUpData();
    }

    private void setUpData() {
        mapLists.add(new MapList("Bank Sampah Sumber Jaya","","Jl. Cempaka 2 No. 16 Malang, Jawa Timur","08.00 - 17.00"
                ,"-7.956604,112.631854",true,true,1500,2500));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        bankSampahMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng location = new LatLng(-7.958965, 112.632926);
//        mMap.addMarker(new MarkerOptions().position(location).title("Anda disini"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,16.0f) );

        LatLng bankSampahLocation = new LatLng(-7.956604, 112.631854);
        bankSampahMap.addMarker(new MarkerOptions().position(bankSampahLocation).icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin)));
        bankSampahMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                Intent intent = new Intent(getContext(), DetailMapActivity.class);
//                intent.putExtra(DetailMapActivity.ITEM_MAP,mapLists);
                startActivity(intent);

                return true;
            }
        });
    }
}
