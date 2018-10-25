package com.pau.putrautama.gamon.ui.model;

import java.io.Serializable;

public class VoucherList implements Serializable {
    private String judulVoucher;
    private int gambarVoucher;
    private int poinVoucher;
    private String deskripsi;
    private String syarat1;
    private String syarat2;
    private String syarat3;
    private String syarat4;
    private String syarat5;

    public VoucherList(String judulVoucher, int gambarVoucher, int poinVoucher, String deskripsi,
                       String syarat1, String syarat2, String syarat3, String syarat4, String syarat5) {
        this.judulVoucher = judulVoucher;
        this.gambarVoucher = gambarVoucher;
        this.poinVoucher = poinVoucher;
        this.deskripsi = deskripsi;
        this.syarat1 = syarat1;
        this.syarat2 = syarat2;
        this.syarat3 = syarat3;
        this.syarat4 = syarat4;
        this.syarat5 = syarat5;
    }

    public VoucherList() {
    }

    public int getPoinVoucher() {
        return poinVoucher;
    }

    public void setPoinVoucher(int poinVoucher) {
        this.poinVoucher = poinVoucher;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getSyarat1() {
        return syarat1;
    }

    public void setSyarat1(String syarat1) {
        this.syarat1 = syarat1;
    }

    public String getSyarat2() {
        return syarat2;
    }

    public void setSyarat2(String syarat2) {
        this.syarat2 = syarat2;
    }

    public String getSyarat3() {
        return syarat3;
    }

    public void setSyarat3(String syarat3) {
        this.syarat3 = syarat3;
    }

    public String getSyarat4() {
        return syarat4;
    }

    public void setSyarat4(String syarat4) {
        this.syarat4 = syarat4;
    }

    public String getSyarat5() {
        return syarat5;
    }

    public void setSyarat5(String syarat5) {
        this.syarat5 = syarat5;
    }

    public String getJudulVoucher() {
        return judulVoucher;
    }

    public void setJudulVoucher(String judulVoucher) {
        this.judulVoucher = judulVoucher;
    }

    public int getGambarVoucher() {
        return gambarVoucher;
    }

    public void setGambarVoucher(int gambarVoucher) {
        this.gambarVoucher = gambarVoucher;
    }
}
