package com.pau.putrautama.gamon.ui.model;

public class TransaksiTabung {
    String idTransaksi;
    String namaUser;
    String namaBankSampah;
    String tglTransaksi;
    String statusTransaksi;
    int beratKertas;
    int hargaKertas;
    int beratBotol;
    int hargaBotol;
    int hargaTotal;
    int poin;
    int saldo;

    public TransaksiTabung(String idTransaksi, String namaUser, String namaBankSampah,
                           String tglTransaksi, String statusTransaksi, int beratKertas,
                           int hargaKertas, int beratBotol, int hargaBotol, int hargaTotal,
                           int poin, int saldo) {
        this.idTransaksi = idTransaksi;
        this.namaUser = namaUser;
        this.namaBankSampah = namaBankSampah;
        this.tglTransaksi = tglTransaksi;
        this.statusTransaksi = statusTransaksi;
        this.beratKertas = beratKertas;
        this.hargaKertas = hargaKertas;
        this.beratBotol = beratBotol;
        this.hargaBotol = hargaBotol;
        this.hargaTotal = hargaTotal;
        this.poin = poin;
        this.saldo = saldo;
    }

    public TransaksiTabung() {
    }

    public String getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(String idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public String getNamaUser() {
        return namaUser;
    }

    public void setNamaUser(String namaUser) {
        this.namaUser = namaUser;
    }

    public String getNamaBankSampah() {
        return namaBankSampah;
    }

    public void setNamaBankSampah(String namaBankSampah) {
        this.namaBankSampah = namaBankSampah;
    }

    public String getTglTransaksi() {
        return tglTransaksi;
    }

    public void setTglTransaksi(String tglTransaksi) {
        this.tglTransaksi = tglTransaksi;
    }

    public String getStatusTransaksi() {
        return statusTransaksi;
    }

    public void setStatusTransaksi(String statusTransaksi) {
        this.statusTransaksi = statusTransaksi;
    }

    public int getBeratKertas() {
        return beratKertas;
    }

    public void setBeratKertas(int beratKertas) {
        this.beratKertas = beratKertas;
    }

    public int getHargaKertas() {
        return hargaKertas;
    }

    public void setHargaKertas(int hargaKertas) {
        this.hargaKertas = hargaKertas;
    }

    public int getBeratBotol() {
        return beratBotol;
    }

    public void setBeratBotol(int beratBotol) {
        this.beratBotol = beratBotol;
    }

    public int getHargaBotol() {
        return hargaBotol;
    }

    public void setHargaBotol(int hargaBotol) {
        this.hargaBotol = hargaBotol;
    }

    public int getHargaTotal() {
        return hargaTotal;
    }

    public void setHargaTotal(int hargaTotal) {
        this.hargaTotal = hargaTotal;
    }

    public int getPoin() {
        return poin;
    }

    public void setPoin(int poin) {
        this.poin = poin;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
