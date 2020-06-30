package com.example.megawe.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.megawe.Model.ModelProfil;
import com.example.megawe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterProfil extends RecyclerView.Adapter<AdapterProfil.HolderData> {
    private List<ModelProfil> mItems ;
    private Context context;

    public AdapterProfil(Context context, List<ModelProfil> items)
    {
        this.mItems = items;
        this.context = context;
    }

    @Override
    public AdapterProfil.HolderData onCreateViewHolder(ViewGroup parent, int viewType) {
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_profil,parent,false);
        AdapterProfil.HolderData holderData = new AdapterProfil.HolderData(layout);
        return holderData;
    }

    @Override
    public void onBindViewHolder(AdapterProfil.HolderData holder, int position) {
        ModelProfil md  = mItems.get(position);
//        holder.ivfoto.setImageURI(md.getFoto());
//        Glide.with(context).load(md.getFoto()).into(holder.ivfoto);
//        Picasso.get().load(md.getFoto()).into(holder.ivfoto);
        holder.tvno_identitas.setText(md.getNo_identitas());
        holder.tvnama.setText(md.getNama());
        holder.tvjenis_kelamin.setText(md.getJenis_kelamin());
        holder.tvno_hp.setText(md.getNo_hp());
        holder.tvalamat.setText(md.getAlamat());
        holder.tvtanggal_lahir.setText(md.getTanggal_lahir());
        holder.tvagama.setText(md.getAgama());
        holder.tvemail.setText(md.getEmail());

        holder.md = md;
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class HolderData extends RecyclerView.ViewHolder
    {
        TextView tvtanggal_lahir, tvno_identitas, tvnama, tvjenis_kelamin, tvno_hp, tvalamat, tvagama, tvemail;
        ImageView ivfoto;
        ModelProfil md;

        public  HolderData (View view)
        {
            super(view);

            ivfoto = (ImageView) view.findViewById(R.id.ivfoto);
            tvno_identitas = (TextView) view.findViewById(R.id.tvID);
            tvtanggal_lahir = (TextView) view.findViewById(R.id.tvTTL);
            tvnama = (TextView) view.findViewById(R.id.tvNama);
            tvjenis_kelamin = (TextView) view.findViewById(R.id.tvJK);
            tvno_hp = (TextView) view.findViewById(R.id.tvNoHp);
            tvalamat = (TextView) view.findViewById(R.id.tvAlamat);
            tvagama = (TextView) view.findViewById(R.id.tvAgama);
            tvemail = (TextView) view.findViewById(R.id.tvEmail);


        }
    }
}