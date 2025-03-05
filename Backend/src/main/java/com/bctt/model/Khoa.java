package com.bctt.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Khoa {
    @Id
    private String maKhoa;
    private String tenKhoa;

    @OneToMany(mappedBy = "khoa", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Nganh> nganhs;

    public Khoa(String maKhoa, String tenKhoa, List<Nganh> nganhs) {
        this.maKhoa = maKhoa;
        this.tenKhoa = tenKhoa;
        this.nganhs = nganhs;
    }
    public Khoa(){}
    public void setMaKhoa(String maKhoa) {
        this.maKhoa = maKhoa;
    }

    public String getTenKhoa() {
        return tenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
        this.tenKhoa = tenKhoa;
    }

    public String getMaKhoa() {
        return maKhoa;
    }

    public List<Nganh> getNganhs() {
        return nganhs;
    }

    public void setNganhs(List<Nganh> nganhs) {
        this.nganhs = nganhs;
    }
}
