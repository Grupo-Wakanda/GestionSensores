package com.example.sensorAgua;


import com.example.exceptions.SensorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorAguaService {

    @Autowired
    private SensorAguaRepository sensorAguaRepository;

    public void mandarAvisoFuga() {
        List<SensorAgua> sensores = sensorAguaRepository.findAll();
        for (SensorAgua sensorAgua : sensores) {
            if (sensorAgua.estaEncendido() && sensorAgua.noTieneFuga()) {
                System.out.println("Fuga detectada en el sensor Nº: " + sensorAgua.getId());
                sensorAgua.fuga();//se le debe asociar la fuga al id del sensor
                sensorAguaRepository.save(sensorAgua); // en la linea siguiente iria un thread.sleep para simular la reparacion
                reparacionFuga(sensorAgua);
            } else {
                System.out.println("El sensor Nº: " + sensorAgua.getId() + " está apagado, no se puede obtener valores");
            }
        }
    }

    public void mandarAvisoCalidad() {
        List<SensorAgua> sensores = sensorAguaRepository.findAll();
        for (SensorAgua sensorAgua : sensores) {
            if (sensorAgua.estaEncendido()) {
                System.out.println( calidad() +"detectada en el sensor Nº: " + sensorAgua.getId());
                sensorAguaRepository.save(sensorAgua); // Guarda los cambios
            } else {
                System.out.println("El sensor Nº: " + sensorAgua.getId() + " está apagado, no se puede obtener valores");
            }
        }
    }

    //estos dos metodo realmente deberian estar en el servicio de agua
    public void reparacionFuga(SensorAgua sensorAgua) {
            System.out.println("Reparando fuga en el sensor Nº: " + sensorAgua.getId());
            //sensorAgua.repararFuga();
            sensorAguaRepository.save(sensorAgua);
    }

    public String calidad() {
        //metodo para randomizar el tipo de calidad del agua
        Calidad calidad = Calidad.values()[(int) (Math.random() * Calidad.values().length)];
        return "Calidad del agua: " + calidad;
    }
}
