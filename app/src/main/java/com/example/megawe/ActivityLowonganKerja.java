package com.example.megawe;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.megawe.AddActivity.fromHtml;

public class ActivityLowonganKerja extends AppCompatActivity  {
    RecyclerView recyclerView;
    List<ModelLowongan> modelDataList;
    AdapterLowongan adapterLowongan;
   // public static final String IPServer = "http://mamij.mif-project.com/RestApi/api/lowongan";
   public static final String IPServer = "http://192.168.42.141/MeGawe-Web-Smt4/RestApi/api/lowongan";
//    public static final String IPServer = "http://192.168.43.2/MeGawe-Web-Smt4/RestApi/api/lowongan";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lowongan_kerja);
        recyclerView = findViewById(R.id.recycler);


        loaddetail();


    }

    public void loaddetail() {
        StringRequest senddata = new StringRequest(Request.Method.GET, IPServer, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONObject res = null;
                try {
                    JSONObject obj = new JSONObject(response);

                    modelDataList = new ArrayList<>();
                    JSONArray data = obj.getJSONArray("data");
                    for (int i = 0; i < data.length(); i++) {
                        ModelLowongan playerModel = new ModelLowongan();
                        JSONObject dataobj = data.getJSONObject(i);
                        playerModel.setLowongan(dataobj.getString("lowongan"));
                        playerModel.setDeskripsi(dataobj.getString("deskripsi"));
                        playerModel.setTglPost(dataobj.getString("tglPost"));
                        playerModel.setStatus(dataobj.getString("status"));
                        playerModel.setKota(dataobj.getString("kota"));


                        modelDataList.add(playerModel);
                    }
                    setupListView();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("volley", "errornya : " + error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(senddata);
    }

    private void setupListView() {
        adapterLowongan = new AdapterLowongan(this, modelDataList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapterLowongan);
    }

}