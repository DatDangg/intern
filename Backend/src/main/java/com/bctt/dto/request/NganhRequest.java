package com.bctt.dto.request;

public class NganhRequest {
    private String maNganh;
    private String tenNganh;
    private String namDaotao;
    private String maKhoa;

    public NganhRequest(){}
    public NganhRequest(String maNganh, String tenNganh, String namDaotao, String maKhoa) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.namDaotao = namDaotao;
        this.maKhoa = maKhoa;
    }

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getTenNganh() {
        return tenNganh;
    }

    public void setTenNganh(String tenNganh) {
        this.tenNganh = tenNganh;
    }

    public String getNamDaotao() {
        return namDaotao;
    }

    public void setNamDaotao(String namDaotao) {
        this.namDaotao = namDaotao;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }
}
