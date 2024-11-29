package com.example.gestor;

import com.example.sensorTrafico.SensorTrafico;
import org.springframework.stereotype.Component;

import static com.example.gestor.Estado.ACTIVO;

@Component
public class SensorFabrica {
    private final GestionSensores gestionSensores;

    public SensorFabrica(GestionSensores gestionSensores) {
        this.gestionSensores = gestionSensores;
    }

    public Sensor crearSensor(Sensor sensor) {
       if (sensor.tipo.equalsIgnoreCase("trafico")) {
           return new SensorTrafico(ACTIVO, sensor.tipo, false);
       } else if (sensor.tipo.equalsIgnoreCase("agua")) {

       } else if (sensor.tipo.equalsIgnoreCase("luz")) {

       } else {
           return null;
       }
    }
}
