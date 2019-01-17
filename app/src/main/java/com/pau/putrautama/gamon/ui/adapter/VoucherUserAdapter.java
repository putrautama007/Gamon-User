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
import com.pau.putrautama.gamon.ui.model.VoucherListUser;
import com.pau.putrautama.gamon.ui.voucher.DetailVoucherUserActivity;

import java.util.ArrayList;

public class VoucherUserAdapter  extends RecyclerView.Adapter<VoucherUserAdapter.ViewHolder>  {

    private Context context;
    private ArrayList<VoucherListUser> voucherListUsers;

    public VoucherUserAdapter(Context context, ArrayList<VoucherListUser> voucherListUsers) {
        this.context = context;
        this.voucherListUsers = voucherListUsers;
    }

    @NonNull
    @Override
    public VoucherUserAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.voucher_user, parent, false);
        return new VoucherUserAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VoucherUserAdapter.ViewHolder holder, final int position) {
        Glide.with(context).load(voucherListUsers.get(position).getGambarVoucher()).into(holder.mVoucher);

        holder.mCVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailVoucherUserActivity.class);
                intent.putExtra(DetailVoucherUserActivity.ITEM_VOUCHER_USER, voucherListUsers.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return voucherListUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mVoucher;
        CardView mCVoucher;
        public ViewHolder(View itemView) {
            super(itemView);
            mVoucher = itemView.findViewById(R.id.image_voucher_user);
            mCVoucher = itemView.findViewById(R.id.cv_voucher_user);
        }
    }
}
