package com.pau.putrautama.gamon.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.NabungList;

import java.util.List;

public class TabunganAdapter  extends RecyclerView.Adapter<TabunganAdapter.NabungViewHolder> {

    private Context context;
    private List<NabungList> nabungLists;

    public TabunganAdapter(Context context, List<NabungList> nabungLists) {
        this.context = context;
        this.nabungLists = nabungLists;
    }

    @NonNull
    @Override
    public NabungViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_tabungan, parent, false);
        return new TabunganAdapter.NabungViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NabungViewHolder holder, int position) {
        String jumlah = Integer.toString(nabungLists.get(position).getTotalHarga());
        holder.jumlahTabungan.setText("Rp. " + jumlah +",-");
        String saldo = Integer.toString(nabungLists.get(position).getTotalSaldo());
        holder.totalSaldo.setText("Rp. " + saldo +",-");
        String transaksi = Integer.toString(nabungLists.get(position).getTransaksiId());
        holder.trasaksiId.setText("ID :" +transaksi);
        holder.tglTransaksi.setText(nabungLists.get(position).getTanggalTransaksi());

        holder.rlNabung.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return nabungLists.size();
    }

    public class NabungViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout rlNabung;
        private TextView jumlahTabungan,totalSaldo,trasaksiId,tglTransaksi;

        public NabungViewHolder(View itemView) {
            super(itemView);

            rlNabung = itemView.findViewById(R.id.rl_tabungan);
            jumlahTabungan = itemView.findViewById(R.id.tv_tabungan_masuk);
            totalSaldo = itemView.findViewById(R.id.tv_tabungan_total);
            trasaksiId = itemView.findViewById(R.id.tv_transaksi_id);
            tglTransaksi = itemView.findViewById(R.id.tv_tgl_nabung);
        }
    }
}
