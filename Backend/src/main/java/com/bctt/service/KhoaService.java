package com.bctt.service;

import com.bctt.dto.request.KhoaRequest;
import com.bctt.model.Khoa;

import java.util.List;

public interface KhoaService {
    public Khoa createKoa(KhoaRequest khoaRequest);
    public Khoa updateKhoa(String makhoa, KhoaRequest khoaRequest);
    public Khoa getKhoa(String makhoa);
    public List<Khoa> getAllKoas();
    public void deleteKhoa(String maKhoa);
}
