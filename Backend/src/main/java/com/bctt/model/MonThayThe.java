package com.bctt.model;

import jakarta.persistence.*;

@Entity
public class MonThayThe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String maMonThayThe;
    private String tenMonThayThe;
    private int soTinChiTT;
    private  String trangThai;
    @ManyToOne
    @JoinColumn(name = "maMonHoc", nullable = false)
    private Monhoc monhoc;

    public MonThayThe() {}
    public MonThayThe(Long id,String maMonThayThe, String tenMonThayThe,int soTinChiTT, String trangThai, Monhoc monhoc) {
        this.id = id;
        this.maMonThayThe = maMonThayThe;
        this.tenMonThayThe = tenMonThayThe;
        this.soTinChiTT = soTinChiTT;
        this.trangThai = trangThai;
        this.monhoc = monhoc;
    }

    public Long getId() {
        return id;
    }

    public int getSoTinChiTT() {
        return soTinChiTT;
    }

    public void setSoTinChiTT(int soTinChi) {
        this.soTinChiTT = soTinChi;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMaMonThayThe() {
        return maMonThayThe;
    }

    public void setMaMonThayThe(String maMonThayThe) {
        this.maMonThayThe = maMonThayThe;
    }

    public String getTenMonThayThe() {
        return tenMonThayThe;
    }

    public void setTenMonThayThe(String tenMonThayThe) {
        this.tenMonThayThe = tenMonThayThe;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Monhoc getMonhoc() {
        return monhoc;
    }

    public void setMonhoc(Monhoc monhoc) {
        this.monhoc = monhoc;
    }
}
