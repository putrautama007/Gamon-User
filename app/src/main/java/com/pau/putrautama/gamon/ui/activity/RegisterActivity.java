package com.pau.putrautama.gamon.ui.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.User;

public class RegisterActivity extends AppCompatActivity {

    EditText mNamaLengkap,mEmail,mPassword,mNohp,mConfirmPassword;
    LinearLayout mHaveAccount;
    Button mBtnDaftar;
    ProgressBar progressBar;
    private FirebaseAuth mAuth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private User user;
    private String userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNamaLengkap = findViewById(R.id.et_name_register);
        mEmail = findViewById(R.id.et_email_register);
        mPassword = findViewById(R.id.et_password_register);
        mNohp = findViewById(R.id.et_nohp_register);
        mHaveAccount = findViewById(R.id.allready_have_account);
        mBtnDaftar = findViewById(R.id.btn_daftar);
        mConfirmPassword = findViewById(R.id.et_password_confirm_register);
        progressBar = findViewById(R.id.regiter_progressbar);

        mAuth = FirebaseAuth.getInstance();
        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference("users");

        mBtnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerAccount();

            }
        });


        allreadyHaveAccount();
    }
    public void registerAccount(){
        final String namaLengkap = mNamaLengkap.getText().toString().trim();
        final String email = mEmail.getText().toString().trim();
        final String password  = mPassword.getText().toString().trim();
        String confitmPassword = mConfirmPassword.getText().toString().trim();
        final String noHp = mNohp.getText().toString().trim();
        final int poin = 0;

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,R.string.mohon_masukan_email,Toast.LENGTH_LONG).show();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(this, R.string.email_unvalid, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.masukan_password,Toast.LENGTH_LONG).show();
            return;
        }
        if (password.length()<6){
            Toast.makeText(this, R.string.minimal_karakter, Toast.LENGTH_SHORT).show();
            return;
        }
        if (!confitmPassword.equals(password)){
            Toast.makeText(this, R.string.confirm_password_not_match, Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(noHp)){
            Toast.makeText(this, R.string.masukan_nohp,Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(namaLengkap)){
            Toast.makeText(this, R.string.masukan_nama_lengkap,Toast.LENGTH_LONG).show();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            createAccount(namaLengkap,email,password,noHp,poin);
                            Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                            finish();
                            Log.d("Firebase", "signUpWithEmail:success");
                            Toast.makeText(RegisterActivity.this, R.string.berhasil_daftar, Toast.LENGTH_SHORT).show();
                        } else {

                            if (task.getException() instanceof FirebaseAuthUserCollisionException){
                                Toast.makeText(RegisterActivity.this, R.string.sudah_terdaftar, Toast.LENGTH_SHORT).show();
                            }else {
                                Log.w( "Firebase", "signUpWithEmail:failure", task.getException());
                                Toast.makeText(RegisterActivity.this, R.string.gagal_daftar, Toast.LENGTH_SHORT).show();
                            }

                        }
                    }
                });
    }
    public void allreadyHaveAccount(){
        mHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void createAccount(String namaLengkap, String email, String password, String noTlp, int poin){
        userId = mAuth.getUid();

        user = new User(namaLengkap,email,password,noTlp,poin);
        mFirebaseDatabase.child(userId).setValue(user);
    }
}
