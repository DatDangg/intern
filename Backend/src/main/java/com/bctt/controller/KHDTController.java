package com.bctt.controller;

import com.bctt.dto.request.KHDTRequest;
import com.bctt.model.KHDT;
import com.bctt.service.KHDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/admin")
public class KHDTController {
    @Autowired
    private KHDTService khdtService;
    @PostMapping("/createKHDT")
    public KHDT createKHDT(@RequestBody KHDTRequest khdtRequest) {
        return khdtService.createKHDT(khdtRequest);
    }

    @PutMapping("/updateKHDT")
    public KHDT updateKhoa(@RequestBody KHDTRequest khdtRequest, @PathVariable Long id){
        return khdtService.updateKHDT(id,khdtRequest);
    }
    @DeleteMapping("/deleteKHDT/{maKHDT}")
    public String deleteKHDT(@PathVariable Long maKHDT){
        khdtService.deleteKHDT(maKHDT);
        return "User has been deleted";
    }

    @GetMapping("/KHDT/{nhomHoc}/{namHoc}")
    public List<KHDT> getNhomAndNam(@PathVariable String nhomHoc,@PathVariable String namHoc){
        return khdtService.getNhomHocAndNamHoc(nhomHoc,namHoc);
    }
}
