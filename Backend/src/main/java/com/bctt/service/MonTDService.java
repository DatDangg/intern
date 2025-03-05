package com.bctt.service;

import com.bctt.dto.reponse.MonTDResponse;
import com.bctt.dto.request.MonTDRequest;
import com.bctt.model.MonTonDong;

import java.util.List;

public interface MonTDService {
    public MonTDResponse createMonTD(MonTDRequest monTDRequest);
    public MonTDResponse updateMonTD(Long id, MonTDRequest monTDRequest);
    public List<MonTonDong> getMaNganhAnhNamDaoTao(String tenNganh, String namDaoTao);
    public void deleteMonTD(Long id);
}
