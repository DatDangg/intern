package com.bctt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class MonTonDong {
    @Id
    private String maMonTonDong;
    private  String tenMonTon;

    @ManyToOne
    @JoinColumn(name = "maNganh", nullable = false)
    private Nganh nganh;
    private String ghiChu;
    private String tiLe;

    public MonTonDong(){}
    public MonTonDong(String maMonTonDong, Nganh nganh, String ghiChu, String tiLe, String tenMonTon) {
        this.maMonTonDong = maMonTonDong;
        this.nganh = nganh;
        this.ghiChu = ghiChu;
        this.tiLe = tiLe;
        this.tenMonTon = tenMonTon;
    }

    public String getTenMonTon() {
        return tenMonTon;
    }

    public void setTenMonTon(String tenMonTon) {
        this.tenMonTon = tenMonTon;
    }

    public String getMaMonTonDong() {
        return maMonTonDong;
    }

    public void setMaMonTonDong(String maMonTonDong) {
        this.maMonTonDong = maMonTonDong;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTiLe() {
        return tiLe;
    }

    public void setTiLe(String tiLe) {
        this.tiLe = tiLe;
    }
}
