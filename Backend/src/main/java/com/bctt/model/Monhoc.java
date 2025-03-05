package com.bctt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;


@Entity
@Table(name = "monhoc")
public class Monhoc {
    @Id
    private String maMonHoc;
    private String tenMonHoc;
    private int soTinChi;

    public Monhoc(int soTinChi, String tenMonHoc, String maMonHoc) {
        this.soTinChi = soTinChi;
        this.tenMonHoc = tenMonHoc;
        this.maMonHoc = maMonHoc;

    }
    public Monhoc() {}

    public String getMaMonHoc() {
        return maMonHoc;
    }

    public void setMaMonHoc(String maMonHoc) {
        this.maMonHoc = maMonHoc;
    }

    public int getSoTinChi() {
        return soTinChi;
    }

    public void setSoTinChi(int soTinChi) {
        this.soTinChi = soTinChi;
    }

    public String getTenMonHoc() {
        return tenMonHoc;
    }

    public void setTenMonHoc(String tenMonHoc) {
        this.tenMonHoc = tenMonHoc;
    }
}
