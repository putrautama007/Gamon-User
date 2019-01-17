package com.pau.putrautama.gamon.ui.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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
import com.pau.putrautama.gamon.ui.adapter.BankAdapter;
import com.pau.putrautama.gamon.ui.model.BankList;
import com.pau.putrautama.gamon.ui.model.TransaksiTabung;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankFragment extends Fragment {

    private RecyclerView mRVBank;
    private ArrayList<BankList> bankLists = new ArrayList<>();
    private BankAdapter adapter;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;

    public BankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bank, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        setUpData();
        mRVBank = view.findViewById(R.id.rv_bank);
        adapter = new BankAdapter(getContext(),bankLists);
        mRVBank.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVBank.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpData(){
        userId = mAuth.getUid();
        mFirebaseDatabase.child(userId).child("bankSampah").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot tiapDataSnapshot:dataSnapshot.getChildren()) {
                    BankList bankList = tiapDataSnapshot.getValue(BankList.class);
                    bankLists.add(bankList);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
