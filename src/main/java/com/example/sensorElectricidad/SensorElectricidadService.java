package com.example.sensorElectricidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorElectricidadService {

    Logger logger = Logger.getLogger(SensorElectricidadService.class.getName());

    @Autowired
    private SensorElectricidadRepository sensorElectricidadRepository;

    public void avisarPerdidas() {
        List<SensorElectricidad> sensorElectricidad = sensorElectricidadRepository.findAll();
        for (SensorElectricidad sensor : sensorElectricidad) {
            if (sensor.estaEncendido()) {
                sensor.setPerdidas(simularPerdidas());
               logger.info("Perdidas detectadas con una estimacion de: " + sensor.getPerdidas()
                        + " en el sensor Nº: " + sensor.getId());
                sensorElectricidadRepository.save(sensor); //esto guarda las perdidas, hay que crear
                // una tabla relacional para el valor total por id de sensor
            } else {
                logger.warning("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public long simularPerdidas(){
        //randomizar el valor de las perdidas /kWh
        int valorRnd = (int) (Math.random() * 1000);
        return valorRnd; //perdidas
    }
}
