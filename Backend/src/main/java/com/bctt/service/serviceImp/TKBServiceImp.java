package com.bctt.service.serviceImp;

import com.bctt.dto.reponse.TKBResponse;
import com.bctt.dto.request.TKBRequest;
import com.bctt.model.Monhoc;
import com.bctt.model.ThoiKhoaBieu;
import com.bctt.repository.MonhocRepository;
import com.bctt.repository.TKBRepository;
import com.bctt.service.TKBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TKBServiceImp implements TKBService {
    @Autowired
    private TKBRepository tkbRepository;
    @Autowired
    private MonhocRepository monhocRepository;

    @Override
    public TKBResponse createTKB(TKBRequest request) {
        Monhoc monhoc = monhocRepository.findById(request.getMaMonHoc()).orElseThrow();
        ThoiKhoaBieu thoiKhoaBieu = new ThoiKhoaBieu();
        thoiKhoaBieu.setCaHoc(request.getCaHoc());
        thoiKhoaBieu.setGiangVien(request.getGiangVien());
        thoiKhoaBieu.setKiHoc(request.getKiHoc());
        thoiKhoaBieu.setNamHoc(request.getNamHoc());
        thoiKhoaBieu.setNgayHoc(request.getNgayHoc());
        thoiKhoaBieu.setPhongHoc(request.getPhongHoc());
        thoiKhoaBieu.setTenLop(request.getTenLop());
        thoiKhoaBieu.setNhomHoc(request.getNhomHoc());
        thoiKhoaBieu.setMonhoc(monhoc);
        tkbRepository.save(thoiKhoaBieu);
        return new TKBResponse(
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                thoiKhoaBieu.getNgayHoc(),
                thoiKhoaBieu.getNamHoc(),
                thoiKhoaBieu.getKiHoc(),
                thoiKhoaBieu.getCaHoc(),
                thoiKhoaBieu.getPhongHoc(),
                thoiKhoaBieu.getTenLop(),
                thoiKhoaBieu.getNhomHoc(),
                thoiKhoaBieu.getGiangVien()
        );
    }

    @Override
    public TKBResponse updateTKB(Long id, TKBRequest request) {
        ThoiKhoaBieu thoiKhoaBieu = tkbRepository.findById(id).orElseThrow();
        Monhoc monhoc = monhocRepository.findById(request.getMaMonHoc()).orElseThrow();
        thoiKhoaBieu.setCaHoc(request.getCaHoc());
        thoiKhoaBieu.setGiangVien(request.getGiangVien());
        thoiKhoaBieu.setKiHoc(request.getKiHoc());
        thoiKhoaBieu.setNamHoc(request.getNamHoc());
        thoiKhoaBieu.setNgayHoc(request.getNgayHoc());
        thoiKhoaBieu.setPhongHoc(request.getPhongHoc());
        thoiKhoaBieu.setTenLop(request.getTenLop());
        thoiKhoaBieu.setNhomHoc(request.getNhomHoc());
        thoiKhoaBieu.setMonhoc(monhoc);
        tkbRepository.save(thoiKhoaBieu);
        return new TKBResponse(
                monhoc.getMaMonHoc(),
                monhoc.getTenMonHoc(),
                thoiKhoaBieu.getNgayHoc(),
                thoiKhoaBieu.getNamHoc(),
                thoiKhoaBieu.getKiHoc(),
                thoiKhoaBieu.getCaHoc(),
                thoiKhoaBieu.getPhongHoc(),
                thoiKhoaBieu.getTenLop(),
                thoiKhoaBieu.getNhomHoc(),
                thoiKhoaBieu.getGiangVien()
        );
    }

    @Override
    public List<TKBResponse> getAllTKB(String namHoc, String kiHoc) {
        List<ThoiKhoaBieu> tkbList = tkbRepository.findThoiKhoaBieuByNamHocAndKiHoc(namHoc, kiHoc);
        return tkbList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Phương thức mới: lọc theo năm, kỳ và nhóm học
    @Override
    public List<TKBResponse> getAllTKB(String namHoc, String kiHoc, String nhomHoc) {
        List<ThoiKhoaBieu> tkbList = tkbRepository.findThoiKhoaBieuByNamHocAndKiHocAndNhomHoc(namHoc, kiHoc, nhomHoc);
        return tkbList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public List<TKBResponse> getAllTKBTheoNam(String namHoc) {
        List<ThoiKhoaBieu> tkbList =tkbRepository.findThoiKhoaBieuByNamHoc(namHoc);
        return tkbList.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private TKBResponse convertToDTO(ThoiKhoaBieu tkb) {
        return new TKBResponse(
                tkb.getMonhoc().getMaMonHoc(),
                tkb.getMonhoc().getTenMonHoc(),
                tkb.getNgayHoc(),
                tkb.getNamHoc(),
                tkb.getKiHoc(),
                tkb.getCaHoc(),
                tkb.getPhongHoc(),
                tkb.getTenLop(),
                tkb.getNhomHoc(),
                tkb.getGiangVien()
        );
    }

    @Override
    public void deleteTKB(Long id) {
        tkbRepository.deleteById(id);
    }
}
