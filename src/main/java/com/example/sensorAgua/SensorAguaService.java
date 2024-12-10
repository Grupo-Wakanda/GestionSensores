package com.example.sensorAgua;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class SensorAguaService {

    Logger logger = Logger.getLogger(SensorAguaService.class.getName());

    @Autowired
    private SensorAguaRepository sensorAguaRepository;

    public void mandarAvisoFuga() {
        List<SensorAgua> sensores = sensorAguaRepository.findAll();
        for (SensorAgua sensorAgua : sensores) {
            if (sensorAgua.estaEncendido() ) { //poner como la otra condicion metodos de random
                logger.info("Fuga detectada en el sensor Nº: " + sensorAgua.getId());
                sensorAgua.fuga();//se le debe asociar la fuga al id del sensor
                sensorAguaRepository.save(sensorAgua); // en la linea siguiente iria un thread.sleep para simular la reparacion
                simularReparacion(sensorAgua);
            } else {
                logger.warning("El sensor Nº: " + sensorAgua.getId() + " está apagado, no se puede obtener valores");
            }
        }
    }

    public void mandarAvisoCalidad() {
        List<SensorAgua> sensores = sensorAguaRepository.findAll();
        for (SensorAgua sensorAgua : sensores) {
            if (sensorAgua.estaEncendido()) {
                logger.info(simularCalidad() +" detectada en el sensor Nº: " + sensorAgua.getId());
                sensorAguaRepository.save(sensorAgua); // Guarda los cambios
            } else {
                logger.warning("El sensor Nº: " + sensorAgua.getId() + " está apagado, no se puede obtener valores");
            }
        }
    }

    //estos dos metodo realmente deberian estar en el servicio de agua
    public void simularReparacion(SensorAgua sensorAgua) {
            logger.info("Reparando fuga en el sensor Nº: " + sensorAgua.getId());
            sensorAgua.noTieneFuga();
            sensorAguaRepository.save(sensorAgua);
    }

    public String simularCalidad() {
        //metodo para randomizar el tipo de calidad del agua
        Calidad calidad = Calidad.values()[(int) (Math.random() * Calidad.values().length)];
        return "Calidad del agua: " + calidad;
    }
}
