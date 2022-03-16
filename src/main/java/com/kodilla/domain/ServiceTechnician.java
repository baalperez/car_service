package com.kodilla.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "SERVICE_TECHNICIANS")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceTechnician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private BigDecimal manHourRate;

    @OneToMany(
            targetEntity = Repair.class,
            mappedBy = "serviceTechnician",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Repair> repairList = new ArrayList<>();

    public ServiceTechnician(Long id, String name, BigDecimal manHourRate) {
        this.id = id;
        this.name = name;
        this.manHourRate = manHourRate;
    }
}
