package com.bctt.dto.request;

import com.bctt.model.Nganh;
import jakarta.persistence.ManyToOne;

public class MonTDRequest {
    private String maMonTonDong;
    private String tenMonTon;
    private String ghiChu;
    private String tiLe;
    private String maNganh;

    public MonTDRequest() {}
    public MonTDRequest(String maMonTonDong, String tenMonTon, String ghiChu, String tiLe,String maNganh) {
        this.maMonTonDong = maMonTonDong;
        this.tenMonTon = tenMonTon;
        this.ghiChu = ghiChu;
        this.tiLe = tiLe;
        this.maNganh = maNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getMaMonTonDong() {
        return maMonTonDong;
    }

    public void setMaMonTonDong(String maMonTonDong) {
        this.maMonTonDong = maMonTonDong;
    }

    public String getTenMonTon() {
        return tenMonTon;
    }

    public void setTenMonTon(String tenMonTon) {
        this.tenMonTon = tenMonTon;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setLiDo(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTiLe() {
        return tiLe;
    }

    public void setTiLe(String tiLe) {
        this.tiLe = tiLe;
    }
}
