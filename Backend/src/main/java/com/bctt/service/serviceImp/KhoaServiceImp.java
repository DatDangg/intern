package com.bctt.service.serviceImp;

import com.bctt.dto.request.KhoaRequest;
import com.bctt.model.Khoa;
import com.bctt.repository.KhoaRepository;
import com.bctt.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhoaServiceImp implements KhoaService {
    @Autowired
    private KhoaRepository khoaRepository;
    @Override
    public Khoa createKoa(KhoaRequest khoaRequest) {
        Khoa khoa = new Khoa();
        khoa.setMaKhoa(khoaRequest.getMaKhoa());
        khoa.setTenKhoa(khoaRequest.getTenKhoa());
        return khoaRepository.save(khoa);
    }

    @Override
    public Khoa updateKhoa(String makhoa, KhoaRequest khoaRequest) {
        Khoa khoa = getKhoa(makhoa);
        khoa.setMaKhoa(khoaRequest.getMaKhoa());
        khoa.setTenKhoa(khoaRequest.getTenKhoa());
        return khoaRepository.save(khoa);
    }

    @Override
    public Khoa getKhoa(String makhoa) {
        return khoaRepository.findById(makhoa).orElseThrow();
    }

    @Override
    public List<Khoa> getAllKoas() {
        return khoaRepository.findAll();
    }

    @Override
    public void deleteKhoa(String maKhoa) {
        khoaRepository.deleteById(maKhoa);
    }
}
