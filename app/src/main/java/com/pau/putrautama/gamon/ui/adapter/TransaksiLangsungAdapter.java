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
import com.pau.putrautama.gamon.ui.model.TransaksiLangsung;
import com.pau.putrautama.gamon.ui.riwayat.DetailHistoryActivity;

import java.util.ArrayList;

public class TransaksiLangsungAdapter extends RecyclerView.Adapter<TransaksiLangsungAdapter.ViewHolder> {
    private Context context;
    private ArrayList<TransaksiLangsung> transaksiLangsungs;

    public TransaksiLangsungAdapter(Context context, ArrayList<TransaksiLangsung> transaksiLangsungs) {
        this.context = context;
        this.transaksiLangsungs = transaksiLangsungs;
    }

    @NonNull
    @Override
    public TransaksiLangsungAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_transaksi_langsung, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull TransaksiLangsungAdapter.ViewHolder holder, final int position) {
        holder.mNamaBank.setText(transaksiLangsungs.get(position).getNamaBankSampah());
        holder.mTglTransaksi.setText(transaksiLangsungs.get(position).getTglTransaksi());
        holder.totalTransaksi.setText("Rp. "+String.valueOf(transaksiLangsungs.get(position).getHargaTotal()));
        String poin = Integer.toString(transaksiLangsungs.get(position).getPoin());
        holder.mPoin.setText(context.getString(R.string.plus)+poin+context.getString(R.string.p));
        holder.mCVHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailHistoryActivity.class);
                intent.putExtra(DetailHistoryActivity.nama_user, transaksiLangsungs.get(position).getNamaUser());
                intent.putExtra(DetailHistoryActivity.nama_bank, transaksiLangsungs.get(position).getNamaBankSampah());
                intent.putExtra(DetailHistoryActivity.tgl_transaksi, transaksiLangsungs.get(position).getTglTransaksi());
                intent.putExtra(DetailHistoryActivity.id_transaksi, transaksiLangsungs.get(position).getIdTransaksi());
                intent.putExtra(DetailHistoryActivity.total_harga, String.valueOf(transaksiLangsungs.get(position).getHargaTotal()));
                intent.putExtra(DetailHistoryActivity.berat_kertas, String.valueOf(transaksiLangsungs.get(position).getBeratKertas()));
                intent.putExtra(DetailHistoryActivity.berat_botol, String.valueOf(transaksiLangsungs.get(position).getBeratBotol()));
                intent.putExtra(DetailHistoryActivity.harga_kertas, String.valueOf(transaksiLangsungs.get(position).getHargaKertas()));
                intent.putExtra(DetailHistoryActivity.harga_botol, String.valueOf(transaksiLangsungs.get(position).getHargaBotol()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return transaksiLangsungs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNamaBank, mTglTransaksi,mPoin,totalTransaksi;
        private CardView mCVHistory;
        public ViewHolder(View itemView) {
            super(itemView);
            totalTransaksi = itemView.findViewById(R.id.tv_total_harga_history);
            mNamaBank = itemView.findViewById(R.id.tv_nama_bank_sampah_history);
            mTglTransaksi = itemView.findViewById(R.id.tv_tgl_transaksi_history);
            mPoin = itemView.findViewById(R.id.tv_poin_history);
            mCVHistory = itemView.findViewById(R.id.cv_history);
        }
    }
}
