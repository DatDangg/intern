package com.bctt.dto.reponse;

public class CTDT_MonHoc_response {
    private String maCTDT;
    private String tenCTDT;
    private String maMonHoc;
    private String tenMonHoc;
    private String dieuKienTienQuyet;
    private double heSo;
    private String soGio;
    private int soTinChi;

    public CTDT_MonHoc_response(String maCTDT, String tenCTDT, String maMonHoc, String tenMonHoc, String dieuKienTienQuyet, double heSo, int soTinChi,String soGio ) {
        this.maCTDT = maCTDT;
        this.tenCTDT = tenCTDT;
        this.maMonHoc = maMonHoc;
        this.tenMonHoc = tenMonHoc;
        this.dieuKienTienQuyet = dieuKienTienQuyet;
        this.heSo = heSo;
        this.soTinChi = soTinChi;
        this.soGio = soGio;
    }

    public String getMaCTDT() {
        return maCTDT;
    }

    public String getSoGio() {
        return soGio;
    }

    public void setSoGio(String soGio) {
        this.soGio = soGio;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
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

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
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
