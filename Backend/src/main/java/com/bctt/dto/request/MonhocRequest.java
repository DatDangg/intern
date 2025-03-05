package com.bctt.dto.request;

public class MonhocRequest {
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public MonhocRequest(int soTinChi, String tenMonHoc, String maMonHoc) {
        this.soTinChi = soTinChi;
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;
    }
    public MonhocRequest() {}
    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
}
