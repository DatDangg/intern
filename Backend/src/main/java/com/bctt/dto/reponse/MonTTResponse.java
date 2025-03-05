package com.bctt.dto.reponse;

public class MonTTResponse {
    private String maMonThayThe;
    private String tenMonThayThe;
    private int soTinChiTT;
    private  String trangThai;
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public MonTTResponse() {}
    public MonTTResponse(String maMonThayThe, String tenMonThayThe,int soTinChiTT, String trangThai, String maMonHoc, String tenMonHoc, int soTinChi) {
        this.maMonThayThe = maMonThayThe;
        this.tenMonThayThe = tenMonThayThe;
        this.soTinChiTT = soTinChiTT;
        this.trangThai = trangThai;
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.soTinChi = soTinChi;
    }

    public String getMaMonThayThe() {
        return maMonThayThe;
    }

    public int getSoTinChiTT() {
        return soTinChiTT;
    }

    public void setSoTinChiTT(int soTinChiTT) {
        this.soTinChiTT = soTinChiTT;
    }

    public void setMaMonThayThe(String maMonThayThe) {
        this.maMonThayThe = maMonThayThe;
    }

    public String getTenMonThayThe() {
        return tenMonThayThe;
    }

    public void setTenMonThayThe(String tenMonThayThe) {
        this.tenMonThayThe = tenMonThayThe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }
}
