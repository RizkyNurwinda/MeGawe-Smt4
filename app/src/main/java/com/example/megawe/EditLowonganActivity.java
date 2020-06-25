package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class EditLowonganActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_lowongan);

        getSupportActionBar().setTitle("Ubah Data");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
