package com.example.megawe.Model;

public class ModelRiwayat {

    String tglDaftar, statusDaftar, keterangan;

    public ModelRiwayat(){}

    public ModelRiwayat(String tglDaftar, String statusDaftar, String keterangan) {
        this.tglDaftar= tglDaftar;
        this.statusDaftar = statusDaftar;
        this.keterangan = keterangan;
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
