package com.kodilla.mapper;

import com.kodilla.domain.ServiceTechnician;
import com.kodilla.dto.ServiceTechnicianDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceTechnicianMapper {

    public ServiceTechnician mapToServiceTechnician(final ServiceTechnicianDto serviceTechnicianDto) {
        return new ServiceTechnician(
                serviceTechnicianDto.getId(),
                serviceTechnicianDto.getName(),
                serviceTechnicianDto.getManHourRate()
        );
    }

    public ServiceTechnicianDto mapToServiceTechnicianDto(final ServiceTechnician serviceTechnician) {
        return new ServiceTechnicianDto(
                serviceTechnician.getId(),
                serviceTechnician.getName(),
                serviceTechnician.getManHourRate()
        );
    }

    public List<ServiceTechnicianDto> mapToServiceTechnicianDtoList(final List<ServiceTechnician> serviceTechnicianList) {
        return serviceTechnicianList.stream()
                .map(this::mapToServiceTechnicianDto)
                .collect(Collectors.toList());
    }
}
