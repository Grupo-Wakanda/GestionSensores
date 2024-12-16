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

        if (sensorResiduos.isEmpty()) {
            logger.warning("No hay sensores de residuos...");
            return;
        }

        for (SensorResiduos sensor : sensorResiduos){
           try{

               if (!sensor.estaEncendido()) {
                     logger.warning("El sensor con ID: " +  (sensorResiduos != null ? sensor.getId(): "desconocido") +
                            "Esta apagado o no es valido" );
                     continue;
               }

               logger.info("Recoleccion necesaria detectada en el sensor Nº: " + sensor.getId());
               simularRecoleccion(sensor);
               sensorResiduosRepository.save(sensor);

           }
           catch (Exception e){
               logger.severe("Error al obtener los datos del sensor con ID: "
                       + (sensorResiduos != null ? sensor.getId(): "desconocido") + " " + e.getMessage());
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
