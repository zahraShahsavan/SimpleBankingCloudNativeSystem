package com.example.ui.model;

import lombok.Data;

@Data
public class ECustomer {

    private long cif;

    private String name;

    private long nationalCode;

    private int age;

    public ECustomer(String name, long nationalCode, int age) {
        this.name = name;
        this.nationalCode = nationalCode;
        this.age = age;
    }

    public ECustomer() {
    }
}
