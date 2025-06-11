package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface HardwareRepository {

    List<Hardware> getAllHardware();
    Optional<Hardware> getHardwareBySifra(String sifra);
    Integer saveNewHardware(Hardware hardware);
    Optional<Hardware> updateHardware(Hardware hardwareToUpdate , Integer id);
    boolean deleteHardware(Integer id);

}
