package com.example.gestor;

import com.example.sensorAgua.Calidad;
import com.example.sensorAgua.SensorAgua;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import com.example.sensorTrafico.SensorTrafico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.example.gestor.Estado.ACTIVO;

@Component
public class SensorFabrica {

    public Sensor crearSensor(Sensor sensor) { //corregir logica
        Reloj reloj = new Reloj();

       if (sensor.tipo.equalsIgnoreCase("trafico")) {
           return new SensorTrafico(ACTIVO, sensor.tipo, reloj,  false);
       } else if (sensor.tipo.equalsIgnoreCase("agua")) {
            return new SensorAgua(ACTIVO, sensor.tipo, Calidad.MEDIA,reloj, false);
       } else if (sensor.tipo.equalsIgnoreCase("luz")) {
           return new SensorElectricidad(ACTIVO, sensor.tipo, reloj, 0);
       } else if (sensor.tipo.equalsIgnoreCase("residuos")) {
              return new SensorResiduos(ACTIVO, sensor.tipo, reloj, false);
       }
         return null;
    }
}
