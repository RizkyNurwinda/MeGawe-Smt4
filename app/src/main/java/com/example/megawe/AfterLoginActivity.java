package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AfterLoginActivity extends AppCompatActivity implements View.OnClickListener {
//    sessionmanager dipakai pada activity ini untuk process logout
    SessionManager sessionManager;

    private Button TambahPekerjaan, Riwayat, Profil, Logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login);

//        menyambungkan sessionmanager pada context class ini
//        dengan instance constructor
        sessionManager = new SessionManager(this);

        TambahPekerjaan=(Button) findViewById(R.id.TambahPekerjaan);
        TambahPekerjaan.setOnClickListener(this);

        Riwayat=(Button) findViewById(R.id.Riwayat);
        Riwayat.setOnClickListener(this);

        Profil=(Button) findViewById(R.id.Profil);
        Profil.setOnClickListener(this);

        Logout = findViewById(R.id.btnLogout);
        Logout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.TambahPekerjaan:
                Intent rekomendasi =new Intent(AfterLoginActivity.this, AddPekerjaanActivity.class);
                startActivity(rekomendasi);
                break;
            case R.id.Riwayat:
                Intent pesan =new Intent(AfterLoginActivity.this, RiwayatActivity.class);
                startActivity(pesan);
                break;
            case R.id.Profil:
                Intent add= new Intent(AfterLoginActivity.this, ProfilActivity.class);
                startActivity(add);
                break;
            case R.id.btnLogout:
                sessionManager.logout();
                break;
        }
    }
}

