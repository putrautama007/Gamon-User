package com.pau.putrautama.gamon.ui.model;

public class BankSampah {

    private String namaBankSampah;
    private String bankSampahEmail;
    private String bankSampahNoTlp;
    private String alamatBank;
    private double latitude;
    private double longitude;
    private boolean menerimaSampahKertas;
    private boolean menerimaSampahPlastik;
    private String hargaSampahKertas;
    private String hargaSampahPlastik;

    public BankSampah(String namaBankSampah, String bankSampahEmail, String bankSampahNoTlp,
                      String alamatBank, double latitude, double longitude,
                      boolean menerimaSampahKertas, boolean menerimaSampahPlastik,
                      String hargaSampahKertas, String hargaSampahPlastik) {
        this.namaBankSampah = namaBankSampah;
        this.bankSampahEmail = bankSampahEmail;
        this.bankSampahNoTlp = bankSampahNoTlp;
        this.alamatBank = alamatBank;
        this.latitude = latitude;
        this.longitude = longitude;
        this.menerimaSampahKertas = menerimaSampahKertas;
        this.menerimaSampahPlastik = menerimaSampahPlastik;
        this.hargaSampahKertas = hargaSampahKertas;
        this.hargaSampahPlastik = hargaSampahPlastik;
    }

    public BankSampah() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getNamaBankSampah() {
        return namaBankSampah;
    }

    public void setNamaBankSampah(String namaBankSampah) {
        this.namaBankSampah = namaBankSampah;
    }

    public String getBankSampahEmail() {
        return bankSampahEmail;
    }

    public void setBankSampahEmail(String bankSampahEmail) {
        this.bankSampahEmail = bankSampahEmail;
    }

    public String getBankSampahNoTlp() {
        return bankSampahNoTlp;
    }

    public void setBankSampahNoTlp(String bankSampahNoTlp) {
        this.bankSampahNoTlp = bankSampahNoTlp;
    }

    public String getAlamatBank() {
        return alamatBank;
    }

    public void setAlamatBank(String alamatBank) {
        this.alamatBank = alamatBank;
    }

    public boolean isMenerimaSampahKertas() {
        return menerimaSampahKertas;
    }

    public void setMenerimaSampahKertas(boolean menerimaSampahKertas) {
        this.menerimaSampahKertas = menerimaSampahKertas;
    }

    public boolean isMenerimaSampahPlastik() {
        return menerimaSampahPlastik;
    }

    public void setMenerimaSampahPlastik(boolean menerimaSampahPlastik) {
        this.menerimaSampahPlastik = menerimaSampahPlastik;
    }

    public String getHargaSampahKertas() {
        return hargaSampahKertas;
    }

    public void setHargaSampahKertas(String hargaSampahKertas) {
        this.hargaSampahKertas = hargaSampahKertas;
    }

    public String getHargaSampahPlastik() {
        return hargaSampahPlastik;
    }

    public void setHargaSampahPlastik(String hargaSampahPlastik) {
        this.hargaSampahPlastik = hargaSampahPlastik;
    }
}
