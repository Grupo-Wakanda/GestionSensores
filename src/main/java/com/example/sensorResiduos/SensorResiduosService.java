package com.example.sensorResiduos;

import com.example.exceptions.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorResiduosService {

    @Autowired
    private SensorResiduosRepository sensorResiduosRepository;

    public void avisarRecoleccion(Long sensorId) {
        SensorResiduos sensorResiduos = sensorResiduosRepository
                .findById(sensorId).orElseThrow(() -> new SensorNotFoundException(sensorId));
        if (sensorResiduos.estaEncendido()) {
        sensorResiduos.setEsRecolectable(); //es recolectable
            System.out.println("Recoleccion necesaria detectada en el sensor Nº: " + sensorResiduos.getId());
        sensorResiduosRepository.save(sensorResiduos);
        }else {
            System.out.println("El sensor Nº: " + sensorResiduos.getId() + " esta apagado");
        }
    }
}
