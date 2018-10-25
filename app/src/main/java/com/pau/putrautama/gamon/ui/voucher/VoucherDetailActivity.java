package com.pau.putrautama.gamon.ui.voucher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.VoucherList;

public class VoucherDetailActivity extends AppCompatActivity {

    TextView mjudulVoucher,mPoin,mDeskripsi,mSyarat1,mSyarat2,mSyarat3,mSyarat4,mSyarat5;
    ImageView mImageVoucher;
    Button mBtnBeli;
    ImageView mBack;

    private VoucherList voucherList;

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

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        voucherList = (VoucherList) getIntent().getSerializableExtra(ITEM_VOUCHER);
        mjudulVoucher.setText(voucherList.getJudulVoucher());
        String poin = Integer.toString(voucherList.getPoinVoucher());
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
                Toast.makeText(VoucherDetailActivity.this, "Voucher Berhasil Dibeli", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
