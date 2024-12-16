package com.example.gestor;

import com.example.sensorAgua.SensorAgua;
import com.example.sensorAgua.SensorAguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class GestionSensores {

    Logger logger = Logger.getLogger(GestionSensores.class.getName());

    @Autowired
    private SensorFabrica sensorFabrica;

    @Autowired
    private SensorAguaRepository sensorAguaRepository;

    public void crearSensor(){
        //sensorFabrica.crearSensor();
    }
    public void eliminarSensor(){}
    public void agregarSensor(){}

    /*
    public void buscarSensores(Sensor sensor) { //generalizar la busqueda de sensores previos
        String tipo = "";
        switch (tipo){
            case "sensoragua":

                break;
            case "sensorresiduos":

                break;
            case "sensorelectricidad":

                break;

            case "sensortrafico":
                break;
        }
    }
    public void comprobarExistencia(Sensor sensor){  //comprobar si el sensor existe
        //lea la lista de sensores
        //si no hay sensores, crearlos
        //si hay, mostrarlos
        List<SensorAgua> sensores = sensorAguaRepository.findAll();
        if (sensores == null) {
            logger.warning("No hay sensores de agua...");
            logger.info("Creando sensores de agua...");
            Sensor sensoragua = sensorFabrica.crearSensorAgua();
            sensores.add((SensorAgua) sensoragua);
            sensorAguaRepository.save((SensorAgua) sensoragua);
        }
        logger.info("Sensores de agua encontrados...");
        return sensores.get(0);
    }

     */
}
