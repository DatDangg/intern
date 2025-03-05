package com.bctt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ctdt")
public class CTDT {
    @Id
    private String maCTDT;
    private String tenCTDT;
    private String namDaotao;
    @ManyToOne
    @JoinColumn(name = "maNganh", nullable = false)
    @JsonBackReference
    private Nganh nganh;
    @OneToMany(mappedBy = "ctdt")
    @JsonManagedReference
    private List<CTDT_MonHoc> ctdtMonHocs;

    public CTDT(String maCTDT, String tenCTDT,String namDaotao, Nganh nganh, List<CTDT_MonHoc> ctdtMonHocs) {
        this.maCTDT = maCTDT;
        this.tenCTDT = tenCTDT;
        this.namDaotao = namDaotao;
        this.nganh = nganh;
        this.ctdtMonHocs = ctdtMonHocs;
    }
    public CTDT() {}

    public String getNamDaotao() {
        return namDaotao;
    }

    public void setNamDaotao(String namDaotao) {
        this.namDaotao = namDaotao;
    }

    public Nganh getNganh() {
        return nganh;
    }

    public void setNganh(Nganh nganh) {
        this.nganh = nganh;
    }

    public List<CTDT_MonHoc> getCtdtMonHocs() {
        return ctdtMonHocs;
    }

    public void setCtdtMonHocs(List<CTDT_MonHoc> ctdtMonHocs) {
        this.ctdtMonHocs = ctdtMonHocs;
    }

    public String getMaCTDT() {
        return maCTDT;
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
}
