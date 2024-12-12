package com.example.gestor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestionSensores {

    @Autowired
    private SensorFabrica sensorFabrica;

    public void crearSensor(){
        //sensorFabrica.crearSensor();
    }
    public void eliminarSensor(){}
    public void agregarSensor(){}

}
