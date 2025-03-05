package com.bctt.controller;

import com.bctt.dto.reponse.CTDT_MonHoc_response;
import com.bctt.dto.request.CTDT_MonHoc_Request;
import com.bctt.service.CTDT_MonHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CTDTMonHocController {
    @Autowired
    private CTDT_MonHocService ctdtMonHocService;

    @PostMapping("/addMonVaoCTDT")
    CTDT_MonHoc_response addMonHocCTDT (@RequestBody CTDT_MonHoc_Request request){
        return ctdtMonHocService.addMonHoc(request);
    }

    @PutMapping("/updateCTDT/{Id}")
    CTDT_MonHoc_response updateCTDT(@PathVariable Long Id, @RequestBody CTDT_MonHoc_Request request){
        return ctdtMonHocService.updateMonHoc(Id,request);
    }

    @DeleteMapping("/deleteCTDT/{Id}")
    String deleteCTDT(@PathVariable Long Id){
        ctdtMonHocService.deleteCTDT_MonHoc(Id);
        return "CTDT has been deleted";
    }

    @GetMapping("/AllMonHocInCTDT/{maCTDT}")
    List<CTDT_MonHoc_response> getAllMonHocInCTDT(@PathVariable String maCTDT){
        return ctdtMonHocService.getMonHocsByCTDT(maCTDT);
    }
/*
    @GetMapping("/NganhAndNamDaoTao")
    List<CTDT_MonHoc_response> getNganhAnhCTDT(@PathVariable String tenNganh,@PathVariable String namDaotao) {
        return ctdtMonHocService.getMonHocsByNganhAndNamDaotao(tenNganh,namDaotao);
    }

 */
}
