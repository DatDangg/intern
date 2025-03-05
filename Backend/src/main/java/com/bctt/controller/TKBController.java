package com.bctt.controller;

import com.bctt.dto.reponse.TKBResponse;
import com.bctt.dto.request.TKBRequest;
import com.bctt.service.TKBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class TKBController {
    @Autowired
    private TKBService tKBService;

    @PostMapping("/createTKB")
    public TKBResponse createCTDT(@RequestBody TKBRequest tKBRequest) {
        return tKBService.createTKB(tKBRequest);
    }

    // Endpoint cũ: theo năm và kỳ học
    @GetMapping("/TKB/{namHoc}/{kiHoc}")
    public List<TKBResponse> getTKB(@PathVariable String namHoc, @PathVariable String kiHoc) {
        return tKBService.getAllTKB(namHoc, kiHoc);
    }

    @GetMapping("/TKB/{namHoc}")
    public List<TKBResponse> getTKB(@PathVariable String namHoc) {
        return tKBService.getAllTKBTheoNam(namHoc);
    }
    // Endpoint mới: theo năm, kỳ học và nhóm học
    @GetMapping("/TKB/{namHoc}/{kiHoc}/{nhomHoc}")
    public List<TKBResponse> getTKBByNhomHoc(
            @PathVariable String namHoc,
            @PathVariable String kiHoc,
            @PathVariable String nhomHoc) {
        return tKBService.getAllTKB(namHoc, kiHoc, nhomHoc);
    }

    @PutMapping("/updateCTDT/{IdTKB}")
    public TKBResponse updateCTDT(@RequestBody TKBRequest tkbRequest, @PathVariable Long IdTKB) {
        return tKBService.updateTKB(IdTKB, tkbRequest);
    }

    @DeleteMapping("/deleteTKB/{IdTKB}")
    public String deleteCTDT(@PathVariable("IdTKB") Long IdTKB) {
        tKBService.deleteTKB(IdTKB);
        return "TKB has been deleted";
    }
}
