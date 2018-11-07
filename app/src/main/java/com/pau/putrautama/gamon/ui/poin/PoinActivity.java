package com.pau.putrautama.gamon.ui.poin;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.ViewPagerAdapter;
import com.pau.putrautama.gamon.ui.model.User;
import com.pau.putrautama.gamon.ui.poin.Voucher.VoucherListFragment;
import com.pau.putrautama.gamon.ui.poin.Voucher.VoucherUserFragment;

public class PoinActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private SearchView mSearchViewVoucher;
    private TextView myPoin;
    ImageView mBack;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poin);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTabLayout = findViewById(R.id.tl_moovie);
        mViewPager = findViewById(R.id.vp_voucher);
        mSearchViewVoucher = findViewById(R.id.sv_voucher);
        myPoin = findViewById(R.id.my_poin);
        mBack = findViewById(R.id.back_poin);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());

        //add fragments
        viewPagerAdapter.addFragment(new VoucherListFragment(), getResources().getString(R.string.beli_voucher));
        viewPagerAdapter.addFragment(new VoucherUserFragment(), getResources().getString(R.string.voucher_saya));


        //setup Adapter
        mViewPager.setAdapter(viewPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void retriveData(){
        userId = mAuth.getUid();
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                myPoin.setText(String.valueOf(user.getPoin())+" P");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
