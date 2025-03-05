package com.bctt.dto.request;

public class MonTTRequest {
    private String maMonThayThe;
    private String tenMonThayThe;
    private int soTinChiTT;
    private String trangThai;
    private String maMonHoc;

    public MonTTRequest() {}
    public MonTTRequest(String maMonThayThe, String tenMonThayThe,int soTinChiTT, String trangThai, String maMonHoc) {
        this.maMonThayThe = maMonThayThe;
        this.tenMonThayThe = tenMonThayThe;
        this.soTinChiTT = soTinChiTT;
        this.trangThai = trangThai;
        this.maMonHoc = maMonHoc;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public int getSoTinChiTT() {
        return soTinChiTT;
    }

    public void setSoTinChiTT(int soTinChiTT) {
        this.soTinChiTT = soTinChiTT;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getMaMonThayThe() {
        return maMonThayThe;
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
}
