package com.example.gestor;

import com.example.sensorAgua.SensorAgua;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import com.example.sensorTrafico.SensorTrafico;
import org.springframework.stereotype.Component;

import static com.example.gestor.Estado.ACTIVO;

@Component
public class SensorFabrica {

    private final GestionSensores gestionSensores;

    public SensorFabrica(GestionSensores gestionSensores) {
        this.gestionSensores = gestionSensores;
    }

    public Sensor crearSensor(Sensor sensor) { //corregir logica
       if (sensor.tipo.equalsIgnoreCase("trafico")) {
           return new SensorTrafico(ACTIVO, sensor.tipo, false);
       } else if (sensor.tipo.equalsIgnoreCase("agua")) {
            return new SensorAgua(ACTIVO, sensor.tipo, null, false);
       } else if (sensor.tipo.equalsIgnoreCase("luz")) {
           return new SensorElectricidad(ACTIVO, sensor.tipo, 0);
       } else if (sensor.tipo.equalsIgnoreCase("residuos")) {
              return new SensorResiduos(ACTIVO, sensor.tipo, false);
       }
         return null;
    }
}
