package com.bctt.controller;


import com.bctt.dto.reponse.MonTTResponse;
import com.bctt.dto.request.MonTTRequest;
import com.bctt.service.MonTTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MonTTController {
    @Autowired
    private MonTTService monTTService;

    @PostMapping("/createMonTT")
    MonTTResponse createMonTT(@RequestBody MonTTRequest monTTRequest) {
        return monTTService.createMonTT(monTTRequest);
    }

    @PutMapping("/updateMonTT/{Id}")
    MonTTResponse updateMonTT(@PathVariable Long Id, @RequestBody MonTTRequest request){
        return monTTService.updateMonTT(Id,request);
    }

    @DeleteMapping("/deleteMonTT/{Id}")
    String deleteMonTT(@PathVariable Long Id){
        monTTService.deleteMonTT(Id);
        return "MonTT has been deleted";
    }

    @GetMapping("/AllMonTTInMonHoc/{maMonHoc}")
    List<MonTTResponse> getMonTTByMonHoc(@PathVariable String maMonHoc){
        return monTTService.getMonTTByMonHoc(maMonHoc);
    }
}
