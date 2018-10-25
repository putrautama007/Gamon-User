package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class History implements Serializable{
    private String namaBankSampah;
    private String lokasiBankSampah;
    private String tanggalTransaksi;
    private int poin;
    private String namaUser;
    private int beratKertas;
    private int beratBotol;
    private int hargaKertas;
    private int hargaBotol;
    private int totalHarga;

    public History(String namaBankSampah, String lokasiBankSampah, String tanggalTransaksi,
                   int poin, String namaUser, int beratKertas, int beratBotol, int hargaKertas, int hargaBotol, int totalHarga) {
        this.namaBankSampah = namaBankSampah;
        this.lokasiBankSampah = lokasiBankSampah;
        this.tanggalTransaksi = tanggalTransaksi;
        this.poin = poin;
        this.namaUser = namaUser;
        this.beratKertas = beratKertas;
        this.beratBotol = beratBotol;
        this.hargaKertas = hargaKertas;
        this.hargaBotol = hargaBotol;
        this.totalHarga = totalHarga;
    }

    public History(){

    }

    public String getNamaBankSampah() {
        return namaBankSampah;
    }

    public void setNamaBankSampah(String namaBankSampah) {
        this.namaBankSampah = namaBankSampah;
    }

    public String getLokasiBankSampah() {
        return lokasiBankSampah;
    }

    public void setLokasiBankSampah(String lokasiBankSampah) {
        this.lokasiBankSampah = lokasiBankSampah;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public int getBeratKertas() {
        return beratKertas;
    }

    public void setBeratKertas(int beratKertas) {
        this.beratKertas = beratKertas;
    }

    public int getBeratBotol() {
        return beratBotol;
    }

    public void setBeratBotol(int beratBotol) {
        this.beratBotol = beratBotol;
    }

    public int getHargaKertas() {
        return hargaKertas;
    }

    public void setHargaKertas(int hargaKertas) {
        this.hargaKertas = hargaKertas;
    }

    public int getHargaBotol() {
        return hargaBotol;
    }

    public void setHargaBotol(int hargaBotol) {
        this.hargaBotol = hargaBotol;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }
}
