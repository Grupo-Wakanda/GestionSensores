package com.example.sensorResiduos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorResiduosService {

    Logger logger = Logger.getLogger(SensorResiduosService.class.getName());

    @Autowired
    private SensorResiduosRepository sensorResiduosRepository;

    public void avisarRecoleccion() {
        List<SensorResiduos> sensorResiduos = sensorResiduosRepository.findAll();
        for (SensorResiduos sensor : sensorResiduos){
            if (sensor.estaEncendido()) {
                logger.info("Recoleccion necesaria detectada en el sensor Nº: " + sensor.getId());
                simularRecoleccion(sensor);
                sensorResiduosRepository.save(sensor);
            }else {
                logger.warning("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public void simularRecoleccion(SensorResiduos sensorResiduos){
        logger.info("Recolectando residuos..." + "\n" //hacer que espere
                + "Residuos recolectados correctamente");
        sensorResiduos.recolectado();
        sensorResiduosRepository.save(sensorResiduos);
    }
}
