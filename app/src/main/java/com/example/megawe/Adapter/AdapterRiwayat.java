package com.example.megawe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.megawe.Model.ModelRiwayat;
import com.example.megawe.R;
import java.util.List;

public class AdapterRiwayat extends RecyclerView.Adapter<AdapterRiwayat.HolderData> {
    private List<ModelRiwayat> mItems ;
    private Context context;

    public AdapterRiwayat(Context context, List<ModelRiwayat> items)
    {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lamaran_kandidat,parent,false);
        HolderData holderData = new HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(HolderData holder, int position) {
        ModelRiwayat md  = mItems.get(position);
        holder.tvJudulLamaran.setText(md.getNamaPerusahan());
        holder.tvGajiLamaran.setText(md.getGaji());
        holder.tvTanggalLamaran.setText(md.getTglDaftar());
        holder.tvStatusLamaran.setText(md.getStatusDaftar());
        holder.tvKeterangan.setText(md.getKeterangan());

        holder.md = md;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvJudulLamaran, tvGajiLamaran, tvTanggalLamaran,tvStatusLamaran,tvKeterangan;
        ModelRiwayat md;

        public  HolderData (View view)
        {
            super(view);
            tvJudulLamaran = (TextView) view.findViewById(R.id.tvJudulLamaran);
            tvGajiLamaran = (TextView) view.findViewById(R.id.tvGajiLamaran);
            tvTanggalLamaran = (TextView) view.findViewById(R.id.tvTanggalLamaran);
            tvStatusLamaran = (TextView) view.findViewById(R.id.tvStatusLamaran);
            tvKeterangan = (TextView) view.findViewById(R.id.tvKeterangan);


        }
    }

}