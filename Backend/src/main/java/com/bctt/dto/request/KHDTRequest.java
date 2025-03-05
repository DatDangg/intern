package com.bctt.dto.request;

public class KHDTRequest {
    private String namHoc;
    private String kiHoc;
    private String nhomHoc;
    private String thoiGianBD;
    private String thoiGianKT;

    public KHDTRequest(String namHoc, String kiHoc, String nhomHoc, String thoiGianBD, String thoiGianKT) {
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
        this.nhomHoc = nhomHoc;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
    }

    public KHDTRequest() {}
    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getKiHoc() {
        return kiHoc;
    }

    public void setKiHoc(String kiHoc) {
        this.kiHoc = kiHoc;
    }

    public String getNhomHoc() {
        return nhomHoc;
    }

    public void setNhomHoc(String nhomHoc) {
        this.nhomHoc = nhomHoc;
    }

    public String getThoiGianBD() {
        return thoiGianBD;
    }

    public void setThoiGianBD(String thoiGianBD) {
        this.thoiGianBD = thoiGianBD;
    }

    public String getThoiGianKT() {
        return thoiGianKT;
    }

    public void setThoiGianKT(String thoiGianKT) {
        this.thoiGianKT = thoiGianKT;
    }
}
