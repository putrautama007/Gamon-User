package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class MendaftarUser implements Serializable {
    private String idUser;
    private String namaBankSampah;
    private String namaUser;
    private String tglBergabung;
    private int jumlahKertas;
    private int jumlahBlastik;
    private int saldo;


    public MendaftarUser(String idUser, String namaBankSampah, String namaUser, String tglBergabung, int jumlahKertas, int jumlahBlastik, int saldo) {
        this.idUser = idUser;
        this.namaBankSampah = namaBankSampah;
        this.namaUser = namaUser;
        this.tglBergabung = tglBergabung;
        this.jumlahKertas = jumlahKertas;
        this.jumlahBlastik = jumlahBlastik;
        this.saldo = saldo;
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

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getTglBergabung() {
        return tglBergabung;
    }

    public void setTglBergabung(String tglBergabung) {
        this.tglBergabung = tglBergabung;
    }

    public int getJumlahKertas() {
        return jumlahKertas;
    }

    public void setJumlahKertas(int jumlahKertas) {
        this.jumlahKertas = jumlahKertas;
    }

    public int getJumlahBlastik() {
        return jumlahBlastik;
    }

    public void setJumlahBlastik(int jumlahBlastik) {
        this.jumlahBlastik = jumlahBlastik;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
}
