package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.MonTDResponse;
import com.bctt.dto.request.MonTDRequest;
import com.bctt.model.MonTonDong;
import com.bctt.model.Nganh;
import com.bctt.repository.MonTDRepository;
import com.bctt.repository.NganhRepository;
import com.bctt.service.MonTDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonTDServiceImp implements MonTDService {
    @Autowired
    private MonTDRepository monTDRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Override
    public MonTDResponse createMonTD(MonTDRequest monTDRequest) {
        Nganh nganh = nganhRepository.findById(monTDRequest.getMaNganh()).orElseThrow();
        MonTonDong monTonDong = new MonTonDong();
        monTonDong.setMaMonTonDong(monTDRequest.getMaMonTonDong());
        monTonDong.setTenMonTon(monTDRequest.getTenMonTon());
        monTonDong.setGhiChu(monTDRequest.getGhiChu());
        monTonDong.setTiLe(monTDRequest.getTiLe());
        monTonDong.setNganh(nganh);
        monTDRepository.save(monTonDong);
        return new MonTDResponse(
                monTonDong.getMaMonTonDong(),
                monTonDong.getTenMonTon(),
                monTonDong.getGhiChu(),
                monTonDong.getTiLe(),
                nganh.getTenNganh(),
                nganh.getNamDaotao()
        );
    }

    @Override
    public MonTDResponse updateMonTD(Long id, MonTDRequest monTDRequest) {
        MonTonDong monTonDong = monTDRepository.findById(id).orElseThrow();
        Nganh nganh = nganhRepository.findById(monTDRequest.getMaNganh()).orElseThrow();
        monTonDong.setMaMonTonDong(monTDRequest.getMaMonTonDong());
        monTonDong.setTenMonTon(monTDRequest.getTenMonTon());
        monTonDong.setGhiChu(monTDRequest.getGhiChu());
        monTonDong.setTiLe(monTDRequest.getTiLe());
        monTonDong.setNganh(nganh);
        monTDRepository.save(monTonDong);
        return new MonTDResponse(
                monTonDong.getMaMonTonDong(),
                monTonDong.getTenMonTon(),
                monTonDong.getGhiChu(),
                monTonDong.getTiLe(),
                nganh.getTenNganh(),
                nganh.getNamDaotao()
        );
    }

    @Override
    public List<MonTonDong> getMaNganhAnhNamDaoTao(String maNganh, String namDaoTao) {
        return monTDRepository.findByNganhMaNganhAndNganhNamDaotao(maNganh, namDaoTao);
    }

    @Override
    public void deleteMonTD(Long id) {
        monTDRepository.deleteById(id);
    }
}
