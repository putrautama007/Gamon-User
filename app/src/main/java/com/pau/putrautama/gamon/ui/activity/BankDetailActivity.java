package com.pau.putrautama.gamon.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.adapter.BankAdapter;
import com.pau.putrautama.gamon.ui.adapter.TabunganAdapter;
import com.pau.putrautama.gamon.ui.model.BankList;
import com.pau.putrautama.gamon.ui.model.NabungList;

import java.util.ArrayList;
import java.util.List;

public class BankDetailActivity extends AppCompatActivity {

    public static final String ITEM_BANK_LIST = "item_bank_list";

    private RecyclerView mRVNabung;
    private ArrayList<NabungList> nabungLists = new ArrayList<>();
    private TabunganAdapter adapter;

    private TextView namaBank,alamatBank,tglMasuk;
    private String nama_bank,alamat_bank,tgl_masuk_bank;
    private ImageView btnBack;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_detail);

        nama_bank = getIntent().getStringExtra("nama_bank");
        alamat_bank = getIntent().getStringExtra("alamat_bank");
        tgl_masuk_bank = getIntent().getStringExtra("tgl_masuk_bank");

        namaBank = findViewById(R.id.tv_nama_bank_sampah);
        alamatBank = findViewById(R.id.tv_alamat_bank_sampah);
        tglMasuk = findViewById(R.id.tv_tanggal_gabung);
        btnBack = findViewById(R.id.back_detail_bank);

        namaBank.setText(nama_bank);
        alamatBank.setText(alamat_bank);
        tglMasuk.setText(tgl_masuk_bank);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        setUpData();
        mRVNabung = findViewById(R.id.rv_detail_tabungan);
        adapter = new TabunganAdapter(this,nabungLists);
        mRVNabung.setLayoutManager(new LinearLayoutManager(this));
        mRVNabung.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    private void setUpData() {
        nabungLists.add(new NabungList("Bank Sampah Sumber Jaya",
                "Jl. Cempaka 2 No. 16 Malang, Jawa Timur",
                "21 Oktober 2018 | 14:32"
                ,"DEBIT" ,110,"John Doe",
                38048581,4,5,6000,
                5000,11000,19000));

        nabungLists.add(new NabungList("Bank Sampah Sumber Jaya",
                "Jl. Cempaka 2 No. 16 Malang, Jawa Timur",
                "19 Oktober 2018 2018 | 10:32"
                ,"DEBIT" ,80,"John Doe",
                38245581,2,2,3000,
                5000,8000,8000));

    }
}
