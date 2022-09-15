package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterReferralCode extends RecyclerView.Adapter<AdapterReferralCode.ViewHolder> {

    Object[] dataSet;

    AdapterReferralCode(Object[] data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_referral_code_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // setup the view
    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView profile;
        TextView name;
        ImageButton menu;
        TextView referralCode;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile = itemView.findViewById(R.id.recview_referral_code_profile);
            name = itemView.findViewById(R.id.recview_referral_code_name);
            menu = itemView.findViewById(R.id.recview_referral_code_menu);
            referralCode = itemView.findViewById(R.id.recview_referral_code_code);
        }
    }
}
