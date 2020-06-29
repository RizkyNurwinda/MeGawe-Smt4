package com.example.megawe;

public class konfigurasi {
    public static final String URL_ADD="http://192.168.1.9/Android/pegawai/tambahPgw.php";
    public static final String URL_GET_ALL = "http://192.168.1.9/Android/pegawai/tampilSemuaPgw.php";
    public static final String URL_GET_EMP = "http://192.168.1.9/Android/pegawai/tampilPgw.php?id=";
    public static final String URL_UPDATE_EMP = "http://192.168.1.9/Android/pegawai/updatePgw.php";
    public static final String URL_DELETE_EMP = "http://192.168.1.9/Android/pegawai/hapusPgw.php?id=";

    //    ip dirubah sesuai laptop masing" sesuai ip local
   // public static final String URL_LOGIN = "http://mamij.mif-project.com/Api/LoginApi";
    //public static final String URL_REGISTER = "http://mamij.mif-project.com/Api/RegisterApi";
   // public static final String URL_PROFIL = "http://mamij.mif-project.com/Api/Profil";

    public static final String URL_LOGIN = "http://192.168.42.185/MeGawe-Web-Smt4/Api/LoginApi";
    public static final String URL_REGISTER = "http://192.168.42.185/MeGawe-Web-Smt4/Api/RegisterApi";
    public static final String URL_PROFIL = "http://192.168.42.185/MeGawe-Web-Smt4/Api/Profil";

    //Dibawah ini merupakan Kunci yang akan digunakan untuk mengirim permintaan ke Skrip PHP
    public static final String KEY_EMP_ID = "id";
    public static final String KEY_EMP_NAMA = "name";
    public static final String KEY_EMP_POSISI = "desg"; //desg itu variabel untuk posisi
    public static final String KEY_EMP_GAJIH = "salary"; //salary itu variabel untuk gajih

    //JSON Tags
    public static final String TAG_JSON_ARRAY="result";
    public static final String TAG_ID = "id";
    public static final String TAG_NAMA = "name";
    public static final String TAG_POSISI = "desg";
    public static final String TAG_GAJIH = "salary";

    //ID karyawan
    //emp itu singkatan dari Employee
    public static final String EMP_ID = "emp_id";
}