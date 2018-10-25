package com.pau.putrautama.gamon.ui.riwayat;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.History;

public class DetailHistoryActivity extends AppCompatActivity {

    private TextView mNamaDetail, mNamaBankDetail, mTglDetail,
            mBeratKertas, mBeratBotol, mHargaKertas, mHargaBotol, mTotalHarga;

    private ImageView mIcon;
    private Button mBtnBack;
    private History mHistory;

    public static final String ITEM_HISTORY = "item_history";

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);

        mNamaDetail = findViewById(R.id.tv_detail_nama);
        mNamaBankDetail = findViewById(R.id.tv_detail_nama_bank_sampah);
        mTglDetail = findViewById(R.id.tv_detail_tgl);
        mBeratKertas = findViewById(R.id.tv_detail_berat_kertas);
        mBeratBotol = findViewById(R.id.tv_detail_berat_botol);
        mHargaKertas = findViewById(R.id.tv_detail_harga_kertas);
        mHargaBotol = findViewById(R.id.tv_detail_harga_botol);
        mTotalHarga = findViewById(R.id.tv_detail_total_harga);
        mIcon = findViewById(R.id.iv_detail_riwayat);
        mBtnBack = findViewById(R.id.btn_detail_back);

        mHistory = (History) getIntent().getSerializableExtra(ITEM_HISTORY);
        mNamaDetail.setText(mHistory.getNamaUser());
        mNamaBankDetail.setText(mHistory.getNamaBankSampah());
        mTglDetail.setText(mHistory.getTanggalTransaksi());
        String beratKertas = Integer.toString(mHistory.getBeratKertas());
        mBeratKertas.setText(beratKertas+getResources().getString(R.string.kilogram));
        String beratBotol = Integer.toString(mHistory.getBeratBotol());
        mBeratBotol.setText(beratBotol+getResources().getString(R.string.kilogram));
        String hargaKertas = Integer.toString(mHistory.getHargaKertas());
        mHargaKertas.setText(getResources().getString(R.string.rupiah)+hargaKertas);
        String hargaBotol = Integer.toString(mHistory.getHargaBotol());
        mHargaBotol.setText(getResources().getString(R.string.rupiah)+hargaBotol);
        String totalHarga = Integer.toString(mHistory.getTotalHarga());
        mTotalHarga.setText(getResources().getString(R.string.rupiah)+totalHarga);

        if (mHistory.getBeratKertas() > 0 && mHistory.getBeratBotol() < 0 ){
            Glide.with(this).load(R.drawable.flat_paper).into(mIcon);
        }else if (mHistory.getBeratKertas() < 0 && mHistory.getBeratBotol() > 0){
            Glide.with(this).load(R.drawable.flat_bottle).into(mIcon);
        }else if (mHistory.getBeratKertas() > 0 && mHistory.getBeratBotol() > 0){
            Glide.with(this).load(R.drawable.flat_both).into(mIcon);
        }


        mBtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
