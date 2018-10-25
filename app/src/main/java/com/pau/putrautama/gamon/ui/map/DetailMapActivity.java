package com.pau.putrautama.gamon.ui.map;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.History;
import com.pau.putrautama.gamon.ui.model.MapList;

public class DetailMapActivity extends AppCompatActivity {

    private TextView mAlamat, mNamaBank, mJamBuka,
             mHargaKertas, mHargaBotol;

    private ImageView mFotoBank,mBtnBack;
    private Button mBtnTujuLokasi, mBtnMendaftar;
    private MapList mMapList;

    public static final String ITEM_MAP = "item_map";
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
        mBtnBack = findViewById(R.id.back_map);
        mBtnTujuLokasi = findViewById(R.id.btn_tuju_lokasi);
        mBtnMendaftar = findViewById(R.id.btn_menjadi_nasabah);

//        mMapList = (MapList) getIntent().getSerializableExtra(ITEM_MAP);
//        mAlamat.setText(mMapList.getLokasiBank());
//        mNamaBank.setText(mMapList.getNamaBank());
//        mJamBuka.setText(mMapList.getJamBuka());
//        String hargaKerta = Integer.toString(mMapList.getHargaKertas());
//        mHargaKertas.setText("Rp  "+hargaKerta +"/kg");
//        String hargabotol = Integer.toString(mMapList.getHargaBotol());
//        mHargaBotol.setText("Rp  " +hargabotol+ "/kg");
        mBtnTujuLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri gmmIntentUri = Uri.parse("google.navigation:q=-7.956604,112.631854");
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
                Toast.makeText(DetailMapActivity.this, R.string.pendaftaran, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
