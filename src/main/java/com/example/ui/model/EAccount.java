package com.example.ui.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
public class EAccount {

    private long aid;

    private long cif;

    private long amount = 0;

}
