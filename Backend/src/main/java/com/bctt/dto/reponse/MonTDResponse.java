package com.bctt.dto.reponse;

import com.bctt.model.Nganh;
import jakarta.persistence.ManyToOne;

public class MonTDResponse {
    private String maMonTonDong;
    private  String tenMonTon;
    private String ghiChu;
    private String tiLe;
    private String tenNganh;
    private String namDaoTao;

    public MonTDResponse() {}
    public MonTDResponse(String maMonTonDong, String tenMonTon, String ghiChu, String tiLe, String tenNganh, String namDaoTao) {
        this.maMonTonDong = maMonTonDong;
        this.tenMonTon = tenMonTon;
        this.ghiChu = ghiChu;
        this.tiLe = tiLe;
        this.tenNganh = tenNganh;
        this.namDaoTao = namDaoTao;
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

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getTiLe() {
        return tiLe;
    }

    public void setTiLe(String tiLe) {
        this.tiLe = tiLe;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getNamDaoTao() {
        return namDaoTao;
    }

    public void setNamDaoTao(String namDaoTao) {
        this.namDaoTao = namDaoTao;
    }
}
