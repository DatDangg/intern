package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.NganhResponse;
import com.bctt.dto.request.NganhRequest;
import com.bctt.model.Khoa;
import com.bctt.model.Nganh;
import com.bctt.repository.KhoaRepository;
import com.bctt.repository.NganhRepository;
import com.bctt.service.KhoaService;
import com.bctt.service.NganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NganhServiceImp implements NganhService {
    @Autowired
    private NganhRepository nganhRepository;
    @Autowired
    private KhoaRepository khoaRepository;
    @Override
    public NganhResponse createNganh(NganhRequest nganhRequest) {
        Khoa khoa = khoaRepository.findById(nganhRequest.getMaKhoa()).orElseThrow();
        Nganh nganh = new Nganh();
        nganh.setMaNganh(nganhRequest.getMaNganh());
        nganh.setTenNganh(nganhRequest.getTenNganh());
        nganh.setNamDaotao(nganhRequest.getNamDaotao());
        nganh.setKhoa(khoa);
        nganhRepository.save(nganh);
        return new NganhResponse(
                nganh.getMaNganh(),
                nganh.getTenNganh(),
                nganh.getNamDaotao(),
                khoa.getMaKhoa(),
                khoa.getTenKhoa()
        );
    }

    @Override
    public List<Nganh> getAllNganh() {
        return nganhRepository.findAll();
    }

    @Override
    public NganhResponse updateNganh(String id, NganhRequest nganhRequest) {
        Nganh nganh = nganhRepository.findById(id).orElseThrow();
        Khoa khoa = khoaRepository.findById(nganhRequest.getMaKhoa()).orElseThrow();
        nganh.setMaNganh(nganhRequest.getMaNganh());
        nganh.setTenNganh(nganhRequest.getTenNganh());
        nganh.setNamDaotao(nganhRequest.getNamDaotao());
        nganh.setKhoa(khoa);
        nganhRepository.save(nganh);
        return new NganhResponse(
                nganh.getMaNganh(),
                nganh.getTenNganh(),
                nganh.getNamDaotao(),
                khoa.getMaKhoa(),
                khoa.getTenKhoa()
        );
    }

    @Override
    public void deleteNganh(String maNganh) {
        nganhRepository.deleteById(maNganh);
    }
}
