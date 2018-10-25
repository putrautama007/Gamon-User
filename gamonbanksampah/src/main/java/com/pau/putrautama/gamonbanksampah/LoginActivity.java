package com.pau.putrautama.gamonbanksampah;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText mEmail,mPassword;
    private LinearLayout mDontAccount;
    private Button mBtnMasuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = findViewById(R.id.et_email);
        mPassword = findViewById(R.id.et_password);
        mDontAccount = findViewById(R.id.dont_have_account);
        mBtnMasuk = findViewById(R.id.btn_masuk);
        mBtnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginAccount();
            }
        });
        dontHaveAccount();
    }
    private void loginAccount() {
        String email = mEmail.getText().toString().trim();
        String password  = mPassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, R.string.mohon_masukan_email,Toast.LENGTH_LONG).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, R.string.email_unvalid, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, R.string.masukan_password,Toast.LENGTH_LONG).show();
            return;
        }
        if (email.contains("@")) {
            Toast.makeText(LoginActivity.this, R.string.berhasil_masuk, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(LoginActivity.this, R.string.masuk_gagal, Toast.LENGTH_SHORT).show();
        }
    }
    private void dontHaveAccount(){
        mDontAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
