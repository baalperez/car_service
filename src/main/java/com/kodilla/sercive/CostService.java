package com.kodilla.sercive;

import com.kodilla.domain.Cost;
import com.kodilla.repository.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CostService {

    private final CostRepository costRepository;

    public Cost findByTotalCost(BigDecimal totalCost) {
        return costRepository.findByTotalCost(totalCost);
    }
}
