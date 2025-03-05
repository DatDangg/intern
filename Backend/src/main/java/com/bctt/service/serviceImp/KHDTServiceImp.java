package com.bctt.service.serviceImp;

import com.bctt.dto.request.KHDTRequest;
import com.bctt.model.KHDT;
import com.bctt.repository.KHDTRepository;
import com.bctt.service.KHDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KHDTServiceImp implements KHDTService {
    @Autowired
    KHDTRepository khdtRepository;

    @Override
    public KHDT createKHDT(KHDTRequest khdt) {
        KHDT khdt1 = new KHDT();
        khdt1.setNamHoc(khdt.getNamHoc());
        khdt1.setKiHoc(khdt.getKiHoc());
        khdt1.setNhomHoc(khdt.getNhomHoc());
        khdt1.setThoiGianBD(khdt.getThoiGianBD());
        khdt1.setThoiGianKT(khdt.getThoiGianKT());
        return khdtRepository.save(khdt1);
    }

    @Override
    public KHDT updateKHDT(Long id, KHDTRequest khdt) {
        KHDT khdt1 = getKHDT(id);
        khdt1.setNamHoc(khdt.getNamHoc());
        khdt1.setKiHoc(khdt.getKiHoc());
        khdt1.setNhomHoc(khdt.getNhomHoc());
        khdt1.setThoiGianBD(khdt.getThoiGianBD());
        khdt1.setThoiGianKT(khdt.getThoiGianKT());
        return khdtRepository.save(khdt1);
    }

    @Override
    public KHDT getKHDT(Long id) {
        return khdtRepository.findById(id).orElseThrow();
    }

    @Override
    public List<KHDT> getNhomHocAndNamHoc(String nhomHoc, String namHoc) {
        return khdtRepository.findByNhomHocAndNamHoc(nhomHoc, namHoc);
    }

    @Override
    public void deleteKHDT(Long id) {
        khdtRepository.deleteById(id);
    }
}
