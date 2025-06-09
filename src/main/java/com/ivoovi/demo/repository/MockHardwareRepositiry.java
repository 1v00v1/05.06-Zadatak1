package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.domain.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class MockHardwareRepositiry implements HardwareRepository{
    private static List<Hardware> hardwareList;

    static {

        hardwareList = new ArrayList<>();

        Hardware h1 = new Hardware(1,"7800X3D",2233,522.00, Type.CPU,22);
        Hardware h2 = new Hardware(2,"RX7900gre",2213,700.00, Type.GPU,10);

        hardwareList.add(h1);
        hardwareList.add(h2);

    }
    @Override
    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    @Override
    public List<Hardware> getHardwareBySifra(Integer sifra) {
        return hardwareList.stream()
                .filter(h -> h.getŠifra().equals(sifra)).collect(Collectors.toList());
    }
}
