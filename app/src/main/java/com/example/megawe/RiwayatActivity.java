package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class RiwayatActivity extends AppCompatActivity implements View.OnClickListener {
    private Button edit, hapus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_riwayat);

        getSupportActionBar().setTitle("Riwayat");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edit=(Button) findViewById(R.id.btnedit);
        edit.setOnClickListener(this);

        hapus=(Button) findViewById(R.id.btnhapus);
        hapus.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnedit:
                Intent btnedit =new Intent(RiwayatActivity.this, EditActivity.class);
                startActivity(btnedit);
                break;
            case R.id.btnhapus:
                Intent btnhapus =new Intent(RiwayatActivity.this, HapusActivity.class);
                startActivity(btnhapus);
                break;

        }
    }
}
