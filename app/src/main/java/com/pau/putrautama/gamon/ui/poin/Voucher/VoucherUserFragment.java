package com.pau.putrautama.gamon.ui.poin.Voucher;


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
import com.pau.putrautama.gamon.ui.adapter.VoucherAdapter;
import com.pau.putrautama.gamon.ui.adapter.VoucherUserAdapter;
import com.pau.putrautama.gamon.ui.model.VoucherList;
import com.pau.putrautama.gamon.ui.model.VoucherListUser;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoucherUserFragment extends Fragment {

    private RecyclerView mRVVoucer;
    private ArrayList<VoucherListUser> voucherListUsers = new ArrayList<>();
    private VoucherUserAdapter adapter;

    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    String userId;

    public VoucherUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voucher_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        loadDataVoucher();
        mRVVoucer = view.findViewById(R.id.rv_voucher_user);
        adapter = new VoucherUserAdapter(getContext(),voucherListUsers);
        mRVVoucer.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVVoucer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void loadDataVoucher(){
        userId = mAuth.getUid();
        mFirebaseDatabase.child(userId).child("voucher").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot tiapDataSnapshot:dataSnapshot.getChildren()) {
                    VoucherListUser voucherList = tiapDataSnapshot.getValue(VoucherListUser.class);
                    voucherListUsers.add(voucherList);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
