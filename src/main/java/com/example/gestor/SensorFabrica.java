package com.example.gestor;

import com.example.sensorAgua.Calidad;
import com.example.sensorAgua.SensorAgua;
import com.example.sensorAgua.SensorAguaRepository;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import com.example.sensorTrafico.SensorTrafico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.Logger;

import static com.example.gestor.Estado.ACTIVO;

@Component
public class SensorFabrica {

    Logger logger = Logger.getLogger(SensorFabrica.class.getName());

    @Autowired
    private SensorAguaRepository sensorAguaRepository;

    public Sensor crearSensorAgua() {
        return new SensorAgua(ACTIVO, "agua", Calidad.MEDIA, false, false);
    }
    public Sensor crearSensorTrafico() {
        return new SensorTrafico(ACTIVO, "trafico", false);
    }
    public Sensor crearSensorElectricidad() {
        return new SensorElectricidad(ACTIVO, "luz", 0);
    }
    public Sensor crearSensorResiduos() {
        return new SensorResiduos(ACTIVO, "residuos", false);
    }
}

