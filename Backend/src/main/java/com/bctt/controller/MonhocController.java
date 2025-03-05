package com.bctt.controller;

import com.bctt.dto.request.MonhocRequest;
import com.bctt.dto.request.UserRequest;
import com.bctt.model.Monhoc;
import com.bctt.model.User;
import com.bctt.service.MonhocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class MonhocController {
    @Autowired
    private MonhocService monhocService;

    @PostMapping("/createMonHoc")
    Monhoc createMonhoc(@RequestBody MonhocRequest monhocRequest) {
        return monhocService.createMonHoc(monhocRequest);
    }
    @GetMapping("/listMonHoc")
    List<Monhoc> getMonHocList() {
        return monhocService.getAllMonHoc();
    }

    @GetMapping("/getIdMonHoc/{maMonHoc}")
    Monhoc getUserById(@PathVariable("maMonHoc") String maMonHoc) {
        return monhocService.getMonHoc(maMonHoc);
    }

    @PutMapping("/updateMonHoc/{maMonHoc}")
    Monhoc updateMonHoc(@RequestBody MonhocRequest monhocRequest, @PathVariable String maMonHoc) {
        return monhocService.updateMonHoc(maMonHoc,monhocRequest);
    }

    @DeleteMapping("/deleteMonHoc/{maMonHoc}")
    String deleteMonHoc(@PathVariable("maMonHoc") String maMonHoc) {
        monhocService.deleteMonHoc(maMonHoc);
        return "User has been deleted";
    }
}
