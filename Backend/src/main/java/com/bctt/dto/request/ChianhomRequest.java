package com.bctt.dto.request;

public class ChianhomRequest {
    private String namHoc;
    private String nhomHoc;
    private String khoa;
    private String myKey;

    public ChianhomRequest(String namHoc, String nhomHoc, String khoa, String myKey) {
        this.namHoc = namHoc;
        this.nhomHoc = nhomHoc;
        this.khoa = khoa;
        this.myKey = myKey;
    }

    public ChianhomRequest() {}
    public String getNamHoc() {
        return namHoc;
    }

    public void setNamHoc(String namHoc) {
        this.namHoc = namHoc;
    }

    public String getNhomHoc() {
        return nhomHoc;
    }

    public void setNhomHoc(String nhomHoc) {
        this.nhomHoc = nhomHoc;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getMyKey() {
        return myKey;
    }

    public void setKey(String myKey) {
        this.myKey = myKey;
    }
}
