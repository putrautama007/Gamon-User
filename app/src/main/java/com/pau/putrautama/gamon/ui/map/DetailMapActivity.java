package com.pau.putrautama.gamon.ui.map;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.MendaftarUser;
import com.pau.putrautama.gamon.ui.model.User;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DetailMapActivity extends AppCompatActivity {

    private TextView mAlamat, mNamaBank, mJamBuka,
             mHargaKertas, mHargaBotol, mTextBotol,mTextKertas;

    private ImageView mFotoBank,mBtnBack, mBotol, mKertas;
    private Button mBtnTujuLokasi, mBtnMendaftar;
    private DatabaseReference mFirebaseDatabaseUser,mFirebaseDatabaseBankSampah;
    private FirebaseDatabase mFirebaseInstanceUser, mFirebaseBankSampahInstance;
    private FirebaseAuth mAuth;
    MendaftarUser mendaftarUser;
    String idBank, namaBank;
    String userId,namaUser,saveCurrentDate, saveCurrentTime,tglBergabung;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_map);

        mAlamat = findViewById(R.id.alamat_bank_sampah);
        mNamaBank = findViewById(R.id.ntv_nama_bank);
        mFotoBank = findViewById(R.id.iv_foto_bank_sampah);
        mJamBuka = findViewById(R.id.jam_buka);
        mHargaBotol = findViewById(R.id.harga_botol);
        mHargaKertas = findViewById(R.id.harga_kertas);
        mBotol = findViewById(R.id.iv_botol);
        mKertas = findViewById(R.id.iv_kertas);
        mTextKertas = findViewById(R.id.tv_kertas);
        mTextBotol = findViewById(R.id.tv_botol);
        mBtnBack = findViewById(R.id.back_map);
        mBtnTujuLokasi = findViewById(R.id.btn_tuju_lokasi);
        mBtnMendaftar = findViewById(R.id.btn_menjadi_nasabah);

        mAuth = FirebaseAuth.getInstance();
        retriveData();
         final String latitude= getIntent().getStringExtra("latitude");
         final String longitude = getIntent().getStringExtra("longitude");
         namaBank = getIntent().getStringExtra("namabank");
         String alamatBank =getIntent().getStringExtra("alamatbank");
         String isMenerimaKertas = getIntent().getStringExtra("menerimakertas");
         String isMenerimaBotol = getIntent().getStringExtra("menerimaplastik");
         String hargaKertas = getIntent().getStringExtra("hargakertas");
         String hargaPlastik = getIntent().getStringExtra("hargaplastik");
         idBank = getIntent().getStringExtra("idbankSampah");

        boolean checkKertas = Boolean.valueOf(isMenerimaKertas);
        boolean checkBotol = Boolean.valueOf(isMenerimaBotol);


        mAlamat.setText(alamatBank);
        mNamaBank.setText(namaBank);
        if (checkBotol == true && checkKertas == true){
            String hargaKerta = hargaKertas;
            mHargaKertas.setText("Rp  "+hargaKerta +"/kg");
            String hargabotol = hargaPlastik;
            mHargaBotol.setText("Rp  " +hargabotol+ "/kg");
        }else  if (checkBotol != true){
            mHargaBotol.setVisibility(View.GONE);
            mBotol.setVisibility(View.GONE);
            mTextBotol.setVisibility(View.GONE);
        }else if (checkKertas != true){
            mHargaKertas.setVisibility(View.GONE);
            mKertas.setVisibility(View.GONE);
            mTextKertas.setVisibility(View.GONE);
        }
//        String hargaKerta = hargaKertas;
//        mHargaKertas.setText("Rp  "+hargaKerta +"/kg");
//        String hargabotol = hargaPlastik;
//        mHargaBotol.setText("Rp  " +hargabotol+ "/kg");
        mBtnTujuLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q="+latitude+","+longitude);
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }
        });

        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        mBtnMendaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mendaftarBank();
                Toast.makeText(DetailMapActivity.this, R.string.pendaftaran, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mendaftarBank() {
        String namaBank = getIntent().getStringExtra("namabank");
        getDate();
        mFirebaseInstanceUser = FirebaseDatabase.getInstance();
        mFirebaseBankSampahInstance = FirebaseDatabase.getInstance();

        mFirebaseDatabaseBankSampah = mFirebaseBankSampahInstance.getReference("userbanksampah");
        mFirebaseDatabaseUser = mFirebaseInstanceUser.getReference("users");

        userId = mAuth.getUid();
        mendaftarUser = new MendaftarUser(userId,namaBank,namaUser
                ,tglBergabung,0,0,0);

        mFirebaseDatabaseBankSampah.child(idBank).child("menunggu")
                .child(userId).setValue(mendaftarUser);


    }
    private void retriveData(){
        userId = mAuth.getUid();
        mFirebaseInstanceUser = FirebaseDatabase.getInstance();
        mFirebaseDatabaseUser = mFirebaseInstanceUser.getReference("users");
        mFirebaseDatabaseUser.child(userId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    namaUser = dataSnapshot.child("namaLengkap").getValue().toString();
                    Log.d("nama", "onDataChange: "+namaUser);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getDate(){
        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("dd MMM yyyy ");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm ");
        saveCurrentTime = currentTime.format(calendar.getTime());

        tglBergabung = saveCurrentDate + "|" + saveCurrentTime;
    }
}
