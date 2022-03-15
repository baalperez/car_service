package com.kodilla.repository;

import com.kodilla.domain.Repair;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RepairRepository extends CrudRepository<Repair, Long> {

    @Override
    List<Repair> findAll();
}
