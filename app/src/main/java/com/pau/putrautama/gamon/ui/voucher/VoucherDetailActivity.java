package com.pau.putrautama.gamon.ui.voucher;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.User;
import com.pau.putrautama.gamon.ui.model.VoucherList;
import com.pau.putrautama.gamon.ui.model.VoucherListUser;
import com.pau.putrautama.gamon.ui.poin.PoinActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VoucherDetailActivity extends AppCompatActivity {

    TextView mjudulVoucher,mPoin,mDeskripsi,mSyarat1,mSyarat2,mSyarat3,mSyarat4,mSyarat5;
    ImageView mImageVoucher;
    Button mBtnBeli;
    ImageView mBack;

    private VoucherList voucherList;
    private VoucherListUser voucherListUser;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private FirebaseAuth mAuth;
    String userId,saveCurrentDate, saveCurrentTime,tglBeliVoucher;
    int poinUser;

    public static final String ITEM_VOUCHER = "item_voucher";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voucher_detail);

        mjudulVoucher = findViewById(R.id.judul_voucher);
        mPoin = findViewById(R.id.poin_voucher);
        mDeskripsi = findViewById(R.id.deskripsi_voucer);
        mSyarat1 = findViewById(R.id.syarat1);
        mSyarat2 = findViewById(R.id.syarat2);
        mSyarat3 = findViewById(R.id.syarat3);
        mSyarat4 = findViewById(R.id.syarat4);
        mSyarat5 = findViewById(R.id.syarat5);
        mImageVoucher = findViewById(R.id.voucher_image);
        mBtnBeli = findViewById(R.id.btn_buy_voucher);
        mBack = findViewById(R.id.back_voucher);


        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        retriveUserData();
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        voucherList = (VoucherList) getIntent().getSerializableExtra(ITEM_VOUCHER);
        mjudulVoucher.setText(voucherList.getJudulVoucher());
        String poin = Integer.toString(voucherList.getPoinVoucher());
        Glide.with(this).load(voucherList.getGambarVoucher()).into(mImageVoucher);
        mPoin.setText(poin+"P");
        mDeskripsi.setText(voucherList.getDeskripsi());
        mSyarat1.setText(voucherList.getSyarat1());
        mSyarat2.setText(voucherList.getSyarat2());
        mSyarat3.setText(voucherList.getSyarat3());
        mSyarat4.setText(voucherList.getSyarat4());
        mSyarat5.setText(voucherList.getSyarat5());

        mBtnBeli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buyVoucher();

            }
        });
    }


    private void retriveUserData(){
        userId = mAuth.getUid();
        mFirebaseDatabase.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                poinUser = user.getPoin();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    private void buyVoucher(){
        userId = mAuth.getUid();

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("ddmmmyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HHmmss");
        saveCurrentTime = currentTime.format(calendar.getTime());


        tglBeliVoucher = saveCurrentDate+saveCurrentTime;

        String judulVoucher= voucherList.getJudulVoucher();
        String gambarVoucher= voucherList.getGambarVoucher();
        int poinVoucher = voucherList.getPoinVoucher();
        String deskripsi= voucherList.getDeskripsi();
        String syarat1= voucherList.getJudulVoucher();
        String syarat2= voucherList.getJudulVoucher();
        String syarat3= voucherList.getJudulVoucher();
        String syarat4= voucherList.getJudulVoucher();
        String syarat5= voucherList.getJudulVoucher();
        String statusVoucher = "true";

        int sisaPoinUser = poinUser-poinVoucher;

        if (poinUser >= poinVoucher) {
            voucherListUser = new VoucherListUser(judulVoucher, gambarVoucher, tglBeliVoucher, poinVoucher, deskripsi,
                    syarat1, syarat2, syarat3, syarat4, syarat5, statusVoucher);

            mFirebaseDatabase.child(userId).child("voucher").child(tglBeliVoucher).setValue(voucherList);

            mFirebaseDatabase.child(userId).child("poin").setValue(sisaPoinUser);

            Toast.makeText(VoucherDetailActivity.this, "Voucher Berhasil Dibeli", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(VoucherDetailActivity.this,PoinActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(VoucherDetailActivity.this, "Poin yang anda miliki tidak cukup", Toast.LENGTH_SHORT).show();
        }
    }
}
