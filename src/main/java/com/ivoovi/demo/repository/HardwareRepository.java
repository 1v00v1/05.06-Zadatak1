package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> getAllHardware();
    List<Hardware> getHardwareBySifra(String sifra);
    Hardware saveNewHardware(Hardware hardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate , Integer id);
    boolean deleteHardware(Integer id);
    boolean hardwareByIdExists(Integer id);
}
