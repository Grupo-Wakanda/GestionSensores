package com.example.sensorAgua;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorAguaRepoistory extends JpaRepository<SensorAgua, Long> {

}
