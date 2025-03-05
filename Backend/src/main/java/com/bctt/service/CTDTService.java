package com.bctt.service;

import com.bctt.dto.request.CTDTRequest;
import com.bctt.model.CTDT;

import java.util.List;

public interface CTDTService {
    public CTDT createCTDT(CTDTRequest ctdtRequest);
    public List<CTDT> getAllCTDTs();
    public CTDT getCTDT(String maCTDT);
    public CTDT updateCTDT(String id, CTDTRequest ctdtRequest);
    public void deleteCTDT(String id);
}
