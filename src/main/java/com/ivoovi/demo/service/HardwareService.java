package com.ivoovi.demo.service;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;

import java.util.List;
import java.util.Optional;

public interface HardwareService {

    List<HardwareDTO> getAllHardware();
    List<HardwareDTO> getHardwareBySifra(String code);
    HardwareDTO saveNewHardwareDTO(HardwareDTO hardwareDTO);
    Optional<HardwareDTO> updateHardware(HardwareDTO hardwareDTOToUpdate , Integer id);
    boolean deleteHardware(Integer id);

}
