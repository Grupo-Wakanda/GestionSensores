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
        for (SensorElectricidad sensor : sensorElectricidad) {
            if (sensor.estaEncendido()) {
                long perdidas = simularPerdidas();
                sensor.setPerdidas(perdidas);
                logger.info("Perdidas detectadas con una estimacion de: " + sensor.getPerdidas()
                        +"Kw/h"+ " en el sensor Nº: " + sensor.getId());
                sensorElectricidadRepository.save(sensor); //esto guarda las perdidas, se debe recuperar en el repositorio de Electricidad para el SmartGrid
            } else {
                logger.warning("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public long simularPerdidas(){
      return (long) (Math.random()*1000);
    }
    //el valor tiene que ser leido en sus repositorios para que puedan utilizarlo

    public void avisoElectricidad(SensorElectricidad sensorElectricidad) {
        randomizacionEventos.manejarCiclo("luz",sensorElectricidad.getReloj(), this::perdidas);
    }
}
