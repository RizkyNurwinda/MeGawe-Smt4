package com.example.megawe.Model;

public class ModelProfil {

    String tanggal_lahir, no_identitas, nama, jenis_kelamin, no_hp, alamat, foto, agama, email;

    public ModelProfil() {
    }

    public ModelProfil(String tanggal_lahir, String no_identitas, String nama, String jenis_kelamin, String no_hp, String alamat, String foto,  String agama, String email) {
        this.no_identitas = no_identitas;
        this.nama = nama;
        this.jenis_kelamin = jenis_kelamin;
        this.no_hp = no_hp;
        this.alamat = alamat;
        this.foto = foto;
        this.tanggal_lahir = tanggal_lahir;
        this.agama = agama;
        this.email = email;

    }

    public String getNo_identitas() {
        return no_identitas;
    }

    public void setNo_identitas(String no_identitas) {
        this.no_identitas = no_identitas;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getNo_hp() {
        return no_hp;
    }

    public void setNo_hp(String no_hp) {
        this.no_hp = no_hp;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getTanggal_lahir() {
        return tanggal_lahir;
    }

    public void setTanggal_lahir(String tanggal_lahir) {
        this.tanggal_lahir = tanggal_lahir;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

}