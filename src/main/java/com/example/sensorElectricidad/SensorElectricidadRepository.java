package com.example.sensorElectricidad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorElectricidadRepository extends JpaRepository<SensorElectricidad, Long> {

    @Override
    Optional<SensorElectricidad> findById(Long aLong);
}
