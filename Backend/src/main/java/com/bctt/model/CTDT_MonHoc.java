package com.bctt.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "ctdt_monhoc")
public class CTDT_MonHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maCTDT", nullable = false)
    @JsonBackReference
    private CTDT ctdt;

    @ManyToOne
    @JoinColumn(name = "maMonHoc", nullable = false)

    private Monhoc monHoc;

    private String soGio;
    private String dieuKienTienQuyet;
    private double heSo;

    public CTDT_MonHoc() {}
    public CTDT_MonHoc(double heSo, String dieuKienTienQuyet, Monhoc monHoc, CTDT ctdt, Long id, String soGio) {
        this.heSo = heSo;
        this.dieuKienTienQuyet = dieuKienTienQuyet;
        this.monHoc = monHoc;
        this.ctdt = ctdt;
        this.id = id;
        this.soGio = soGio;
    }

    public String getSoGio() {
        return soGio;
    }

    public void setSoGio(String soGio) {
        this.soGio = soGio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CTDT getCtdt() {
        return ctdt;
    }

    public void setCtdt(CTDT ctdt) {
        this.ctdt = ctdt;
    }

    public Monhoc getMonHoc() {
        return monHoc;
    }

    public void setMonHoc(Monhoc monHoc) {
        this.monHoc = monHoc;
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
