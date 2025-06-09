package com.ivoovi.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HardwareDTO {

    private String hardwareNaziv;
    private Integer hardwareSifra;
    private Double hardwareCijena;
    private String tipNaziv;
    private Integer hardwareKolicina;
}
