package com.bctt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KHDT {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namHoc;
    private String kiHoc;
    private String nhomHoc;
    private String thoiGianBD;
    private String thoiGianKT;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public KHDT(Long id, String namHoc, String kiHoc, String nhomHoc, String thoiGianBD, String thoiGianKT) {
        this.id = id;
        this.namHoc = namHoc;
        this.kiHoc = kiHoc;
        this.nhomHoc = nhomHoc;
        this.thoiGianBD = thoiGianBD;
        this.thoiGianKT = thoiGianKT;
    }

    public KHDT() {}
}
