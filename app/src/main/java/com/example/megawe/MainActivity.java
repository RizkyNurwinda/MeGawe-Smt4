
package com.example.megawe;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener  {

    private Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1=(Button) findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(MainActivity.this, ActivityLowonganKerja.class);
                startActivity(a);
            }
        });

        btn2=(Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        btn3=(Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);

        btn4=(Button) findViewById(R.id.btn4);
        btn4.setOnClickListener(this);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                Intent rekomendasi =new Intent(MainActivity.this, ActivityLowonganKerja.class);
                startActivity(rekomendasi);
                break;
            case R.id.btn2:
                Intent pesan =new Intent(MainActivity.this, PesanActivity.class);
                startActivity(pesan);
                break;
            case R.id.btn3:
                Intent add= new Intent(MainActivity.this, RiwayatActivity.class);
                startActivity(add);
                break;
            case R.id.btn4:
                Intent profil= new Intent(MainActivity.this, ProfilActivity.class);
                startActivity(profil);
                break;

        }
    }
}