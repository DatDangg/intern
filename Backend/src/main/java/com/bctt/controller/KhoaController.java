package com.bctt.controller;

import com.bctt.dto.request.KhoaRequest;
import com.bctt.model.Khoa;
import com.bctt.service.KhoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class KhoaController {
    @Autowired
    KhoaService khoaService;
    @PostMapping("/createKhoa")
    public Khoa createKhoa(@RequestBody KhoaRequest khoaRequest){
        return khoaService.createKoa(khoaRequest);
    }

    @PutMapping("/updateKhoa")
    public Khoa updateKhoa(@RequestBody KhoaRequest khoaRequest, @PathVariable String maKhoa){
        return khoaService.updateKhoa(maKhoa, khoaRequest);
    }
    @DeleteMapping("/deleteKhoa/{maKhoa}")
    public String deleteKhoa(@PathVariable String maKhoa){
        khoaService.deleteKhoa(maKhoa);
        return "User has been deleted";
    }

    @GetMapping("/allKhoa")
    public List<Khoa> getAllKhoa(){
        return khoaService.getAllKoas();
    }

}
