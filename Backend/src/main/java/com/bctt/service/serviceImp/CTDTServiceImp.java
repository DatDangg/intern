package com.bctt.service.serviceImp;

import com.bctt.dto.request.CTDTRequest;
import com.bctt.model.CTDT;
import com.bctt.model.Nganh;
import com.bctt.repository.CTDTRepository;
import com.bctt.repository.NganhRepository;
import com.bctt.service.CTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CTDTServiceImp implements CTDTService {
    @Autowired
    private CTDTRepository ctdtRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Override
    public CTDT createCTDT(CTDTRequest ctdtRequest) {
        Nganh nganh = nganhRepository.findById(ctdtRequest.getMaNganh()).orElseThrow();
        CTDT ctdt = new CTDT();
        ctdt.setMaCTDT(ctdtRequest.getMaCTDT());
        ctdt.setTenCTDT(ctdtRequest.getTenCTDT());
        ctdt.setNamDaotao(ctdtRequest.getNamDaoTao());
        ctdt.setNganh(nganh);
        return ctdtRepository.save(ctdt);
    }

    @Override
    public List<CTDT> getAllCTDTs() {
        return ctdtRepository.findAll();
    }

    @Override
    public CTDT getCTDT(String maCTDT) {
        return ctdtRepository.findById(maCTDT).orElseThrow();
    }

    @Override
    public CTDT updateCTDT(String id, CTDTRequest ctdtRequest) {
        CTDT ctdt = getCTDT(id);
        ctdt.setMaCTDT(ctdtRequest.getMaCTDT());
        ctdt.setTenCTDT(ctdtRequest.getTenCTDT());
        ctdt.setNamDaotao(ctdtRequest.getNamDaoTao());
        ctdt.setNganh(nganhRepository.findById(ctdtRequest.getMaNganh()).orElseThrow());
        return ctdtRepository.save(ctdt);
    }

    @Override
    public void deleteCTDT(String id) {
        ctdtRepository.deleteById(id);
    }
}
