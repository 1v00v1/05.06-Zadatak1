package com.ivoovi.demo.controler;

import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.service.HardwareService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hardware-shop")
public class HardwareController {

    private HardwareService hardwareService;

    @GetMapping
    public List<HardwareDTO> getAllHardware(){
        return hardwareService.getAllHardware().stream().toList();
    }

    @GetMapping("/{sifra}")
    public List<HardwareDTO> filterBySifra(@PathVariable String sifra){
        return hardwareService.getHardwareBySifra(Integer.valueOf(sifra)).stream().toList();
    }

}
