package com.example.sensorElectricidad;

import com.example.exceptions.SensorNotFoundException;
import com.example.gestor.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorElectricidadService {

    @Autowired
    private SensorElectricidadRepository sensorElectricidadRepository;

    public void avisarPerdidas() {
        List<SensorElectricidad> sensorElectricidad = sensorElectricidadRepository.findAll();
        for (SensorElectricidad sensor : sensorElectricidad) {
            if (sensor.estaEncendido()) {
                System.out.println("Perdidas detectadas con una estimacion de: " + sensor.getPerdidas()
                        + " en el sensor Nº: " + sensor.getId());
                sensorElectricidadRepository.save(sensor);
            } else {
                System.out.println("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }
}
