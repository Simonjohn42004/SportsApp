package com.example.sportsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CardViewholder> {

    private static OnItemClickListenerForCard listener;

    private List<SportsClass> sportlist;
    Context context;

    public void setOnItemClickListener(OnItemClickListenerForCard listener) {
        CardAdapter.listener = listener;
    }

    public CardAdapter(Context context, List<SportsClass> sportlist) {
        this.sportlist = sportlist;
        this.context=context;
    }

    @NonNull
    @Override
    public CardViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cutom_cardview_layout, parent, false);
        return new CardViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewholder holder, int position) {
        SportsClass sportsClass = sportlist.get(position);
        holder.sportimageholder.setImageResource(sportsClass.getSportimage());
        holder.sportnameholder.setText(sportsClass.getSportname());


    }

    @Override
    public int getItemCount() {
        return sportlist.size();
    }

    public static class CardViewholder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView sportimageholder;
        TextView sportnameholder;


        public CardViewholder(@NonNull View itemView) {
            super(itemView);
            sportimageholder = itemView.findViewById(R.id.sportsImageView);
            sportnameholder = itemView.findViewById(R.id.titleTextView);
            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onItemClick(v, getAdapterPosition());
            }

        }
    }


}
