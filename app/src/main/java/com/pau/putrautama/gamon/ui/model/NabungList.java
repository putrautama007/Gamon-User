package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class NabungList implements Serializable {

    private String namaBankSampah;
    private String lokasiBankSampah;
    private String tanggalTransaksi;
    private String tipeTransaksi;
    private int poinNabung;
    private String namaUser;
    private int transaksiId;
    private int beratKertas;
    private int beratBotol;
    private int hargaKertas;
    private int hargaBotol;
    private int totalHarga;
    private int totalSaldo;

    public NabungList(String namaBankSampah, String lokasiBankSampah, String tanggalTransaksi,
                      String tipeTransaksi, int poinNabung, String namaUser, int transaksiId,
                      int beratKertas, int beratBotol, int hargaKertas, int hargaBotol,
                      int totalHarga, int totalSaldo) {
        this.namaBankSampah = namaBankSampah;
        this.lokasiBankSampah = lokasiBankSampah;
        this.tanggalTransaksi = tanggalTransaksi;
        this.tipeTransaksi = tipeTransaksi;
        this.poinNabung = poinNabung;
        this.namaUser = namaUser;
        this.transaksiId = transaksiId;
        this.beratKertas = beratKertas;
        this.beratBotol = beratBotol;
        this.hargaKertas = hargaKertas;
        this.hargaBotol = hargaBotol;
        this.totalHarga = totalHarga;
        this.totalSaldo = totalSaldo;
    }

    public NabungList() {
    }

    public String getTipeTransaksi() {
        return tipeTransaksi;
    }

    public void setTipeTransaksi(String tipeTransaksi) {
        this.tipeTransaksi = tipeTransaksi;
    }

    public int getTransaksiId() {
        return transaksiId;
    }

    public void setTransaksiId(int transaksiId) {
        this.transaksiId = transaksiId;
    }

    public int getTotalSaldo() {
        return totalSaldo;
    }

    public void setTotalSaldo(int totalSaldo) {
        this.totalSaldo = totalSaldo;
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

    public int getPoinNabung() {
        return poinNabung;
    }

    public void setPoinNabung(int poinNabung) {
        this.poinNabung = poinNabung;
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
