package com.pau.putrautama.gamon.ui.adapter;

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
import com.pau.putrautama.gamon.ui.model.TransaksiTabung;
import com.pau.putrautama.gamon.ui.riwayat.DetailHistoryActivity;

import java.util.ArrayList;

public class TransaksiTabungAdapter  extends RecyclerView.Adapter<TransaksiTabungAdapter.ViewHolder> {

    private Context context;
    private ArrayList<TransaksiTabung> transaksiTabungs;

    public TransaksiTabungAdapter(Context context, ArrayList<TransaksiTabung> transaksiTabungs) {
        this.context = context;
        this.transaksiTabungs = transaksiTabungs;
    }

    @NonNull
    @Override
    public TransaksiTabungAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tabung, parent, false);
        return new TransaksiTabungAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransaksiTabungAdapter.ViewHolder holder, int position) {
        holder.mNamaBank.setText(transaksiTabungs.get(position).getNamaBankSampah());
        holder.mTglTransaksi.setText(transaksiTabungs.get(position).getTglTransaksi());
        holder.totalTransaksi.setText("Rp. "+String.valueOf(transaksiTabungs.get(position).getHargaTotal()));
        String poin = Integer.toString(transaksiTabungs.get(position).getPoin());
        holder.mPoin.setText(context.getString(R.string.plus)+poin+context.getString(R.string.p));
        holder.statusTransaksi.setText(transaksiTabungs.get(position).getStatusTransaksi());
        holder.mCVHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return transaksiTabungs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView mNamaBank, mTglTransaksi,mPoin,totalTransaksi,statusTransaksi;
        private CardView mCVHistory;

        public ViewHolder(View itemView) {
            super(itemView);

            totalTransaksi = itemView.findViewById(R.id.tv_total_harga_nabung);
            mNamaBank = itemView.findViewById(R.id.tv_nama_bank_sampah_nabung);
            mTglTransaksi = itemView.findViewById(R.id.tv_tgl_transaksi_nabung);
            mPoin = itemView.findViewById(R.id.tv_poin_nabung);
            mCVHistory = itemView.findViewById(R.id.cv_nabung);
            statusTransaksi = itemView.findViewById(R.id.tv_status_transaksi);
        }
    }
}
