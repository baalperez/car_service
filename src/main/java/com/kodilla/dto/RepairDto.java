package com.kodilla.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RepairDto {

    private Long id;

    private String damageDescription;

    private String repairStatus;

    private LocalDate startOfRepair;

    private LocalDate endOfRepair;

    private String repairDescription;

    private BigDecimal repairTimeInManHours;

    private String car;

    private String serviceTechnician;

    private BigDecimal cost;
}
