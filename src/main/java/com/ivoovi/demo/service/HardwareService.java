package com.ivoovi.demo.service;

import com.ivoovi.demo.dto.HardwareDTO;

import java.util.List;

public interface HardwareService {

    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareBySifra(Integer sifra);

}
