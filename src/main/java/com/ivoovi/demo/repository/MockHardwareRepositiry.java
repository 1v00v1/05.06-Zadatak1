package com.ivoovi.demo.repository;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.domain.Type;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Repository
public class MockHardwareRepositiry implements HardwareRepository{
    private static List<Hardware> hardwareList;

    static {

        hardwareList = new ArrayList<>();

        Hardware h1 = new Hardware(1,"7800X3D","2233",522.00, Type.CPU,22);
        Hardware h2 = new Hardware(2,"RX7900gre","2213",700.00, Type.GPU,10);

        hardwareList.add(h1);
        hardwareList.add(h2);

    }
    @Override
    public List<Hardware> getAllHardware() {
        return hardwareList;
    }

    @Override
    public List<Hardware> getHardwareBySifra(String sifra) {
        return hardwareList.stream()
                .filter(h -> Objects.equals(h.getSifra() , sifra)).findAny().stream().toList();
    }

    @Override
    public Hardware saveNewHardware(Hardware hardware) {
        Integer generatedId = hardwareList.size()+1;
        hardware.setId(generatedId);
        hardwareList.add(hardware);
        return hardware;
    }

    @Override
    public Optional<Hardware> updateHardware(Hardware hardwareToUpdate, Integer id) {
        Optional<Hardware> storedHardwareOptional =hardwareList.stream().filter(h -> h.getId().equals(id)).findFirst();

        if(storedHardwareOptional.isPresent()){
            Hardware storedHardware = storedHardwareOptional.get();
            storedHardware.setId(hardwareToUpdate.getId());
            storedHardware.setKolicina(hardwareToUpdate.getKolicina());
            storedHardware.setCijena(hardwareToUpdate.getCijena());
            storedHardware.setSifra(hardwareToUpdate.getSifra());
            storedHardware.setNaziv(hardwareToUpdate.getNaziv());
            storedHardware.setType(hardwareToUpdate.getType());
            return Optional.of(storedHardware);
        }

        return Optional.empty();
    }

    @Override
    public boolean deleteHardware(Integer id) {
        return hardwareList.removeIf(h -> h.getId().equals(id));
    }

    @Override
    public boolean hardwareByIdExists(Integer id) {
        return hardwareList.stream().anyMatch(h ->h.getId().equals(id));
    }
}
