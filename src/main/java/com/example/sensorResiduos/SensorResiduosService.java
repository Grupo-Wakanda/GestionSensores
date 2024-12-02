package com.example.sensorResiduos;

import com.example.exceptions.SensorNotFoundException;

public class SensorResiduosService {

    private final SensorResiduosRepository sensorResiduosRepository;

    public SensorResiduosService(SensorResiduosRepository sensorResiduosRepository) {
        this.sensorResiduosRepository = sensorResiduosRepository;
    }

    public void avisarRecoleccion(Long sensorId) {
        SensorResiduos sensorResiduos = sensorResiduosRepository
                .findById(sensorId).orElseThrow(() -> new SensorNotFoundException(sensorId));
        sensorResiduos.setEsRecolectable(); //es recolectable
        System.out.println("Recoleccion detectada en el sensor Nº: " + sensorResiduos.getId());
    }
}
