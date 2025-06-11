package com.ivoovi.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hardware {
    private Integer id;
    private String naziv;
    private String šifra;
    private Double cijena;
    private Type type;
    private Integer količina;
}
