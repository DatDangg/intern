package com.bctt.service;

import com.bctt.dto.request.ChianhomRequest;
import com.bctt.dto.request.KHDTRequest;
import com.bctt.model.Chianhom;
import com.bctt.model.KHDT;

import java.util.List;

public interface KHDTService {
    public KHDT createKHDT(KHDTRequest khdt);
    public KHDT updateKHDT(Long id, KHDTRequest khdt);
    public KHDT getKHDT(Long id);
    public List<KHDT> getNhomHocAndNamHoc(String nhomHoc,String namHoc);
    public void deleteKHDT(Long id);
}
