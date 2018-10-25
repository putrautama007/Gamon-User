package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class MapList implements Serializable {

    private String namaBank;
    private String fotoBank;
    private String lokasiBank;
    private String jamBuka;
    private String LatLing;
    private boolean sampahKertas;
    private boolean sampahBotol;
    private int hargaKertas;
    private int hargaBotol;

    public MapList(String namaBank, String fotoBank, String lokasiBank, String jamBuka,
                   String latLing, boolean sampahKertas, boolean sampahBotol, int hargaKertas,
                   int hargaBotol) {
        this.namaBank = namaBank;
        this.fotoBank = fotoBank;
        this.lokasiBank = lokasiBank;
        this.jamBuka = jamBuka;
        LatLing = latLing;
        this.sampahKertas = sampahKertas;
        this.sampahBotol = sampahBotol;
        this.hargaKertas = hargaKertas;
        this.hargaBotol = hargaBotol;
    }

    public MapList() {
    }

    public String getLatLing() {
        return LatLing;
    }

    public void setLatLing(String latLing) {
        LatLing = latLing;
    }

    public String getLokasiBank() {
        return lokasiBank;
    }

    public void setLokasiBank(String lokasiBank) {
        this.lokasiBank = lokasiBank;
    }

    public String getNamaBank() {
        return namaBank;
    }

    public void setNamaBank(String namaBank) {
        this.namaBank = namaBank;
    }

    public String getFotoBank() {
        return fotoBank;
    }

    public void setFotoBank(String fotoBank) {
        this.fotoBank = fotoBank;
    }

    public String getJamBuka() {
        return jamBuka;
    }

    public void setJamBuka(String jamBuka) {
        this.jamBuka = jamBuka;
    }

    public boolean isSampahKertas() {
        return sampahKertas;
    }

    public void setSampahKertas(boolean sampahKertas) {
        this.sampahKertas = sampahKertas;
    }

    public boolean isSampahBotol() {
        return sampahBotol;
    }

    public void setSampahBotol(boolean sampahBotol) {
        this.sampahBotol = sampahBotol;
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
}
