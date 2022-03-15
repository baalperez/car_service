package com.kodilla.sercive;

import com.kodilla.domain.Repair;
import com.kodilla.repository.RepairRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RepairService {

    private final RepairRepository repairRepository;

    public List<Repair> getRepairs() {
        return repairRepository.findAll();
    }

    public Repair saveRepair(final Repair repair) {
        return repairRepository.save(repair);
    }
}
