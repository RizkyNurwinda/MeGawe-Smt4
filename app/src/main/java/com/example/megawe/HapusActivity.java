package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class HapusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hapus);

        getSupportActionBar().setTitle("Hapus Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
