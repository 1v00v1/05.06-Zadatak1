package com.ivoovi.demo.service;

import com.ivoovi.demo.domain.Hardware;
import com.ivoovi.demo.dto.HardwareDTO;
import com.ivoovi.demo.repository.HardwareRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HardwareServiceImpl implements HardwareService {

    private HardwareRepository hardwareRepository;

    @Override
    public List<HardwareDTO> getAllHardware() {
        return hardwareRepository.getAllHardware().stream()
                .map(this::convertArticleToArticleDTO)
                .toList();
    }

    @Override
    public List<HardwareDTO> getHardwareBySifra(Integer sifra) {
        return List.of();
    }

    private HardwareDTO convertArticleToArticleDTO(Hardware hardware) {
        return new HardwareDTO(hardware.getNaziv(),
                hardware.getŠifra(),
                hardware.getCijena(),
                hardware.getType().getNaziv(),
                hardware.getKoličina());
    }
}