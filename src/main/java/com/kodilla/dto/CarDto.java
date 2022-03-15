package com.kodilla.dto;

import com.kodilla.domain.Client;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CarDto {

    private String vin;

    private String make;

    private String model;

    private int year;

    private String engine;

    private Client client;
}
