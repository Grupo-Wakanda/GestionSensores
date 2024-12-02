package com.example.sensorAgua;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorAguaRepository extends JpaRepository<SensorAgua, Long> {
    @Override
    Optional<SensorAgua> findById(Long aLong);
}
