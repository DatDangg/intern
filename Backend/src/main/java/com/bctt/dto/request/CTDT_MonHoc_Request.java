package com.bctt.dto.request;

public class CTDT_MonHoc_Request {
    private String maCTDT;
    private String maMonHoc;
    private String dieuKienTienQuyet;
    private double heSo;
    private String soGio;

    public CTDT_MonHoc_Request(String maCTDT, String maMonHoc, String dieuKienTienQuyet, double heSo,String soGio) {
        this.maCTDT = maCTDT;
        this.maMonHoc = maMonHoc;
        this.dieuKienTienQuyet = dieuKienTienQuyet;
        this.heSo = heSo;
        this.soGio = soGio;
    }
    public CTDT_MonHoc_Request() {}

    public String getSoGio() {
        return soGio;
    }

    public void setSoGio(String soGio) {
        this.soGio = soGio;
    }

    public String getMaCTDT() {
        return maCTDT;
    }

    public void setMaCTDT(String maCTDT) {
        this.maCTDT = maCTDT;
    }

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getDieuKienTienQuyet() {
        return dieuKienTienQuyet;
    }

    public void setDieuKienTienQuyet(String dieuKienTienQuyet) {
        this.dieuKienTienQuyet = dieuKienTienQuyet;
    }

    public double getHeSo() {
        return heSo;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }
}
