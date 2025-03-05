package com.bctt.service.serviceImp;

import com.bctt.dto.request.ChianhomRequest;
import com.bctt.model.Chianhom;
import com.bctt.repository.ChianhomRepository;
import com.bctt.service.CNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CNServiceImp implements CNService {

    @Autowired
    ChianhomRepository chianhomRepository;
    @Override
    public Chianhom createChiaNhom(ChianhomRequest request) {
        Chianhom chianhom = new Chianhom();
        chianhom.setNamHoc(request.getNamHoc());
        chianhom.setNhomHoc(request.getNhomHoc());
        chianhom.setKhoa(request.getKhoa());
        chianhom.setMyKey(request.getMyKey());
        return chianhomRepository.save(chianhom);
    }

    @Override
    public Chianhom updateChiaNhom(Long id,ChianhomRequest request) {
        Chianhom chianhom = getChiaNhom(id);
        chianhom.setNamHoc(request.getNamHoc());
        chianhom.setNhomHoc(request.getNhomHoc());
        chianhom.setKhoa(request.getKhoa());
        chianhom.setMyKey(request.getMyKey());
        return chianhomRepository.save(chianhom);
    }

    @Override
    public Chianhom getChiaNhom(Long id) {
        return chianhomRepository.findById(id).orElseThrow();
    }

    @Override
    public List<Chianhom> getNamHocAndKHoa(String namHoc, String khoa) {
        return chianhomRepository.findByNamHocAndKhoa(namHoc, khoa);
    }

    @Override
    public void delete(Long id) {
        chianhomRepository.deleteById(id);
    }
}
