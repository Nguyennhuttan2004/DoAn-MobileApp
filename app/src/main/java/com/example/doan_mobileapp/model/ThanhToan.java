package com.example.doan_mobileapp.model;

import java.io.Serializable;

public class ThanhToan implements Serializable {
    private int ptid;
    private String phuongthuc;
    private int hinh;

    public ThanhToan() {}
    public ThanhToan(int ptid, String phuongthuc, int hinh) {
        this.ptid = ptid;
        this.phuongthuc = phuongthuc;
        this.hinh = hinh;
    }

    public int getPtid() {
        return ptid;
    }
    public void setPtid(int ptid) {
        this.ptid = ptid;
    }
    public String getPhuongthuc() {
        return phuongthuc;
    }
    public void setPhuongthuc(String phuongthuc) {
        this.phuongthuc = phuongthuc;
    }
    public int getHinh() {
        return hinh;
    }
    public void setHinh(int hinh) {
        this.hinh = hinh;
    }
}
