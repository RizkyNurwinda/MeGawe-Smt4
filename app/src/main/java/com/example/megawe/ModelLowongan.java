package com.example.megawe;

public class ModelLowongan {
    private String lowongan;
    private String deskripsi;
    private String tglPost;
    private String status;
    private String kota;

    public String getTglPost() {
        return tglPost;
    }

    public void setTglPost(String tglPost) {
        this.tglPost = tglPost;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLowongan() {
        return lowongan;
    }

    public void setLowongan(String lowongan) {
        this.lowongan = lowongan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }
}
