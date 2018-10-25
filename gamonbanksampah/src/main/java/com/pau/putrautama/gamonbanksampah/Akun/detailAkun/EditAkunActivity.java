package com.pau.putrautama.gamonbanksampah.Akun.detailAkun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pau.putrautama.gamonbanksampah.R;

public class EditAkunActivity extends AppCompatActivity {

    EditText mEdtNamaLengkap, mEdtEmail, mEdtNoTlp;
    Button mBtnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_akun);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mEdtNamaLengkap = findViewById(R.id.edt_nama);
        mEdtEmail = findViewById(R.id.edt_email);
        mEdtNoTlp = findViewById(R.id.edt_notlp);
        mBtnSave = findViewById(R.id.btn_save_profile);
        mBtnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
