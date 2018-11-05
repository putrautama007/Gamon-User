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

        setUpData();
        mRVVoucer = view.findViewById(R.id.rv_voucher_list);
        adapter = new VoucherAdapter(getContext(),voucherLists);
        mRVVoucer.setLayoutManager(new LinearLayoutManager(getContext()));
        mRVVoucer.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpData(){
        int [] fotoVoucher = new int[]{
                R.drawable.iw,
                R.drawable.alfimart,
                R.drawable.alfimartt
        };
        voucherLists.add(new VoucherList("Voucher Infinity War",
                fotoVoucher[0],400 ,"Gratis 1 tiket film Infinity War berlaku setiap hari Senin - Jumat !"
                ,"Voucher yang telah dibeli hanya berlaku hingga 30 hari",
                "Voucher hanya berlaku di seluruh Bioskop Kota Malang",
                "Tombol ‘Gunakan Voucher’ hanya digunakan untuk petugas",
                "Tukar voucher pada petugas bioskop","Transaksi selesai !"));
        voucherLists.add(new VoucherList("Voucher Infinity War",
                fotoVoucher[1],1500 ,"Gratis 1 voucher belanaj Rp. 100.000 di Alfmart berlaku setiap hari Senin - Jumat !"
                ,"Voucher yang telah dibeli hanya berlaku hingga 30 hari",
                "Voucher hanya berlaku di seluruh Alfmart Kota Malang",
                "Tombol ‘Gunakan Voucher’ hanya digunakan untuk petugas",
                "Tukar voucher pada petugas Alfamart","Transaksi selesai !"));
    }
}
