package com.example.sensorResiduos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorResiduosRepository extends JpaRepository<SensorResiduos, Long> {

    @Override
    Optional<SensorResiduos> findById(Long aLong);
}
