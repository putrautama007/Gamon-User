package com.pau.putrautama.gamonbanksampah.fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pau.putrautama.gamonbanksampah.R;
import com.pau.putrautama.gamonbanksampah.adapter.HistoryAdapter;
import com.pau.putrautama.gamonbanksampah.model.HistoryList;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {

    private RecyclerView mRVHistory;
    private ArrayList<HistoryList> historyList = new ArrayList<>();
    private HistoryAdapter adapter;


    public RiwayatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_riwayat, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpData();
        mRVHistory = view.findViewById(R.id.rv_riwayat);
        adapter = new HistoryAdapter(getContext(),historyList);
        mRVHistory.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVHistory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpData() {
        historyList.add(new HistoryList("John Doe","Bank Sampah Sumber Jaya",38271,"02 Agustus 2018 | 14:32",
                4,2,6000,5000,11000));
    }
}
