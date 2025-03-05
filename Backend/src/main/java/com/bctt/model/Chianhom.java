package com.bctt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Chianhom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String namHoc;
    private String nhomHoc;
    private String khoa;
    private String myKey;

    public Chianhom(Long id, String namHoc, String nhomHoc, String khoa, String myKey) {
        this.id = id;
        this.namHoc = namHoc;
        this.nhomHoc = nhomHoc;
        this.khoa = khoa;
        this.myKey = myKey;
    }
    public Chianhom() {}

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

    public String getNhomHoc() {
        return nhomHoc;
    }

    public void setNhomHoc(String nhomHoc) {
        this.nhomHoc = nhomHoc;
    }

    public String getKhoa() {
        return khoa;
    }

    public void setKhoa(String khoa) {
        this.khoa = khoa;
    }

    public String getMyKey() {
        return myKey;
    }

    public void setMyKey(String myKey) {
        this.myKey = myKey;
    }
}
