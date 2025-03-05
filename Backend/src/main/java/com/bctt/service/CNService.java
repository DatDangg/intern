package com.bctt.service;

import com.bctt.dto.request.ChianhomRequest;
import com.bctt.model.Chianhom;

import java.util.List;

public interface CNService {
    public Chianhom createChiaNhom(ChianhomRequest request);
    public Chianhom updateChiaNhom(Long id, ChianhomRequest request);
    public Chianhom getChiaNhom(Long id);
    public List<Chianhom> getNamHocAndKHoa(String namHoc,String khoa);
    public void delete(Long id);
}
