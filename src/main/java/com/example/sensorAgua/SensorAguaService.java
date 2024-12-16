package com.example.sensorAgua;

import com.example.gestor.GestionSensores;
import com.example.gestor.Sensor;
import com.example.gestor.SensorFabrica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorAguaService {

    Logger logger = Logger.getLogger(SensorAguaService.class.getName());

    @Autowired
    private SensorAguaRepository sensorAguaRepository;

    public void mandarAviso(String tipoAviso) {
        List<SensorAgua> sensorAgua = sensorAguaRepository.findAll(); //se obtienen los sensores

        if (sensorAgua.isEmpty()){
            logger.warning("No hay sensores de agua");
            return;
        }

        for (SensorAgua sensor : sensorAgua) {
            try{

                if (!sensor.estaEncendido() || sensorAgua == null) {
                    logger.warning("El sensor con ID: " +  (sensorAgua != null ? sensor.getId(): "desconocido") +
                            "Esta apagado o no es valido" );
                    continue;
                }

                procesamientoSensorAgua(sensor, tipoAviso);
                sensorAguaRepository.save(sensor);

            } catch (Exception e){ //cambiar la excepcion a una propia

                logger.severe("Error al obtener los datos del sensor con ID: "
                        + (sensorAgua != null ? sensor.getId(): "desconocido") + " " + e.getMessage());

            }
        }
    }

    private void procesamientoSensorAgua(SensorAgua sensorAgua, String tipoaviso) {
        switch (tipoaviso.toLowerCase()){
            case "fuga":
                sensorAgua.setDetectarFuga(true);
                logger.info("Fuga detectada en el sensor Nº: " + sensorAgua.getId() + " se procede a reparar la fuga");
                simularReparacion(sensorAgua);
                break;
            case "calidad":
                logger.info("Calidad del agua en el sensor Nº: " + sensorAgua.getId() + " es: " + simularCalidad());
                break;
            case "riego":
                sensorAgua.setRiego(true);
                logger.info("Riego necesario en el sensor Nº: " + sensorAgua.getId());
                simularRiego(sensorAgua);
                break;
        }
    }

    //estos dos metodo realmente deberian estar en el servicio de agua pero los simulamos para que sea mas facil
    public void simularReparacion(SensorAgua sensorAgua) {
            logger.info("Reparando fuga en el sensor Nº: " + sensorAgua.getId());
            sensorAgua.setDetectarFuga(false);
            sensorAguaRepository.save(sensorAgua);
    }

    public String simularCalidad() {
        //metodo para randomizar el tipo de calidad del agua
        Calidad calidad = Calidad.values()[(int) (Math.random() * Calidad.values().length)];
        return "Calidad del agua: " + calidad;
    }

    public void simularRiego(SensorAgua sensorAgua) {
        logger.info("Regando la zona...");
        sensorAgua.setRiego(false);
        sensorAguaRepository.save(sensorAgua);
    }
}
