package com.kodilla.sercive;

import com.kodilla.domain.Car;
import com.kodilla.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public Car findCarByVin(String vin) {
        return carRepository.findByVin(vin);
    }
}
