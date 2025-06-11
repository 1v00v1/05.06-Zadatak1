package com.ivoovi.demo.dto;

import com.ivoovi.demo.domain.Hardware;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HardwareDTO {



    private String naziv;

    private Double hardwareCijena;

    private String tip;

    public HardwareDTO(Hardware hardware) {
        this.naziv = hardware.getNaziv();
        this.hardwareCijena = hardware.getCijena();
        this.tip = hardware.getType().getNaziv();
    }

    @Override
    public String toString() {
        return "HardwareDTO{" +
                "hardwareCijena=" + hardwareCijena +
                ", naziv='" + naziv + '\'' +
                '}';
    }
}

