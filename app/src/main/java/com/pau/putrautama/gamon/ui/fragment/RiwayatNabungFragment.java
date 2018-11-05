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
import com.pau.putrautama.gamon.ui.adapter.TransaksiLangsungAdapter;
import com.pau.putrautama.gamon.ui.model.History;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatNabungFragment extends Fragment {

    private RecyclerView mRVHistory;
    private ArrayList<History> historyList = new ArrayList<>();
    private TransaksiLangsungAdapter adapter;


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

        setUpData();
//        mRVHistory = view.findViewById(R.id.rv_riwayat_nabung);
//        adapter = new TransaksiLangsungAdapter(getContext(),historyList);
//        mRVHistory.setLayoutManager(new LinearLayoutManager(getContext()));
//        mRVHistory.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    private void setUpData(){
        historyList.add(new History("Bank Sampah Sumber Jaya",
                "Jl. Cempaka 2 No. 16 Malang, Jawa Timur",
                "21 Oktober 2018 | 14:32",110,"John Doe",
                4,2,6000,5000,11000));

        historyList.add(new History("Bank Sampah Sumber Jaya",
                "Jl. Cempaka 2 No. 16 Malang, Jawa Timur",
                "19 Oktober 2018 2018 | 10:32"
               ,80,"John Doe",
                2,2,3000,
                2000,8000));
    }
}
