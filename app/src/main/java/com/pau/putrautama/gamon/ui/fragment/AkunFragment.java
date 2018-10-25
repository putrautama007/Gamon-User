package com.pau.putrautama.gamon.ui.fragment;


import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.activity.LoginActivity;
import com.pau.putrautama.gamon.ui.detailAkun.EditAkunActivity;
import com.pau.putrautama.gamon.ui.detailAkun.PasswordActivity;
import com.pau.putrautama.gamon.ui.poin.PoinActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class AkunFragment extends Fragment {

     TextView mNamaLengkap,mEmail, mNoTlp, mPoin, mEdit;
     CardView mCvSandi, mCvPoin, mCvLogout;

    public AkunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_akun, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mNamaLengkap = view.findViewById(R.id.tv_nama_lengkap);
        mEmail = view.findViewById(R.id.tv_email_user);
        mNoTlp = view.findViewById(R.id.tv_nohp_user);
        mPoin = view.findViewById(R.id.tv_poin);
        mEdit = view.findViewById(R.id.tv_edit);
        mCvSandi = view.findViewById(R.id.cv_password);
        mCvPoin = view.findViewById(R.id.cv_poin);
        mCvLogout = view.findViewById(R.id.cv_logout);

        mEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), EditAkunActivity.class);
                startActivity(intent);
            }
        });

        mCvSandi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PasswordActivity.class);
                startActivity(intent);
            }
        });

        mCvPoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getContext(), PoinActivity.class);
                startActivity(intent);
            }
        });

        mCvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               customAllertDialog();
            }
        });
    }

    private void customAllertDialog() {
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.logout_dialog);
        dialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND);

        TextView yes = dialog.findViewById(R.id.tv_iya_keluar);
        TextView no  = dialog.findViewById(R.id.tv_tidak_keluar);

        yes.setEnabled(true);
        no.setEnabled(true);

        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
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
