package com.example.megawe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
import com.example.megawe.Model.ModelProfil;
import com.example.megawe.util.AppController;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class ProfilActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView mRecyclerview;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mManager;
    List<ModelProfil> mItems;
    ProgressDialog pd;
    SessionManager sessionManager;
    //String username, nama, id_user, id_akses, foto;

    private TextView id_user, no_identitas, nama, jenis_kelamin, ttl, no_hp, alamat, agama, email;
    private Button editProfil, logout;
    private ImageView foto;
    //SessionManager sessionManager;

    //private String mIdUser, mID, mNama, mJk, mTTL, mNo, mUsername, mAlamat, mFoto, mAgama, mEmail URL_FOTO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);

        initControl();

        sessionManager = new SessionManager(this);
        sessionManager.checkLogin();
        HashMap<String, String> user = sessionManager.getUserDetail();
        String mIdUser = user.get(sessionManager.ID_USER);
        String mIDMember = user.get(sessionManager.NO_IDENTITAS);
        String mNamaMember = user.get(sessionManager.NAMA);
        String mJk = user.get(sessionManager.JENIS_KELAMIN);
        String mTTL = user.get(sessionManager.TANGGAL_LAHIR);
        String mAlamat = user.get(sessionManager.ALAMAT);
        String mAgama = user.get(sessionManager.AGAMA);
        String mNo = user.get(sessionManager.NO_HP);
        String mEmail = user.get(sessionManager.EMAIL);
        String mFoto = user.get(sessionManager.FOTO);
//        String URL_FOTO = "http://192.168.43.2/MeGawe-Web-Smt4/assets/home/img/member"+mFoto;

        //set foto
//        Glide.with (ProfilActivity.this)
//                // LOAD URL DARI INTERNET
//                .load(URL_FOTO)
//                // LOAD GAMBAR AWAL SEBELUM GAMBAR UTAMA MUNCUL, BISA DARI LOKAL DAN INTERNET
//                .placeholder(R.drawable.ic_account_circle_black_24dp)
//                //. LOAD GAMBAR SAAT TERJADI KESALAHAN MEMUAT GMBR UTAMA
//                .error(R.drawable.ic_account_circle_black_24dp)
//                .into(foto);
        no_identitas.setText(mIDMember);
        nama.setText(mNamaMember);
        jenis_kelamin.setText(mJk);
        ttl.setText(mTTL);
        no_hp.setText(mNo);
        alamat.setText(mAlamat);
        agama.setText(mAgama);
        email.setText(mEmail);
    }

    private void initControl() {
        foto = (ImageView) findViewById(R.id.ivfoto);
        no_identitas = (TextView) findViewById(R.id.tvID);
        nama = (TextView) findViewById(R.id.tvNama);
        jenis_kelamin = (TextView) findViewById(R.id.tvJK);
        ttl = (TextView) findViewById(R.id.tvTTL);
        no_hp = (TextView) findViewById(R.id.tvNoHp);
        alamat = (TextView) findViewById(R.id.tvAlamat);
        email = (TextView) findViewById(R.id.tvEmail);
        agama = (TextView) findViewById(R.id.tvAgama);
        editProfil = (Button) findViewById(R.id.editProfil);
        editProfil.setOnClickListener(this);
        logout = (Button) findViewById(R.id.logout);
        logout.setOnClickListener(this);

    }

    private void loadJson()
    {
        pd.setMessage("Mengambil Data");
        pd.setCancelable(false);
        pd.show();

        JsonArrayRequest reqData = new JsonArrayRequest(Request.Method.POST, konfigurasi.URL_PROFIL,null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        pd.cancel();
                        Log.d("volley","response : " + response.toString());
                        for(int i = 0 ; i < response.length(); i++)
                        {
                            try {
                                JSONObject data = response.getJSONObject(i);
                                ModelProfil md = new ModelProfil();
                                md.setNo_identitas(data.getString("idMember"));
                                md.setNama(data.getString("namaMember"));
                                md.setJenis_kelamin(data.getString("jenisKelamin"));
                                md.setTanggal_lahir(data.getString("tanggalLahir"));
                                md.setAgama(data.getString("agama"));
                                md.setAlamat(data.getString("alamat"));
                                md.setNo_hp(data.getString("noTelp"));
                                md.setEmail(data.getString("email"));
                                md.setFoto(data.getString("fotoMember"));
                                mItems.add(md);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                        mAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        pd.cancel();
                        Log.d("volley", "error : " + error.getMessage());
                    }
                });

        AppController.getInstance().addToRequestQueue(reqData);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.editProfil:
                Intent edit = new Intent(ProfilActivity.this, EditProfil.class);
                startActivity(edit);
                break;
            case R.id.logout:
                sessionManager.logout();
                finish();
                break;
        }
    }

}