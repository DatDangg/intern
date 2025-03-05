package com.bctt.dto.request;

public class CTDTRequest {
    private String maCTDT;
    private String tenCTDT;
    private String namDaoTao;
    private String maNganh;

    public CTDTRequest(String maCTDT,String tenCTDT,String namDaoTao,String maNganh) {
        this.maCTDT = maCTDT;
        this.tenCTDT = tenCTDT;
        this.namDaoTao = namDaoTao;
        this.maNganh = maNganh;
    }
    public CTDTRequest() {}

    public String getMaNganh() {
        return maNganh;
    }

    public void setMaNganh(String maNganh) {
        this.maNganh = maNganh;
    }

    public String getNamDaoTao() {
        return namDaoTao;
    }

    public void setNamDaoTao(String namDaoTao) {
        this.namDaoTao = namDaoTao;
    }

    public String getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(String maCTDT) {
        this.maCTDT = maCTDT;
    }

    public String getTenCTDT() {
        return tenCTDT;
    }

    public void setTenCTDT(String tenCTDT) {
        this.tenCTDT = tenCTDT;
    }
}
