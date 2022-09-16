package com.example.infit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterReferralCode extends RecyclerView.Adapter<AdapterReferralCode.ViewHolder> {

    Object[] dataSet;
    Context context = null;

    AdapterReferralCode(Object[] data) {
        dataSet = data;
    }

    AdapterReferralCode(Object[] data, Context context1) {
        dataSet = data;
        context = context1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_referral_code_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(context == null) {
            context = holder.menu.getContext();
        }
        holder.menu.setOnClickListener(this::showPopupWindow);

        // setup rest of the view
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

    private void showPopupWindow(View view) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View myPopupView = inflater.inflate(R.layout.popup_window, null);

        final PopupWindow popupWindow = new PopupWindow(myPopupView, 510, 350, true);

        popupWindow.showAsDropDown(view, -400, 0);

        LinearLayout download = myPopupView.findViewById(R.id.popup_download);
        LinearLayout share = myPopupView.findViewById(R.id.popup_share);
        LinearLayout delete = myPopupView.findViewById(R.id.popup_delete);

        download.setOnClickListener(view1 -> {
            popupWindow.dismiss();
            // perform an action
            Toast.makeText(context, "download", Toast.LENGTH_LONG).show();
        });

        share.setOnClickListener(view1 -> {
            popupWindow.dismiss();
            // perform an action
            Toast.makeText(context, "share", Toast.LENGTH_LONG).show();
        });

        delete.setOnClickListener(view1 -> {
            popupWindow.dismiss();
            // perform an action
            Toast.makeText(context, "delete", Toast.LENGTH_LONG).show();
        });
    }
}
