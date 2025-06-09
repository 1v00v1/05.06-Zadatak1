package com.ivoovi.demo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Type {

    CPU(1, "cpu"),
    GPU(2, "gpu"),
    MBO(3, "mbo"),
    RAM(4, "ram"),
    STORAGE(5, "storage"),
    OTHER(6, "other");

    private final Integer id;
    private final String naziv;


}
