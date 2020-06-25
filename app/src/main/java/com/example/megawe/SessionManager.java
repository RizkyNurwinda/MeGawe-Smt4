package com.example.megawe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;

    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN_STATUS = "false";
    public static final String USERNAME = "USERNAME";
    public static final String ID_USER = "ID_USER";
    public static final String ID_AKSES = "ID_AKSES";
    public static final String NAMA = "NAMA";
    public static final String NO_IDENTITAS = "NO_IDENTITAS";
    public static final String JENIS_KELAMIN = "JENIS_KELAMIN";
    public static final String ALAMAT = "ALAMAT";
    public static final String NO_TLP = "NO_TLP";
    public static final String TEMPAT_LAHIR = "TEMPAT_LAHIR";
    public static final String TANGGAL_LAHIR = "TANGGAL_LAHIR";
    public static final String FOTO = "FOTO";
    public static final String EMAIL = "EMAIL";
    public static final String WEBSITE = "WEBSITE";
    public static final String TGLBERDIRI = "TGLBERDIRI";
    public static final String VISI = "VISI";
    public static final String MISI = "MISI";

    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String username, String id_user, String id_akses, String no_identitas, String nama, String jenis_kelamin, String alamat, String tanggal_lahir, String tempat_lahir, String no_tlp, String foto, String email, String webiste, String tgl_berdiri, String visi, String misi ) {
        editor.putBoolean(LOGIN_STATUS, true);
        editor.putString(USERNAME, username);
        editor.putString(NO_IDENTITAS, no_identitas);
        editor.putString(NAMA, nama);
        editor.putString(JENIS_KELAMIN, jenis_kelamin);
        editor.putString(ALAMAT, alamat);
        editor.putString(TANGGAL_LAHIR, tanggal_lahir);
        editor.putString(TEMPAT_LAHIR, tempat_lahir);
        editor.putString(NO_TLP, no_tlp);
        editor.putString(ID_USER, id_user);
        editor.putString(ID_AKSES, id_akses);
        editor.putString(FOTO, foto);
        editor.putString(EMAIL, email);
        editor.putString(WEBSITE, webiste);
        editor.putString(TGLBERDIRI, tgl_berdiri);
        editor.putString(VISI, visi);
        editor.putString(MISI, misi);
        editor.apply();
    }

    public boolean isLogin(){
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

    public void logout(){
        editor.clear();
        editor.commit();

        Intent login = new Intent(context, AddActivity.class);
        context.startActivity(login);
        ((AfterLoginActivity)context).finish();
    }

    public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN_STATUS,false);
    }
    public void checkLogin(){
        if(!this.isLoggin()){
            Intent kembaliLogin = new Intent(context, AddActivity.class);
            context.startActivity(kembaliLogin);
            ((AfterLoginActivity)context).finish();
        }
    }



    public HashMap<String, String> getUserDetail(){
        HashMap<String, String> user = new HashMap<>();
        user.put(ID_AKSES,sharedPreferences.getString(ID_AKSES,null));
        user.put(ID_USER,sharedPreferences.getString(ID_USER,null));
        user.put(USERNAME,sharedPreferences.getString(USERNAME,null));
        user.put(FOTO,sharedPreferences.getString(FOTO,null));

        return user;
    }



    public String getUsername() {
        return sharedPreferences.getString(USERNAME, null);
    }

    public String getNoIdentitas() {
        return sharedPreferences.getString(NO_IDENTITAS, null);
    }

    public String getNama() {
        return sharedPreferences.getString(NAMA, null);
    }

    public String getJenisKelamin() {
        return sharedPreferences.getString(JENIS_KELAMIN, null);
    }

    public String getAlamat() {
        return sharedPreferences.getString(ALAMAT, null);
    }

    public String getTempatLahir() {
        return sharedPreferences.getString(TEMPAT_LAHIR, null);
    }

    public String getTanggalLahir() {
        return sharedPreferences.getString(TANGGAL_LAHIR, null);
    }

    public String getNoTlp() {
        return sharedPreferences.getString(NO_TLP, null);
    }

    public String getIdUser() {
        return sharedPreferences.getString(ID_USER, null);
    }

    public String getIdAkses() {
        return sharedPreferences.getString(ID_AKSES, null);
    }

    public String getFoto() {
        return sharedPreferences.getString(FOTO, null);
    }
}
