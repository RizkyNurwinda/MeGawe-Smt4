package com.example.megawe;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaCas;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.bumptech.glide.Glide;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

public class DetailLowongan extends AppCompatActivity {
    private TextView tjudul, tPerusahaan, tLokasi, tDesk, tPersyaratan, tKeahlian, tWaktu, tGaji, tInformasi;
    private ImageView iFoto;
    private Button bLamar;
    private String id;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_lowongan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarDetailLowonganKandidat);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        Intent i = getIntent();
        id = i.getStringExtra("id");

        tjudul = (TextView) findViewById(R.id.tvJudulLowonganKandidat);
        tPerusahaan = (TextView) findViewById(R.id.tvPerusahaanKandidat);
        tLokasi = (TextView) findViewById(R.id.tvLokasiLowonganKandidat);
        tDesk = (TextView) findViewById(R.id.tvDeskPekerjaanKandidat);
        tPersyaratan = (TextView) findViewById(R.id.tvPersyaratanLowonganKandidat);
        tKeahlian = (TextView) findViewById(R.id.tvKeahlianLowonganKandidat);
        tWaktu = (TextView) findViewById(R.id.tvWaktuKerjaLowonganKandidat);
        tGaji = (TextView) findViewById(R.id.tvGajiLowonganKandidat);
        tInformasi = (TextView) findViewById(R.id.tvInformasiPerusahaan);
        iFoto = (ImageView) findViewById(R.id.ivFotoPerusahaan);
        bLamar = (Button) findViewById(R.id.btnLamar);

    }

    private void setSupportActionBar(Toolbar toolbar) {
    }

    public String Rupiah ( double rupiah){
            DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
            DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

            formatRp.setCurrencySymbol("Rp. ");
            formatRp.setMonetaryDecimalSeparator(',');
            formatRp.setGroupingSeparator('.');

            kursIndonesia.setDecimalFormatSymbols(formatRp);

            String rp = kursIndonesia.format(rupiah);

            return rp;
        }
    }


