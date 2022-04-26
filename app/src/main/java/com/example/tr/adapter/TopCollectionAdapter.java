package com.example.tr.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tr.R;
import com.example.tr.model.RecentsData;
import com.example.tr.model.TopCollectionData;

import java.util.List;

public class TopCollectionAdapter extends RecyclerView.Adapter<TopCollectionAdapter.TopCollectionViewHolder> {

    Context context;
    List<TopCollectionData> topCollectionDataList;

    public TopCollectionAdapter(Context context, List<TopCollectionData> topCollectionDataList) {
        this.context = context;
        this.topCollectionDataList = topCollectionDataList;
    }

    @NonNull
    @Override
    public TopCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_collection_row_item, parent, false);
        return new TopCollectionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopCollectionViewHolder holder, int position) {

        holder.judul.setText(topCollectionDataList.get(position).getJudul());
        holder.profil.setImageResource(topCollectionDataList.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return topCollectionDataList.size();
    }

    public static final class TopCollectionViewHolder extends RecyclerView.ViewHolder{

        ImageView profil;
        TextView judul;

        public TopCollectionViewHolder(@NonNull View itemView) {
            super(itemView);

            profil = itemView.findViewById(R.id.profil);
            judul = itemView.findViewById(R.id.judul);
        }
    }

}
