package com.example.megawe;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.megawe.configfile.Util;

import java.util.List;

public class AdapterLowongan extends RecyclerView.Adapter<AdapterLowongan.HolderDataRiwayat> {
    private List<ModelLowongan> mItems;
    private Context context;

    public AdapterLowongan(Context context, List<ModelLowongan> mItems)
    {
        this.context = context;
        this.mItems = mItems;
    }
    @NonNull
    @Override
    public HolderDataRiwayat onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_lowongan, parent, false);
        HolderDataRiwayat holderDataRiwayat = new AdapterLowongan.HolderDataRiwayat(layout);
        return holderDataRiwayat;
    }

    @Override
    public void onBindViewHolder(@NonNull final HolderDataRiwayat holder, int position) {
        ModelLowongan me = mItems.get(position);
        holder.lowongan.setText(me.getLowongan());
        holder.deskripsi.setText(me.getDeskripsi());
        holder.tglPost.setText(Util.settanggal(me.getTglPost()));
        holder.status.setText(me.getStatus());
        holder.kota.setText(me.getKota());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class HolderDataRiwayat extends RecyclerView.ViewHolder {
        TextView lowongan, deskripsi, tglPost, status, kota;
        public HolderDataRiwayat(@NonNull View itemView) {
            super(itemView);
            lowongan = itemView.findViewById(R.id.lowongan);
            deskripsi = itemView.findViewById(R.id.tdeskripsi);
            tglPost = itemView.findViewById(R.id.tanggal);
            status = itemView.findViewById(R.id.status);
            kota = itemView.findViewById(R.id.kota);
        }
    }
}
