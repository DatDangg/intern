package com.bctt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Nganh {
    @Id
    private String maNganh;
    private String tenNganh;
    private String namDaotao;
    @OneToMany(mappedBy = "nganh")
    @JsonManagedReference
    private List<CTDT> ctdts;

    @ManyToOne
    @JoinColumn(name = "khoa_id")
    @JsonBackReference
    private Khoa khoa;

    @JsonIgnore
    @ManyToMany(mappedBy = "nganhList")
    private List<User_profile> userProfiles;

    public Nganh() {}
    public Nganh(String maNganh, String tenNganh, String namDaotao, List<CTDT> ctdts, Khoa khoa, List<User_profile> userProfiles) {
        this.maNganh = maNganh;
        this.tenNganh = tenNganh;
        this.namDaotao = namDaotao;
        this.ctdts = ctdts;
        this.khoa = khoa;
        this.userProfiles = userProfiles;
    }

    public List<User_profile> getUserProfiles() {
        return userProfiles;
    }

    public void setUserProfiles(List<User_profile> userProfiles) {
        this.userProfiles = userProfiles;
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

    public List<CTDT> getCtdts() {
        return ctdts;
    }

    public void setCtdts(List<CTDT> ctdts) {
        this.ctdts = ctdts;
    }

    public Khoa getKhoa() {
        return khoa;
    }

    public void setKhoa(Khoa khoa) {
        this.khoa = khoa;
    }
}
