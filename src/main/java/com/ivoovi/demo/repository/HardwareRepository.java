package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HardwareRepository {

    List<Hardware> getAllHardware();
    List<Hardware> getHardwareBySifra(Integer sifra);


}
