package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.CTDT_MonHoc_response;
import com.bctt.dto.request.CTDT_MonHoc_Request;
import com.bctt.model.CTDT;
import com.bctt.model.CTDT_MonHoc;
import com.bctt.model.Monhoc;
import com.bctt.model.Nganh;
import com.bctt.repository.CTDTRepository;
import com.bctt.repository.CTDT_MonHoc_Repository;
import com.bctt.repository.MonhocRepository;
import com.bctt.repository.NganhRepository;
import com.bctt.service.CTDT_MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CTDT_MonHocServiceImp implements CTDT_MonHocService {
    @Autowired
    private MonhocRepository monhocRepository;
    @Autowired
    private CTDTRepository ctdtRepository;
    @Autowired
    private CTDT_MonHoc_Repository ctdtMonHocRepository;
    @Autowired
    private NganhRepository nganhRepository;
    @Override
    public CTDT_MonHoc_response addMonHoc(CTDT_MonHoc_Request request) {
        CTDT_MonHoc monHocCtdt = new CTDT_MonHoc();
        CTDT ctdt = ctdtRepository.findById(request.getMaCTDT()).orElseThrow();
        Monhoc monhoc = monhocRepository.findById(request.getMaMonHoc()).orElseThrow();
        monHocCtdt.setCtdt(ctdt);
        monHocCtdt.setMonHoc(monhoc);
        monHocCtdt.setHeSo(request.getHeSo());
        monHocCtdt.setDieuKienTienQuyet(request.getDieuKienTienQuyet());
        monHocCtdt.setSoGio(request.getSoGio());
        monHocCtdt = ctdtMonHocRepository.save(monHocCtdt);
        return new CTDT_MonHoc_response(
                ctdt.getMaCTDT(),
                ctdt.getTenCTDT(),
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                monHocCtdt.getDieuKienTienQuyet(),
                monHocCtdt.getHeSo(),
                monhoc.getSoTinChi(),
                monHocCtdt.getSoGio()
        );
    }

    @Override
    public CTDT_MonHoc_response updateMonHoc(Long id, CTDT_MonHoc_Request request) {
        CTDT_MonHoc ctdtMonHoc = ctdtMonHocRepository.findById(id).orElseThrow();
        CTDT ctdt = ctdtRepository.findById(request.getMaCTDT()).orElseThrow();
        Monhoc monhoc = monhocRepository.findById(request.getMaMonHoc()).orElseThrow();
        ctdtMonHoc.setCtdt(ctdt);
        ctdtMonHoc.setMonHoc(monhoc);
        ctdtMonHoc.setHeSo(request.getHeSo());
        ctdtMonHoc.setSoGio(request.getSoGio());
        ctdtMonHoc.setDieuKienTienQuyet(request.getDieuKienTienQuyet());
        ctdtMonHocRepository.save(ctdtMonHoc);
        return new CTDT_MonHoc_response(
                ctdt.getMaCTDT(),
                ctdt.getTenCTDT(),
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                ctdtMonHoc.getDieuKienTienQuyet(),
                ctdtMonHoc.getHeSo(),
                monhoc.getSoTinChi(),
                ctdtMonHoc.getSoGio()
        );
    }

    @Override
    public void deleteCTDT_MonHoc(Long id) {
        ctdtMonHocRepository.deleteById(id);
    }

    @Override
    public List<CTDT_MonHoc_response> getMonHocsByCTDT(String maCTDT) {
        List<CTDT_MonHoc> ctdtMonHocs = ctdtMonHocRepository.findByCtdtMaCTDT(maCTDT);
        return ctdtMonHocs.stream().map(ctdtMonHoc -> new CTDT_MonHoc_response(
                ctdtMonHoc.getCtdt().getMaCTDT(),
                ctdtMonHoc.getCtdt().getTenCTDT(),
                ctdtMonHoc.getMonHoc().getMaMonHoc(),
                ctdtMonHoc.getMonHoc().getTenMonHoc(),
                ctdtMonHoc.getDieuKienTienQuyet(),
                ctdtMonHoc.getHeSo(),
                ctdtMonHoc.getMonHoc().getSoTinChi(),
                ctdtMonHoc.getSoGio()
        )).collect(Collectors.toList());
    }
/*
    @Override
    public List<CTDT_MonHoc_response> getMonHocsByNganhAndNamDaotao(String tenNganh, String namDaotao) {
        Nganh nganh = nganhRepository.findByTenNganh(tenNganh).orElseThrow();
        List<CTDT> ctdts = ctdtRepository.findByNganhAndNamDaotao(nganh, namDaotao);
        List<CTDT_MonHoc> ctdtMonHocs = ctdtMonHocRepository.findByCtdtIn(ctdts);
        return ctdtMonHocs.stream().map(ctdtMonHoc -> new CTDT_MonHoc_response(
                ctdtMonHoc.getCtdt().getMaCTDT(),
                ctdtMonHoc.getCtdt().getTenCTDT(),
                ctdtMonHoc.getMonHoc().getMaMonHoc(),
                ctdtMonHoc.getMonHoc().getTenMonHoc(),
                ctdtMonHoc.getDieuKienTienQuyet(),
                ctdtMonHoc.getHeSo(),
                ctdtMonHoc.getMonHoc().getSoTinChi(),
                ctdtMonHoc.getSoGio()
        )).collect(Collectors.toList());
    }

 */
}
