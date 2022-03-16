package com.kodilla.domain;

import com.kodilla.repairStatus.RepairStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Entity
@Table(name = "REPAIRS")
@AllArgsConstructor
@NoArgsConstructor
public class Repair {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String damageDescription;

    @NotNull
    private RepairStatus repairStatus;

    private LocalDate admissionDate;

    private LocalDate releaseDate;

    private String repairDescription;

    private BigDecimal repairTimeInManHours;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "service_technician_id")
    private ServiceTechnician serviceTechnician;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Cost cost;
}
