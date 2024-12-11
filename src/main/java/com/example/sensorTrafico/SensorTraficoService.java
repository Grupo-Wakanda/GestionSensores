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
        for (SensorTrafico sensor : sensorTrafico) {
            if (sensor.estaEncendido()) {
                logger.info("Hay conglomeracion de trafico en el sensor "+ sensor.getId());
                SensorTraficoRepository.save(sensor);
                simularTrafico(sensor);
            } else {
                logger.warning("El sensor Nº: " + sensor.getId() + " esta apagado");
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
