package com.pau.putrautama.gamon.ui.fragment;


import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.location.LocationListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.map.DetailMapActivity;
import com.pau.putrautama.gamon.ui.model.BankSampah;
import com.pau.putrautama.gamon.ui.model.MapList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class MapFragment extends Fragment implements OnMapReadyCallback,
        LocationListener, GoogleMap.OnMarkerClickListener {

    SupportMapFragment supportMapFragment;
    private GoogleMap mMap, bankSampahMap;
    private ChildEventListener mChildEventListener;
    View mView;
    private DatabaseReference bankSampah;
    private FirebaseDatabase firebaseDatabase;

    Marker marker;



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
        ChildEventListener mChildEventListener;
        firebaseDatabase = FirebaseDatabase.getInstance();
        bankSampah= firebaseDatabase.getReference("banksampah");
        bankSampah.push().setValue(marker);
    }



    @Override
    public void onMapReady(GoogleMap googleMap) {
//        mMap = googleMap;
        bankSampahMap = googleMap;

        googleMap.setOnMarkerClickListener(this);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        bankSampah.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    BankSampah bankSampah1 = snapshot.getValue(BankSampah.class);
                    LatLng location=new LatLng(bankSampah1.getLatitude(),bankSampah1.getLongitude());
                    bankSampahMap.addMarker(new MarkerOptions().position(location)
                            .title(bankSampah1.getNamaBankSampah())
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin)));

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return false;
    }
}
