package com.bctt.controller;


import com.bctt.dto.reponse.MonTDResponse;
import com.bctt.dto.request.MonTDRequest;
import com.bctt.model.MonTonDong;
import com.bctt.service.MonTDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MonTDController {
    @Autowired
    private MonTDService monTDService;

    @PostMapping("/createMonTD")
    MonTDResponse createMonTD(@RequestBody MonTDRequest monTDRequest) {
        return monTDService.createMonTD(monTDRequest);
    }

    @PutMapping("/updateMonTD/{Id}")
    MonTDResponse updateMonTD(@PathVariable Long Id, @RequestBody MonTDRequest monTDRequest) {
        return monTDService.updateMonTD(Id, monTDRequest);
    }

    @DeleteMapping("/deleteMonTD/{Id}")
    String deleteMonTT(@PathVariable Long Id){
        monTDService.deleteMonTD(Id);
        return "MonTD has been deleted";
    }

    @GetMapping("/AllMonTD/{maNganh}/{namDaoTao}")List<MonTonDong> getAllMonTD(@PathVariable String maNganh, @PathVariable String namDaoTao){    return monTDService.getMaNganhAnhNamDaoTao(maNganh,namDaoTao);}
}
