package com.bctt.dto.request;

import com.bctt.model.Nganh;

import java.util.List;

public class UserProfileRequest {
    private String hoVaTen;
    private String gioiTinh;
    private int CCCD;
    private String lopHoc;
    private String tinhTrang;
    private int soDienthoai;
    private String emailCN;
    private String maNganh;

    public UserProfileRequest() {}
    public UserProfileRequest(String hoVaTen, String gioiTinh, int CCCD, String lopHoc, String tinhTrang, int soDienthoai, String emailCN,String maNganh) {
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.CCCD = CCCD;
        this.lopHoc = lopHoc;
        this.tinhTrang = tinhTrang;
        this.soDienthoai = soDienthoai;
        this.emailCN = emailCN;
        this.maNganh = maNganh;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoDienthoai() {
        return soDienthoai;
    }

    public void setSoDienthoai(int soDienthoai) {
        this.soDienthoai = soDienthoai;
    }

    public String getEmailCN() {
        return emailCN;
    }

    public void setEmailCN(String emailCN) {
        this.emailCN = emailCN;
    }
}
