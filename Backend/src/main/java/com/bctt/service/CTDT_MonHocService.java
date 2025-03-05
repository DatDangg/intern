package com.bctt.service;

import com.bctt.dto.reponse.CTDT_MonHoc_response;
import com.bctt.dto.request.CTDT_MonHoc_Request;

import java.util.List;

public interface CTDT_MonHocService {
    public CTDT_MonHoc_response addMonHoc(CTDT_MonHoc_Request request);
    public CTDT_MonHoc_response updateMonHoc(Long id,CTDT_MonHoc_Request request);
    public void deleteCTDT_MonHoc(Long id);
    public List<CTDT_MonHoc_response> getMonHocsByCTDT(String maCTDT);
    //public List<CTDT_MonHoc_response> getMonHocsByNganhAndNamDaotao(String tenNganh, String namDaotao);
}
