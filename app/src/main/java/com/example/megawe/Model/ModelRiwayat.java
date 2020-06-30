package com.example.megawe.Model;

public class ModelRiwayat {

    String namaPerusahan, gaji, tglDaftar, statusDaftar, keterangan;

    public ModelRiwayat(){}

    public ModelRiwayat(String namaPerusahan, String gaji, String tglDaftar, String statusDaftar, String keterangan) {
        this.namaPerusahan= namaPerusahan;
        this.gaji= gaji;
        this.tglDaftar= tglDaftar;
        this.statusDaftar = statusDaftar;
        this.keterangan = keterangan;
    }

    public String getNamaPerusahan() {
        return namaPerusahan;
    }

    public void setNamaPerusahan(String namaPerusahan) {
        this.namaPerusahan = namaPerusahan;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getTglDaftar() {
        return tglDaftar;
    }

    public void setTglDaftar(String tglDaftar) {
        this.tglDaftar = tglDaftar;
    }

    public String getStatusDaftar(){
        return statusDaftar;
    }

    public void setStatusDaftar(String statusDaftar){
        this.statusDaftar = statusDaftar;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }


}