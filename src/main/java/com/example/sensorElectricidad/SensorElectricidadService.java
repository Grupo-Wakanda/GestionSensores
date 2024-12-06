package com.example.sensorElectricidad;

import com.example.exceptions.SensorNotFoundException;
import com.example.gestor.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorElectricidadService {

    @Autowired
    private SensorElectricidadRepository sensorElectricidadRepository;

    public void avisarPerdidas(Long sensorId) {
        SensorElectricidad sensorElectricidad = sensorElectricidadRepository
                .findById(sensorId).orElseThrow(() -> new SensorNotFoundException(sensorId));
        if (sensorElectricidad.estaEncendido()) {
        System.out.println("Perdidas detectadas con una estimacion de: " + sensorElectricidad.getPerdidas() //aqui realmente iria el metodo del repo
                + " en el sensor Nº: " + sensorElectricidad.getId());
        sensorElectricidadRepository.save(sensorElectricidad);
        }else {
            System.out.println("El sensor Nº: " + sensorElectricidad.getId() + " esta apagado");
        }
    }
}
