package com.pau.putrautama.gamonbanksampah.adapter;

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
import com.pau.putrautama.gamonbanksampah.R;
import com.pau.putrautama.gamonbanksampah.detailHistory.HistoryDetailActivity;
import com.pau.putrautama.gamonbanksampah.model.HistoryList;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HistoryList> historyList;

    public HistoryAdapter(Context context, ArrayList<HistoryList> historyList) {
        this.context = context;
        this.historyList = historyList;
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_history, parent, false);
        return  new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryAdapter.ViewHolder holder, final int position) {
        if (historyList.get(position).getBeratKertas() > 0 && historyList.get(position).getBeratBotol() < 0 ){
            Glide.with(context).load(R.drawable.flat_paper).into(holder.mIcon);
        }else if (historyList.get(position).getBeratKertas() < 0 && historyList.get(position).getBeratBotol() > 0){
            Glide.with(context).load(R.drawable.flat_bottle).into(holder.mIcon);
        }else if (historyList.get(position).getBeratKertas() > 0 &&historyList.get(position).getBeratBotol() > 0){
            Glide.with(context).load(R.drawable.flat_both).into(holder.mIcon);
        }

        holder.mNamaUser.setText(historyList.get(position).getNamaUser());
        holder.mTglTransaksi.setText(historyList.get(position).getTgl());
        String id = Integer.toString(historyList.get(position).getIdTransaksi());
        String idTransaksi = "GM"+id;
        holder.mIdTransaksi.setText(context.getString(R.string.transaksiid)+idTransaksi);
        holder.mCVHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, HistoryDetailActivity.class);
                intent.putExtra(HistoryDetailActivity.ITEM_HISTORY, historyList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView mNamaUser, mTglTransaksi,mIdTransaksi;
        private CardView mCVHistory;
        private ImageView mIcon;

        public ViewHolder(View itemView) {
            super(itemView);

            mIcon = itemView.findViewById(R.id.iv_history);
            mNamaUser = itemView.findViewById(R.id.tv_nama_user_history);
            mTglTransaksi = itemView.findViewById(R.id.tv_tgl_history);
            mIdTransaksi = itemView.findViewById(R.id.tv_no_transaksi_history);
            mCVHistory = itemView.findViewById(R.id.cv_history);
        }
    }
}
