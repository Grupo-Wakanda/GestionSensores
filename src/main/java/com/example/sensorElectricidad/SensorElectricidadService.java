package com.example.sensorElectricidad;

import org.springframework.stereotype.Service;

@Service
public class SensorElectricidadService {

    private final SensorElectricidad sensorElectricidad;

    public SensorElectricidadService(SensorElectricidad sensorElectricidad) {
        this.sensorElectricidad = sensorElectricidad;
    }

    public void avisarPerdidas() {
        System.out.println("Perdidas detectadas en el sensor Nº: " + sensorElectricidad.getId());
    }
}
