package com.pau.putrautama.gamon.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.activity.BankDetailActivity;
import com.pau.putrautama.gamon.ui.model.BankList;

import java.util.List;

public class BankAdapter extends RecyclerView.Adapter<BankAdapter.BankViewHolder> {
    private Context context;
    private List<BankList> bankLists;

    public BankAdapter(Context context, List<BankList> bankLists) {
        this.context = context;
        this.bankLists = bankLists;
    }

    @NonNull
    @Override
    public BankViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bank, parent, false);
        return new BankAdapter.BankViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BankViewHolder holder, final int position) {
        holder.mNamaBank.setText(bankLists.get(position).getNamaBank());
        holder.mAlamatBank.setText(bankLists.get(position).getAlamatBank());
        String saldo = Integer.toString(bankLists.get(position).getSaldo());
        holder.mSaldo.setText("Rp. "+saldo);
        Glide.with(context).load(bankLists.get(position).getFotoBank()).into(holder.mFotoBank);
        holder.mCVBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, BankDetailActivity.class);
                intent.putExtra("nama_bank",bankLists.get(position).getNamaBank());
                intent.putExtra("alamat_bank",bankLists.get(position).getAlamatBank());
                intent.putExtra("tgl_masuk_bank",bankLists.get(position).getTglMasuk());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return bankLists.size();
    }

    public class BankViewHolder extends RecyclerView.ViewHolder {

        private TextView mNamaBank,mAlamatBank,mSaldo;
        private ImageView mFotoBank;
        private CardView mCVBank;
        public BankViewHolder(View itemView) {
            super(itemView);

            mNamaBank = itemView.findViewById(R.id.tv_nama_bank_sampah);
            mAlamatBank = itemView.findViewById(R.id.tv_alamat_bank_sampah);
            mSaldo = itemView.findViewById(R.id.tv_saldo_user);
            mFotoBank = itemView.findViewById(R.id.iv_bank_sampah);
            mCVBank = itemView.findViewById(R.id.cv_bank_sampah);
        }
    }
}
