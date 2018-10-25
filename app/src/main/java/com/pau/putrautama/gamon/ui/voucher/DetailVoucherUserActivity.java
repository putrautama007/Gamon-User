package com.pau.putrautama.gamon.ui.voucher;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.VoucherListUser;

public class DetailVoucherUserActivity extends AppCompatActivity {

    TextView mjudulVoucher,mPoin,mDeskripsi,mTglVoucher,mSyarat1,mSyarat2,mSyarat3,mSyarat4,mSyarat5;
    ImageView mImageVoucher;
    Button mBtnGunakan,mBtnKembali;
    ImageView mBack;

    private VoucherListUser voucherList;

    public static final String ITEM_VOUCHER_USER = "item_voucher_user";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_voucher_user);

        mjudulVoucher = findViewById(R.id.judul_voucher_user);
        mPoin = findViewById(R.id.poin_voucher_user);
        mDeskripsi = findViewById(R.id.deskripsi_voucer_user);
        mTglVoucher = findViewById(R.id.tgl_voucher_user);
        mSyarat1 = findViewById(R.id.syarat1_user);
        mSyarat2 = findViewById(R.id.syarat2_user);
        mSyarat3 = findViewById(R.id.syarat3_user);
        mSyarat4 = findViewById(R.id.syarat4_user);
        mSyarat5 = findViewById(R.id.syarat5_user);
        mImageVoucher = findViewById(R.id.voucher_image_user);
        mBtnGunakan = findViewById(R.id.btn_gunakan_voucher);
        mBtnKembali = findViewById(R.id.btn_kembali);

        mBack = findViewById(R.id.back_voucher_user);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        voucherList = (VoucherListUser) getIntent().getSerializableExtra(ITEM_VOUCHER_USER);
        mjudulVoucher.setText(voucherList.getJudulVoucher());
        String poin = Integer.toString(voucherList.getPoinVoucher());
        mPoin.setText(poin+"P");
        mDeskripsi.setText(voucherList.getDeskripsi());
        mTglVoucher.setText(voucherList.getTglVoucher());
        mSyarat1.setText(voucherList.getSyarat1());
        mSyarat2.setText(voucherList.getSyarat2());
        mSyarat3.setText(voucherList.getSyarat3());
        mSyarat4.setText(voucherList.getSyarat4());
        mSyarat5.setText(voucherList.getSyarat5());

        mBtnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBtnGunakan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                customAllertDialog();
            }
        });
    }

    private void customAllertDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialgo_voucher);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        TextView yes = dialog.findViewById(R.id.tv_iya_konfirmasi_voucher);
        TextView no  = dialog.findViewById(R.id.tv_tidak_konfirmasi_voucher);

        yes.setEnabled(true);
        no.setEnabled(true);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DetailVoucherUserActivity.this, "Voucher Telah Digunakan", Toast.LENGTH_SHORT).show();
                mBtnGunakan.setVisibility(View.GONE);
                dialog.dismiss();
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }
}
