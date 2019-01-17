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
import com.pau.putrautama.gamon.ui.model.MendaftarUser;

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

     double latitude,longitude;
     String namaBank,alamatBank;
     boolean isMenerimaKertas,isMenerimaBotol;
     int hargaKertas,hargaPlastik;
     String idBankSampah;


    private ArrayList<MendaftarUser> mendaftarUsers = new ArrayList<>();



    public MapFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();

//            String getLatitude = bundle.getString("latitude");
//            String getLongitude = getArguments().getString("longitude");
//            Log.d("longitude", "onCreateView: " + getLatitude);
//        Log.d("lati", "onCreateView: " + getLongitude);



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
        mMap = googleMap;
        bankSampahMap = googleMap;

        googleMap.setOnMarkerClickListener(this);
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        bankSampah.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    BankSampah bankSampah1 = snapshot.getValue(BankSampah.class);
                    LatLng location=new LatLng(bankSampah1.getLatitude(),bankSampah1.getLongitude());
                     latitude = bankSampah1.getLatitude();
                    longitude = bankSampah1.getLongitude();
                    namaBank = bankSampah1.getNamaBankSampah();
                    alamatBank = bankSampah1.getAlamatBank();
                    isMenerimaKertas = bankSampah1.isMenerimaSampahKertas();
                    isMenerimaBotol = bankSampah1.isMenerimaSampahPlastik();
                    hargaKertas = bankSampah1.getHargaSampahKertas();
                    hargaPlastik = bankSampah1.getHargaSampahPlastik();
                    idBankSampah = snapshot.getKey();

                    Log.d("bank", "onDataChange: "+namaBank);


                    bankSampahMap.addMarker(new MarkerOptions().position(location)
                            .title(bankSampah1.getNamaBankSampah())
                            .icon(BitmapDescriptorFactory.fromResource(R.mipmap.pin)));
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        LatLng location = new LatLng(-8.796408, 115.176543);
        mMap.addMarker(new MarkerOptions().position(location).title("Anda disini").icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE)));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(location,16.0f) );

    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public boolean onMarkerClick(Marker marker)
    {
        Intent intent = new Intent(getContext(), DetailMapActivity.class);
        intent.putExtra("latitude",String.valueOf(latitude));
        intent.putExtra("longitude",String.valueOf(longitude));
        intent.putExtra("namabank",namaBank);
        intent.putExtra("alamatbank",alamatBank);
        intent.putExtra("menerimakertas",String.valueOf(isMenerimaKertas));
        intent.putExtra("menerimaplastik",String.valueOf(isMenerimaBotol));
        intent.putExtra("hargakertas",String.valueOf(hargaKertas));
        intent.putExtra("hargaplastik",String.valueOf(hargaPlastik));
        intent.putExtra("idbankSampah",idBankSampah);
        startActivity(intent);
        return true;
    }
}
