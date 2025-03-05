package com.bctt.controller;

import com.bctt.dto.request.CTDTRequest;
import com.bctt.model.CTDT;
import com.bctt.service.CTDTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class CTDTController {
    @Autowired
    private CTDTService ctdtService;

    @PostMapping("/createCTDT")
    CTDT createCTDT(@RequestBody CTDTRequest ctdtRequest) {
        return ctdtService.createCTDT(ctdtRequest);
    }

    @GetMapping("/listCTDT")
    List<CTDT> getCTDTList() {
        return ctdtService.getAllCTDTs();
    }

    @GetMapping("/getCTDTId/{IdCTDT}")
    CTDT getUserById(@PathVariable("IdCTDT") String IdCTDT) {
        return ctdtService.getCTDT(IdCTDT);
    }

    @PutMapping("/updateCTDT/{IdCTDT}")
    CTDT updateCTDT(@RequestBody CTDTRequest ctdtRequest,@PathVariable String IdCTDT) {
        return ctdtService.updateCTDT(IdCTDT, ctdtRequest);
    }

    @DeleteMapping("/deleteCTDT/{IdCTDT}")
    String deleteCTDT(@PathVariable("IdCTDT") String IdCTDT) {
        ctdtService.deleteCTDT(IdCTDT);
        return "User has been deleted";
    }
}
