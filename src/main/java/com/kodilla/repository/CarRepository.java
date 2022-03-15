package com.kodilla.repository;

import com.kodilla.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CarRepository extends CrudRepository<Car, String> {

    @Override
    List<Car> findAll();

    Car findByVin(String vin);
}
