package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener {


    SessionManager sessionManager;
    //String username, nama, id_user, id_akses, foto;

    private TextView id_user, nama, alamat, notlp, email, website, tglbediri, visi, misi;
    private Button editProfil, logout;
    //SessionManager sessionManager;

    private String mIduser, mNama,mAlamat, mNotlp, mEmail, mWebsite, mTglberdiri, mVisi, mMisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initControl();

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetail();
        mIduser = user.get(sessionManager.ID_USER);
        mNama = user.get(sessionManager.NAMA);
        mAlamat = user.get(sessionManager.JENIS_KELAMIN);
        mNotlp = user.get(sessionManager.NO_TLP);
        mEmail = user.get(sessionManager.EMAIL);
        mWebsite = user.get(sessionManager.WEBSITE);
        mTglberdiri = user.get(sessionManager.TGLBERDIRI);
        mVisi = user.get(sessionManager.VISI);
        mMisi = user.get(sessionManager.MISI);

        //set nama dari session
        nama.setText(mNama);
        alamat.setText(mAlamat);
        notlp.setText(mNotlp);
        email.setText(mEmail);
        website.setText(mWebsite);
        tglbediri.setText(mTglberdiri);
        visi.setText(mVisi);
        misi.setText(mMisi);
    }

    private void initControl() {
        nama = (TextView) findViewById(R.id.tv_nama);
        notlp = (TextView) findViewById(R.id.tv_notlp);
        email = (TextView) findViewById(R.id.tv_email);
        website = (TextView) findViewById(R.id.tv_website);
        tglbediri = (TextView) findViewById(R.id.tv_tglberdiri);
        visi = (TextView) findViewById(R.id.tv_visi);
        misi = (TextView) findViewById(R.id.tv_misi);
        alamat = (TextView) findViewById(R.id.alamat);
        editProfil = (Button) findViewById(R.id.btnedit);
        editProfil.setOnClickListener(this);
        logout = (Button) findViewById(R.id.btnlogout);
        logout.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnedit:
                Intent edit = new Intent(ProfilActivity.this, EditProfil.class);
                startActivity(edit);
                break;
            case R.id.btnlogout:
                sessionManager.logout();
                finish();
                break;
        }
    }

}


