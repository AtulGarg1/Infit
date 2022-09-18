package com.example.infit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterQNAParent extends RecyclerView.Adapter<AdapterQNAParent.ViewHolder> {

    Object[] dataSet;

    public AdapterQNAParent(Object[] dataSet) {
        this.dataSet = dataSet;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recview_qna_parent_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int qno = position + 1;
        holder.parentQno.setText("Q" + qno);
        holder.parentArrow.setOnClickListener(view -> OnClick(holder.parentAnswer, holder.parentArrow));
    }

    private void OnClick(View answer, ImageButton arrow) {
        if(answer.getVisibility() == View.GONE) {
            answer.setVisibility(View.VISIBLE);
            arrow.setImageResource(R.drawable.ic_arrow_down);
        } else {
            answer.setVisibility(View.GONE);
            arrow.setImageResource(R.drawable.ic_arrow_right);
        }


    }

    @Override
    public int getItemCount() {
        return dataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView parentQno;
        TextView parentQuestion;
        ImageButton parentArrow;
        TextView parentAnswer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            parentQno = itemView.findViewById(R.id.recview_qna_parent_item_qno);
            parentQuestion = itemView.findViewById(R.id.recview_qna_parent_item_question);
            parentArrow = itemView.findViewById(R.id.recview_qna_parent_item_arrow);
            parentAnswer = itemView.findViewById(R.id.recview_qna_parent_answer);
        }
    }
}
