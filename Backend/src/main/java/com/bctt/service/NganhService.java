package com.bctt.service;

import com.bctt.dto.reponse.NganhResponse;
import com.bctt.dto.request.NganhRequest;
import com.bctt.model.Nganh;

import java.util.List;

public interface NganhService {
    public NganhResponse createNganh(NganhRequest nganhRequest);
    public List<Nganh> getAllNganh();
    public NganhResponse updateNganh(String id, NganhRequest nganhRequest);
    public void deleteNganh(String maNganh);
}
