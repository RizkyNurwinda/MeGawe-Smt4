package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AddPekerjaanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pekerjaan);

        getSupportActionBar().setTitle("Lengkapi Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
