package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.MonTTResponse;
import com.bctt.dto.request.MonTTRequest;
import com.bctt.model.MonThayThe;
import com.bctt.model.Monhoc;
import com.bctt.repository.MonTTRepository;
import com.bctt.repository.MonhocRepository;
import com.bctt.service.MonTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MonTTServiceImp implements MonTTService {
    @Autowired
    private MonTTRepository monTTRepository;
    @Autowired
    private MonhocRepository monhocRepository;
    @Override
    public MonTTResponse createMonTT(MonTTRequest monTTRequest) {
        Monhoc monhoc = monhocRepository.findById(monTTRequest.getMaMonHoc()).orElseThrow();
        MonThayThe monThayThe = new MonThayThe();
        monThayThe.setMaMonThayThe(monTTRequest.getMaMonThayThe());
        monThayThe.setTenMonThayThe(monTTRequest.getTenMonThayThe());
        monThayThe.setSoTinChiTT(monThayThe.getSoTinChiTT());
        monThayThe.setTrangThai(monTTRequest.getTrangThai());
        monThayThe.setMonhoc(monhoc);
        monTTRepository.save(monThayThe);
        return new MonTTResponse(
                monThayThe.getMaMonThayThe(),
                monThayThe.getTenMonThayThe(),
                monThayThe.getSoTinChiTT(),
                monThayThe.getTrangThai(),
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                monhoc.getSoTinChi()
        );
    }

    @Override
    public List<MonTTResponse> getMonTTByMonHoc(String maMonHoc) {
        List<MonThayThe> monThayThes = monTTRepository.findAllByMonhoc(maMonHoc);
        return monThayThes.stream().map(monThayThe -> new MonTTResponse(
                monThayThe.getMaMonThayThe(),
                monThayThe.getTenMonThayThe(),
                monThayThe.getSoTinChiTT(),
                monThayThe.getTrangThai(),
                monThayThe.getMonhoc().getMaMonHoc(),
                monThayThe.getMonhoc().getTenMonHoc(),
                monThayThe.getMonhoc().getSoTinChi()
        )).collect(Collectors.toList());
    }

    @Override
    public MonTTResponse updateMonTT(Long id, MonTTRequest monTTRequest) {
        MonThayThe monThayThe = monTTRepository.findById(id).orElseThrow();
        Monhoc monhoc = monhocRepository.findById(monTTRequest.getMaMonHoc()).orElseThrow();
        monThayThe.setMaMonThayThe(monTTRequest.getMaMonThayThe());
        monThayThe.setTenMonThayThe(monTTRequest.getTenMonThayThe());
        monThayThe.setSoTinChiTT(monTTRequest.getSoTinChiTT());
        monThayThe.setTrangThai(monTTRequest.getTrangThai());
        monThayThe.setMonhoc(monhoc);
        monTTRepository.save(monThayThe);
        return new MonTTResponse(
                monThayThe.getMaMonThayThe(),
                monThayThe.getTenMonThayThe(),
                monThayThe.getSoTinChiTT(),
                monThayThe.getTrangThai(),
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                monhoc.getSoTinChi()
        );
    }

    @Override
    public void deleteMonTT(Long id) {
        monTTRepository.deleteById(id);
    }
}
