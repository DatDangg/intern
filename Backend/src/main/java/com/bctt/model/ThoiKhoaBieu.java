package com.bctt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class ThoiKhoaBieu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thoiKhoaBieuId;

    @ManyToOne
    private Monhoc monhoc;

    private String ngayHoc;
    private String namHoc;
    private String kiHoc;
    private String caHoc;
    private String phongHoc;
    private String tenLop;
    private String nhomHoc;
    private String giangVien;

    public ThoiKhoaBieu() {}
    public ThoiKhoaBieu(Long thoiKhoaBieuId, Monhoc monhoc, String ngayHoc, String namHoc, String kiHoc, String caHoc, String phongHoc,String tenLop,String nhomHoc, String giangVien) {
        this.thoiKhoaBieuId = thoiKhoaBieuId;
        this.monhoc = monhoc;
        this.ngayHoc = ngayHoc;
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
        this.caHoc = caHoc;
        this.phongHoc = phongHoc;
        this.tenLop = tenLop;
        this.nhomHoc = nhomHoc;
        this.giangVien = giangVien;
    }

    public Long getThoiKhoaBieuId() {
        return thoiKhoaBieuId;
    }

    public void setThoiKhoaBieuId(Long thoiKhoaBieuId) {
        this.thoiKhoaBieuId = thoiKhoaBieuId;
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

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
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
