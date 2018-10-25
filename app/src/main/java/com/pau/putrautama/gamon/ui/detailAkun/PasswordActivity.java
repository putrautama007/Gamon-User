package com.pau.putrautama.gamon.ui.detailAkun;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.pau.putrautama.gamon.R;

public class PasswordActivity extends AppCompatActivity {
    EditText mPassLama, mPassBaru,mConfirmPass;
    Button mBtnUbah;
    ImageView mBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        mPassLama = findViewById(R.id.edt_pass_lama);
        mPassBaru = findViewById(R.id.edt_pass_baru);
        mConfirmPass = findViewById(R.id.edt_confirm_pass);
        mBtnUbah = findViewById(R.id.btn_save_pass);
        mBack = findViewById(R.id.back_edt_password);

        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mBtnUbah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
