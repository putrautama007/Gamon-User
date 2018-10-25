package com.pau.putrautama.gamon.ui.riwayat;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.BankAdapter;
import com.pau.putrautama.gamon.ui.adapter.ViewPagerAdapter;
import com.pau.putrautama.gamon.ui.fragment.RiwayatLangsungFragment;
import com.pau.putrautama.gamon.ui.fragment.RiwayatNabungFragment;
import com.pau.putrautama.gamon.ui.poin.Voucher.VoucherListFragment;
import com.pau.putrautama.gamon.ui.poin.Voucher.VoucherUserFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class RiwayatFragment extends Fragment {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;


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

        mTabLayout = view.findViewById(R.id.tl_riwayat);
        mViewPager = view.findViewById(R.id.vp_riwayat);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());

        //add fragments
        viewPagerAdapter.addFragment(new RiwayatLangsungFragment(), getString(R.string.tarik_langsung));
        viewPagerAdapter.addFragment(new RiwayatNabungFragment(), getString(R.string.tabung));

        //setup Adapter
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }
}
