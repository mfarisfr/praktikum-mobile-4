package com.example.navbar;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterPahlawan extends RecyclerView.Adapter<AdapterPahlawan.ViewHolder> {
    private ArrayList<modelPahlawan> modelPahlawans;
    private Context context;

    public AdapterPahlawan(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pahlawan,parent,false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Glide.with(context).load(getModelPahlawans().get(position).getHeroImages()).into(holder.ivPahlawan);
        holder.tvNamaPahlawan.setText(getModelPahlawans().get(position).heroNames);
        //       holder.tvDetailPahlawan.setText(getModelPahlawans().get(position).heroDetails);
        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,Detail.class);
                intent.putExtra("nama",getModelPahlawans().get(position).getHeroNames());
                intent.putExtra("deskripsi",getModelPahlawans().get(position).getHeroDetails());
                intent.putExtra("gambar",getModelPahlawans().get(position).getHeroImages());

                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getModelPahlawans().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPahlawan;
        private TextView tvNamaPahlawan, tvDetailPahlawan;
        private LinearLayout layoutItem;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPahlawan = itemView.findViewById(R.id.ivPahlawan);
            tvNamaPahlawan = itemView.findViewById(R.id.tvNamaPahlawan);
            //           tvDetailPahlawan = itemView.findViewById(R.id.tvDataPahlawan);
            layoutItem = itemView.findViewById(R.id.layoutItem);
        }
    }

    public ArrayList<modelPahlawan> getModelPahlawans() {
        return modelPahlawans;
    }

    public void setModelPahlawans(ArrayList<modelPahlawan> modelPahlawans) {
        this.modelPahlawans = modelPahlawans;
    }
}
