package com.pau.putrautama.gamon.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.riwayat.DetailHistoryActivity;
import com.pau.putrautama.gamon.ui.model.History;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {
    private Context context;
    private ArrayList<History> historyList;

    public HistoryAdapter(Context context, ArrayList<History> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, final int position) {
        holder.mNamaBank.setText(historyList.get(position).getNamaBankSampah());
        holder.mAlamatBank.setText(historyList.get(position).getLokasiBankSampah());
        holder.mTglTransaksi.setText(historyList.get(position).getTanggalTransaksi());
        String poin = Integer.toString(historyList.get(position).getPoin());
        holder.mPoin.setText(context.getString(R.string.plus)+poin+context.getString(R.string.p));
        holder.mCVHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailHistoryActivity.class);
                intent.putExtra(DetailHistoryActivity.ITEM_HISTORY, historyList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNamaBank, mAlamatBank, mTglTransaksi,mPoin;
        private CardView mCVHistory;
        public ViewHolder(View itemView) {
            super(itemView);

            mNamaBank = itemView.findViewById(R.id.tv_nama_bank_sampah_history);
            mAlamatBank = itemView.findViewById(R.id.tv_alamat_bank_sampah_history);
            mTglTransaksi = itemView.findViewById(R.id.tv_tgl_transaksi_history);
            mPoin = itemView.findViewById(R.id.tv_poin_history);
            mCVHistory = itemView.findViewById(R.id.cv_history);
        }
    }
}
