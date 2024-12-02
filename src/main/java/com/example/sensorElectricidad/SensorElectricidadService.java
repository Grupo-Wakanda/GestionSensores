package com.example.sensorElectricidad;

import com.example.exceptions.SensorNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class SensorElectricidadService {

    private final SensorElectricidadRepository sensorElectricidadRepository;

    public SensorElectricidadService(SensorElectricidadRepository sensorElectricidadRepository) {
        this.sensorElectricidadRepository = sensorElectricidadRepository;
    }

    public void avisarPerdidas(Long sensorId) {
        SensorElectricidad sensorElectricidad = sensorElectricidadRepository
                .findById(sensorId).orElseThrow(() -> new SensorNotFoundException(sensorId));
        System.out.println("Perdidas detectadas con una estimacion de: " + sensorElectricidad.getPerdidas() //aqui realmente iria el metodo del repo
                + " en el sensor Nº: " + sensorElectricidad.getId());
    }
}
