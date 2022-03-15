package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTechnicianDto {

    private Long id;

    private String firstname;

    private String lastname;

    private BigDecimal manHourRate;
}
