package com.bctt.service;

import com.bctt.dto.reponse.TKBResponse;
import com.bctt.dto.request.TKBRequest;

import java.util.List;

public interface TKBService {
    TKBResponse createTKB(TKBRequest tKBRequest);
    TKBResponse updateTKB(Long id, TKBRequest tkbRequest);
    List<TKBResponse> getAllTKB(String namHoc, String kiHoc);
    void deleteTKB(Long id);

    // Phương thức mới: lấy thời khóa biểu theo năm, kỳ và nhóm học
    List<TKBResponse> getAllTKB(String namHoc, String kiHoc, String nhomHoc);

    List<TKBResponse> getAllTKBTheoNam(String namHoc);
}
