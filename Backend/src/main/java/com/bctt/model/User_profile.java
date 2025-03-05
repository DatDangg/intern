package com.bctt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User_profile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userProfileId;

    private String hoVaTen;
    private String gioiTinh;
    private int CCCD;
    private String lopHoc;
    private String tinhTrang;
    private int soDienthoai;
    private String emailCN;
    @OneToOne
    @JoinColumn(name = "maUser")
    private User user;
    @ManyToMany
    @JsonIgnore
    @JoinTable(
            name = "user_nganh",
            joinColumns = @JoinColumn(name = "userProfileId"),
            inverseJoinColumns = @JoinColumn(name = "maNganh")
    )
    private List<Nganh> nganhList;

    public User_profile() {}
    public User_profile(Long userProfileId, String hoVaTen, String gioiTinh, int CCCD, String lopHoc, String tinhTrang, int soDienthoai, String emailCN, User user, List<Nganh> nganhList) {
        this.userProfileId = userProfileId;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.CCCD = CCCD;
        this.lopHoc = lopHoc;
        this.tinhTrang = tinhTrang;
        this.soDienthoai = soDienthoai;
        this.emailCN = emailCN;
        this.user = user;
        this.nganhList = nganhList;
    }

    public List<Nganh> getNganhList() {
        return nganhList;
    }

    public void setNganhList(List<Nganh> nganhList) {
        this.nganhList = nganhList;
    }

    public Long getUserProfileId() {
        return userProfileId;
    }

    public void setUserProfileId(Long userProfileId) {
        this.userProfileId = userProfileId;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getCCCD() {
        return CCCD;
    }

    public void setCCCD(int CCCD) {
        this.CCCD = CCCD;
    }

    public String getLopHoc() {
        return lopHoc;
    }

    public void setLopHoc(String lopHoc) {
        this.lopHoc = lopHoc;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public int getSoDienthoai() {
        return soDienthoai;
    }

    public void setSoDienthoai(int soDienthoai) {
        this.soDienthoai = soDienthoai;
    }

    public String getEmailCN() {
        return emailCN;
    }

    public void setEmailCN(String emailCN) {
        this.emailCN = emailCN;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
