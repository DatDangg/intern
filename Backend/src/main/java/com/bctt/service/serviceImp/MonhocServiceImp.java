package com.bctt.service.serviceImp;

import com.bctt.dto.request.MonhocRequest;
import com.bctt.model.Monhoc;
import com.bctt.repository.MonhocRepository;
import com.bctt.service.MonhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonhocServiceImp implements MonhocService {
    @Autowired
    private MonhocRepository monhocRepository;

    @Override
    public Monhoc createMonHoc(MonhocRequest monhocRequest) {
        Monhoc monhoc = new Monhoc();
        monhoc.setMaMonHoc(monhocRequest.getMaMonHoc());
        monhoc.setTenMonHoc(monhocRequest.getTenMonHoc());
        monhoc.setSoTinChi(monhocRequest.getSoTinChi());
        return monhocRepository.save(monhoc);
    }

    @Override
    public List<Monhoc> getAllMonHoc() {
        return monhocRepository.findAll();
    }

    @Override
    public Monhoc getMonHoc(String maMonHoc) {
        return monhocRepository.findById(maMonHoc).orElseThrow();
    }

    @Override
    public Monhoc updateMonHoc(String id, MonhocRequest monhocRequest) {
        Monhoc monhoc = getMonHoc(id);
        monhoc.setTenMonHoc(monhocRequest.getTenMonHoc());
        monhoc.setMaMonHoc(monhocRequest.getMaMonHoc());
        monhoc.setSoTinChi(monhocRequest.getSoTinChi());
        return monhocRepository.save(monhoc);
    }

    @Override
    public void deleteMonHoc(String maMonHoc) {
        monhocRepository.deleteById(maMonHoc);
    }
}
