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

import com.bumptech.glide.Glide;
import com.pau.putrautama.gamon.R;
import com.pau.putrautama.gamon.ui.model.VoucherList;
import com.pau.putrautama.gamon.ui.voucher.VoucherDetailActivity;

import java.util.ArrayList;

public class VoucherAdapter extends RecyclerView.Adapter<VoucherAdapter.ViewHolder> {

    private Context context;
    private ArrayList<VoucherList> voucherLists;

    public VoucherAdapter(Context context, ArrayList<VoucherList> voucherLists) {
        this.context = context;
        this.voucherLists = voucherLists;
    }

    @NonNull
    @Override
    public VoucherAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_list, parent, false);
        return new VoucherAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherAdapter.ViewHolder holder, final int position) {

        Glide.with(context).load(voucherLists.get(position).getGambarVoucher()).into(holder.mVoucher);

        holder.mCVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, VoucherDetailActivity.class);
                intent.putExtra(VoucherDetailActivity.ITEM_VOUCHER, voucherLists.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return voucherLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mVoucher;
        CardView mCVoucher;
        public ViewHolder(View itemView) {
            super(itemView);

            mVoucher = itemView.findViewById(R.id.image_voucher);
            mCVoucher = itemView.findViewById(R.id.cv_voucher);
        }
    }
}
