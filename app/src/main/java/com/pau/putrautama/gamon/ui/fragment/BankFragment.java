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

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.BankAdapter;
import com.pau.putrautama.gamon.ui.model.BankList;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BankFragment extends Fragment {

    private RecyclerView mRVBank;
    private ArrayList<BankList> bankLists = new ArrayList<>();
    private BankAdapter adapter;


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

        setUpData();
        mRVBank = view.findViewById(R.id.rv_bank);
        adapter = new BankAdapter(getContext(),bankLists);
        mRVBank.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVBank.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpData(){

//        int [] fotobank = new int[]{
//                R.drawable.fotobanksampah,
//
//        };
//
//        bankLists.add(new BankList(fotobank[0],"Bank Sampah Sumber Jaya",
//                "Jl. Cempaka 2 No. 16 Malang, Jawa Timur",
//                30000, "21-Oktober-2018"));
    }

}
