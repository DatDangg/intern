package com.bctt.controller;

import com.bctt.dto.request.ChianhomRequest;
import com.bctt.model.Chianhom;
import com.bctt.service.CNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CNController {
    @Autowired
    private CNService cnService;

    @PostMapping("/createCN")
    public Chianhom createCN(@RequestBody ChianhomRequest chianhomRequest) {
        return cnService.createChiaNhom(chianhomRequest);
    }

    @PutMapping("/updateCN")
    public Chianhom updateCN(@RequestBody ChianhomRequest chianhomRequest,@PathVariable Long id) {
        return cnService.updateChiaNhom(id, chianhomRequest);
    }

    @DeleteMapping("/deleteCN")
    public String deleteCN(@PathVariable Long id) {
        cnService.delete(id);
        return "User has been deleted";
    }

    @GetMapping("/CN/{namHoc}/{khoa}")
    public List<Chianhom> getCN(@PathVariable String namHoc, @PathVariable String khoa) {
        return cnService.getNamHocAndKHoa(namHoc,khoa);
    }
}
