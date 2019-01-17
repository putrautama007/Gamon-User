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

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.VoucherAdapter;
import com.pau.putrautama.gamon.ui.model.VoucherList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class VoucherListFragment extends Fragment {

    private RecyclerView mRVVoucer;
    private ArrayList<VoucherList> voucherLists = new ArrayList<>();
    private VoucherAdapter adapter;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;


    public VoucherListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_voucher_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("poin");


        loadDataPoin();
        mRVVoucer = view.findViewById(R.id.rv_voucher_list);
        adapter = new VoucherAdapter(getContext(),voucherLists);
        mRVVoucer.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVVoucer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void loadDataPoin(){
        mFirebaseDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot tiapDataSnapshot:dataSnapshot.getChildren()) {
                    VoucherList voucherList = tiapDataSnapshot.getValue(VoucherList.class);
                    voucherLists.add(voucherList);
                }
                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
