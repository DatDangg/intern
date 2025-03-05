package com.bctt.controller;

import com.bctt.dto.reponse.NganhResponse;
import com.bctt.dto.request.NganhRequest;
import com.bctt.model.Nganh;
import com.bctt.service.NganhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class NganhController {
    @Autowired
    private NganhService nganhService;

    @PostMapping("/createNganh")
    NganhResponse createMonhoccreateNganh(@RequestBody NganhRequest nganhRequest) {
        return nganhService.createNganh(nganhRequest);
    }
    @GetMapping("/listNganh")
    List<Nganh> getMonHocList() {
        return nganhService.getAllNganh();
    }

    @PutMapping("/updateNganh/{maNganh}")
    NganhResponse updateNganh(@RequestBody NganhRequest nganhRequest, @PathVariable String maNganh) {
        return nganhService.updateNganh(maNganh, nganhRequest);
    }

    @DeleteMapping("/deleteNganh/{maNganh}")
    String deleteNganh(@PathVariable("maNganh") String maNganh) {
        nganhService.deleteNganh(maNganh);
        return "Nganh has been deleted";
    }
}
