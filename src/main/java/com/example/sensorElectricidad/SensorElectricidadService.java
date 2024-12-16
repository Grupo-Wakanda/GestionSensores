package com.example.sensorElectricidad;

import com.example.gestor.RandomizacionEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorElectricidadService {

    Logger logger = Logger.getLogger(SensorElectricidadService.class.getName());

    @Autowired
    private SensorElectricidadRepository sensorElectricidadRepository;

    @Autowired
    private RandomizacionEventos randomizacionEventos;


    public void perdidas() {
        List<SensorElectricidad> sensorElectricidad = sensorElectricidadRepository.findAll();

        if (sensorElectricidad.isEmpty()) {
        logger.warning("No hay sensores de electricidad");
            return;
        }

        for (SensorElectricidad sensor : sensorElectricidad) {
            try {
                if (!sensor.estaEncendido()) {
                    logger.warning("El sensor con ID: " +  (sensorElectricidad != null ? sensor.getId(): "desconocido") +
                            "Esta apagado o no es valido" );
                    continue;
                }

                long perdidas = simularPerdidas();
                sensor.setPerdidas(perdidas);
                logger.info("Perdidas detectadas con una estimacion de: " + sensor.getPerdidas()
                        +"Kw/h"+ " en el sensor Nº: " + sensor.getId());
                sensorElectricidadRepository.save(sensor); //esto guarda las perdidas, se debe recuperar en el repositorio de Electricidad para el SmartGrid

            }catch (Exception e){
                logger.severe("Error al obtener los datos del sensor con ID: "
                        + (sensorElectricidad != null ? sensor.getId(): "desconocido") + " " + e.getMessage());
            }
        }
    }

    public long simularPerdidas(){
      return (long) (Math.random()*1000);
    }

    public void avisoElectricidad(SensorElectricidad sensorElectricidad) {
        randomizacionEventos.manejarCiclo("luz",sensorElectricidad.getReloj(), this::perdidas);
    }
}
