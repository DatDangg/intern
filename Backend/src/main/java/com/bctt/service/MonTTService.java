package com.bctt.service;

import com.bctt.dto.reponse.MonTTResponse;
import com.bctt.dto.request.MonTTRequest;
import com.bctt.model.MonThayThe;

import java.util.List;

public interface MonTTService {
    public MonTTResponse createMonTT(MonTTRequest monTTRequest);
    public List<MonTTResponse> getMonTTByMonHoc(String maMonHoc);
    public MonTTResponse updateMonTT(Long id, MonTTRequest monTTRequest);
    public void deleteMonTT(Long id);
}
