package com.pau.putrautama.gamonbanksampah.Akun.detailAkun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.pau.putrautama.gamonbanksampah.R;

public class PasswordActivity extends AppCompatActivity {
    EditText mPassLama, mPassBaru,mConfirmPass;
    Button mBtnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mPassLama = findViewById(R.id.edt_pass_lama);
        mPassBaru = findViewById(R.id.edt_pass_baru);
        mConfirmPass = findViewById(R.id.edt_confirm_pass);
        mBtnUbah = findViewById(R.id.btn_save_pass);
        mBtnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
