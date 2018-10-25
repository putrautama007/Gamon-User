package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class BankList implements Serializable {
    private int fotoBank;
    private String namaBank;
    private String alamatBank;
    private int saldo;
    private String tglMasuk;

    public BankList(int fotoBank, String namaBank, String alamatBank, int saldo, String tglMasuk) {
        this.fotoBank = fotoBank;
        this.namaBank = namaBank;
        this.alamatBank = alamatBank;
        this.saldo = saldo;
        this.tglMasuk = tglMasuk;
    }

    public int getFotoBank() {
        return fotoBank;
    }

    public void setFotoBank(int fotoBank) {
        this.fotoBank = fotoBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getAlamatBank() {
        return alamatBank;
    }

    public void setAlamatBank(String alamatBank) {
        this.alamatBank = alamatBank;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getTglMasuk() {
        return tglMasuk;
    }

    public void setTglMasuk(String tglMasuk) {
        this.tglMasuk = tglMasuk;
    }
}
