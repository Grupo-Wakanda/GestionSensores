package com.example.sensorTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorTraficoService {

    Logger logger = Logger.getLogger(SensorTraficoService.class.getName());

    @Autowired
    private SensorTraficoRepository SensorTraficoRepository;

    public void avisarExceso() {
        List<SensorTrafico> sensorTrafico = SensorTraficoRepository.findAll();

        if (sensorTrafico.isEmpty()){
            logger.warning("No hay sensores de trafico...");
            return;
        }

        for (SensorTrafico sensor : sensorTrafico) {
            try {
                if (!sensor.estaEncendido()) {
                    logger.warning("El sensor con ID: " + (sensorTrafico != null ? sensor.getId() : "desconocido") +
                            "Esta apagado o no es valido");
                    continue;
                }

                logger.info("Hay conglomeracion de trafico en el sensor " + sensor.getId());
                SensorTraficoRepository.save(sensor);
                simularTrafico(sensor);

            }

            catch (Exception e){
                logger.severe("Error al obtener los datos del sensor con ID: "
                        + (sensorTrafico != null ? sensor.getId(): "desconocido") + " " + e.getMessage());
            }

        }
    }

    public void simularTrafico(SensorTrafico sensorTrafico) {
        logger.info("Redirigiendo trafico en el sensor " + "\n"
                + "Desviando trafico por rutas alternativas..." + "\n"
                + "Trafico redirigido correctamente");
        sensorTrafico.noHayExceso();
        SensorTraficoRepository.save(sensorTrafico);
    }
}
