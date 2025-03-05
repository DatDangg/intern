package com.bctt.dto.request;

public class KhoaRequest {
    private String maKhoa;
    private String tenKhoa;

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public KhoaRequest(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public KhoaRequest() {}
}
