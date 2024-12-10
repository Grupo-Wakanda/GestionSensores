package com.example.sensorResiduos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorResiduosService {

    @Autowired
    private SensorResiduosRepository sensorResiduosRepository;

    public void avisarRecoleccion() {
        List<SensorResiduos> sensorResiduos = sensorResiduosRepository.findAll();
        for (SensorResiduos sensor : sensorResiduos){
            if (sensor.estaEncendido()) {
                System.out.println("Recoleccion necesaria detectada en el sensor Nº: " + sensor.getId());
                simularRecoleccion(sensor);
                sensorResiduosRepository.save(sensor);
            }else {
                System.out.println("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public void simularRecoleccion(SensorResiduos sensorResiduos){
        System.out.print("Recolectando residuos..." + "\n" //hacer que espere
                + "Residuos recolectados correctamente");
        sensorResiduos.recolectado();
        sensorResiduosRepository.save(sensorResiduos);
    }
}
