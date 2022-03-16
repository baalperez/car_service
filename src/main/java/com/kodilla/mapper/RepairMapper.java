package com.kodilla.mapper;

import com.kodilla.domain.Repair;
import com.kodilla.dto.RepairDto;
import com.kodilla.repairStatus.RepairStatus;
import com.kodilla.repository.CarRepository;
import com.kodilla.repository.CostRepository;
import com.kodilla.repository.ServiceTechnicianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RepairMapper {

    private final CarRepository carRepository;

    private final ServiceTechnicianRepository serviceTechnicianRepository;

    private final CostRepository costRepository;

    public Repair mapToRepair(final RepairDto repairDto) {
        return new Repair(
                repairDto.getId(),
                repairDto.getDamageDescription(),
                RepairStatus.valueOf(repairDto.getRepairStatus()),
                repairDto.getAdmissionDate(),
                repairDto.getReleaseDate(),
                repairDto.getRepairDescription(),
                repairDto.getRepairTimeInManHours(),
                carRepository.findByVin(repairDto.getCar()),
                serviceTechnicianRepository.findByName(repairDto.getServiceTechnician()),
                costRepository.findByTotalCost(repairDto.getCost())
        );
    }

    public RepairDto mapToRepairDto(final Repair repair) {
        return new RepairDto(
                repair.getId(),
                repair.getDamageDescription(),
                repair.getRepairStatus().name(),
                repair.getAdmissionDate(),
                repair.getReleaseDate(),
                repair.getRepairDescription(),
                repair.getRepairTimeInManHours(),
                repair.getCar().getVin(),
                repair.getServiceTechnician().getName(),
                repair.getCost().getTotalCost()
        );
    }

    public List<RepairDto> mapToRepairDtoList(final List<Repair> repairList) {
        return repairList.stream()
                .map(this::mapToRepairDto)
                .collect(Collectors.toList());
    }
}
