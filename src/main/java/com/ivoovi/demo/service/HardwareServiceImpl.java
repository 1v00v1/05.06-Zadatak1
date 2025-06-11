package com.ivoovi.demo.service;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.domain.Type;
import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream().map(HardwareDTO::new).collect(Collectors.toList());
    }

    @Override
    public HardwareDTO getHardwareBySifra(String code) {
        return hardwareRepository.getHardwareBySifra(code).map(HardwareDTO::new).orElse(null);
    }

    private HardwareDTO convertArticleToArticleDTO(Hardware hardware) {
        return new HardwareDTO(hardware);
    }

    @Override
    public Integer saveNewHardwareDTO(HardwareDTO hardwareDTO) {
        return hardwareRepository.saveNewHardware(convertHardwareDTOToHardware(hardwareDTO));
    }

    @Override
    public Optional<HardwareDTO> updateHardware(HardwareDTO hardware, Integer id) {
        Optional<Hardware> updatedHardware =
                hardwareRepository.updateHardware(convertHardwareDTOToHardware(hardware),id);
        if(updatedHardware.isPresent()){
           return Optional.of(convertHardwareToHardwareDTO(updatedHardware.get()));

        }

        return Optional.empty();
    }

    @Override
    public boolean deleteHardware(Integer id) {
        return hardwareRepository.deleteHardware(id);
    }

    private HardwareDTO convertHardwareToHardwareDTO(Hardware hardware){

        return new HardwareDTO(hardware);
    }
    private Hardware convertHardwareDTOToHardware(HardwareDTO hardware){
        Integer latestId = hardwareRepository.getAllHardware().stream()
                .max((h1 ,h2) -> h1.getId().compareTo(h2.getId())).get().getId();

        return new Hardware(latestId+1,hardware.getNaziv(),"222", hardware.getHardwareCijena(), Type.valueOf(hardware.getTip()),100);
    }
}