package com.example.sensorTrafico;

import com.example.sensorElectricidad.SensorElectricidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SensorTraficoRepository extends JpaRepository<SensorTrafico, Long> {

    @Override
    Optional<SensorTrafico> findById(Long aLong);
}
