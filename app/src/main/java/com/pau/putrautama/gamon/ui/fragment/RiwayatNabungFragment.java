package com.pau.putrautama.gamon.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.TabunganAdapter;
import com.pau.putrautama.gamon.ui.adapter.TransaksiTabungAdapter;
import com.pau.putrautama.gamon.ui.model.TransaksiLangsung;
import com.pau.putrautama.gamon.ui.model.TransaksiTabung;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatNabungFragment extends Fragment {

    private RecyclerView mRVHistory;
    private ArrayList<TransaksiTabung> transaksiTabungs = new ArrayList<>();
    private TransaksiTabungAdapter adapter;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId,bankId;


    public RiwayatNabungFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat_nabung, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");


        loadData();
        mRVHistory = view.findViewById(R.id.rv_riwayat_nabung);
        adapter = new TransaksiTabungAdapter(getContext(), transaksiTabungs);
        mRVHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVHistory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void loadData(){
        userId = mAuth.getUid();
        mFirebaseDatabase.child(userId).child("tabung").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot tiapDataSnapshot:dataSnapshot.getChildren()) {
                    TransaksiTabung transaksiTabung = tiapDataSnapshot.getValue(TransaksiTabung.class);
                    transaksiTabungs.add(transaksiTabung);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


}
