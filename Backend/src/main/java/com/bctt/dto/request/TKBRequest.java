package com.bctt.dto.request;

public class TKBRequest {
    private String maMonHoc;
    private String ngayHoc;
    private String namHoc;
    private String kiHoc;
    private String caHoc;
    private String phongHoc;
    private String tenLop;
    private String nhomHoc;
    private String giangVien;

    public TKBRequest() {}

    public TKBRequest(String maMonHoc, String ngayHoc, String namHoc, String kiHoc, String caHoc, String phongHoc, String tenLop, String nhomHoc, String giangVien) {
        this.maMonHoc = maMonHoc;
        this.ngayHoc = ngayHoc;
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
        this.caHoc = caHoc;
        this.phongHoc = phongHoc;
        this.tenLop = tenLop;
        this.nhomHoc = nhomHoc;
        this.giangVien = giangVien;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNhomHoc() {
        return nhomHoc;
    }

    public void setNhomHoc(String nhomHoc) {
        this.nhomHoc = nhomHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getNgayHoc() {
        return ngayHoc;
    }

    public void setNgayHoc(String ngayHoc) {
        this.ngayHoc = ngayHoc;
    }

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

    public String getCaHoc() {
        return caHoc;
    }

    public void setCaHoc(String caHoc) {
        this.caHoc = caHoc;
    }

    public String getPhongHoc() {
        return phongHoc;
    }

    public void setPhongHoc(String phongHoc) {
        this.phongHoc = phongHoc;
    }

    public String getGiangVien() {
        return giangVien;
    }

    public void setGiangVien(String giangVien) {
        this.giangVien = giangVien;
    }
}
