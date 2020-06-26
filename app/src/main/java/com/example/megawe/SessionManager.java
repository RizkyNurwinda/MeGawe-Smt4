package com.example.megawe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

class SessionManager {
//    deklarasi sharedpref untuk menyimpan session login
    SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;

    //    nama untuk tiap shared pref
    public static final String PREF_NAME = "LOGIN";
    public static final String LOGIN_STATUS = "LOGIN_STATUS";
    public static final String ID_USER = "ID_USER";
    public static final String USERNAME = "USERNAME";
    public static final String LEVEL = "LEVEL";

//  constructor session manager
    public SessionManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

//    fungsi untuk menyimpan session login
    public void createSession(String id_user, String username, String level) {
        editor.putBoolean(LOGIN_STATUS, true);
        editor.putString(ID_USER, id_user);
        editor.putString(USERNAME, username);
        editor.putString(LEVEL, level);
        editor.apply();
    }

//    fungsi untuk cek apakah user sudah login
    public boolean isLogin() {
        return sharedPreferences.getBoolean(LOGIN_STATUS, false);
    }

//    fungsi untuk logout
    public void logout() {
        editor.clear();
        editor.commit();

        Intent login = new Intent(context, AddActivity.class);
        context.startActivity(login);
        ((AfterLoginActivity) context).finish();
    }

//    fungsi getter dari atribut class session manager
    public String getIdUser() {
        return sharedPreferences.getString(ID_USER, null);
    }

    public String getUSERNAME() {
        return sharedPreferences.getString(USERNAME, null);
    }

    public String getLEVEL() {
        return sharedPreferences.getString(LEVEL, null);
    }
}
