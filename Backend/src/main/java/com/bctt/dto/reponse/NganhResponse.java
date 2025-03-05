package com.bctt.dto.reponse;

public class NganhResponse {
    private String maNganh;
    private String tenNganh;
    private String namDaotao;
    private String maKhoa;
    private String tenKhoa;

    public NganhResponse(String maNganh, String tenNganh, String namDaotao, String maKhoa, String tenKhoa) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.namDaotao = namDaotao;
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
    }

    public NganhResponse() {}
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

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }
}
