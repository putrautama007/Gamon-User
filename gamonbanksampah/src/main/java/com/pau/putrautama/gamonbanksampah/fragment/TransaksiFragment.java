package com.pau.putrautama.gamonbanksampah.fragment;


import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;
import com.pau.putrautama.gamonbanksampah.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TransaksiFragment extends Fragment {

    TextView mKertas, mBotol;
    Button mBtnTransaksi;
    ImageView qr;

    public TransaksiFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_transaksi, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mKertas = view.findViewById(R.id.et_jumlah_kertas);
        mBotol = view.findViewById(R.id.et_jumlah_botol);
        mBtnTransaksi = view.findViewById(R.id.btn_transaksi);
        qr = view.findViewById(R.id.iv_qr_code);

        mBtnTransaksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String kertas = mKertas.getText().toString();
                String botol = mBotol.getText().toString();
                if (kertas != null && botol != null){
                    MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
                    try{
                        BitMatrix bitMatrix = multiFormatWriter.encode(kertas, BarcodeFormat.QR_CODE, 500, 500);
                        BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                        Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
                        qr.setImageBitmap(bitmap);
                    } catch (WriterException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
