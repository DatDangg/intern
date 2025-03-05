package com.bctt.service;

import com.bctt.dto.request.MonhocRequest;
import com.bctt.model.Monhoc;

import java.util.List;

public interface MonhocService {
    public Monhoc createMonHoc(MonhocRequest monhocRequest);
    public List<Monhoc> getAllMonHoc();
    public Monhoc getMonHoc(String maMonHoc);
    public Monhoc updateMonHoc(String id, MonhocRequest monhocRequest);
    public void deleteMonHoc(String maMonHoc);
}
