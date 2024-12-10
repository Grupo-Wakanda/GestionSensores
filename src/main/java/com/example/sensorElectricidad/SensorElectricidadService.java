package com.example.sensorElectricidad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorElectricidadService {

    @Autowired
    private SensorElectricidadRepository sensorElectricidadRepository;

    public void avisarPerdidas() {
        List<SensorElectricidad> sensorElectricidad = sensorElectricidadRepository.findAll();
        for (SensorElectricidad sensor : sensorElectricidad) {
            if (sensor.estaEncendido()) {
                sensor.setPerdidas(simularPerdidas());
                System.out.println("Perdidas detectadas con una estimacion de: " + sensor.getPerdidas()
                        + " en el sensor Nº: " + sensor.getId());
                sensorElectricidadRepository.save(sensor); //esto guarda las perdidas, hay que crear
                // una tabla relacional para el valor total por id de sensor
            } else {
                System.out.println("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public long simularPerdidas(){
        //randomizar el valor de las perdidas /kWh
        int valorRnd = (int) (Math.random() * 1000);
        return valorRnd; //perdidas
    }
}
