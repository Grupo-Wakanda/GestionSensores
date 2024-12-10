package com.example.sensorTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SensorTraficoService {

    @Autowired
    private SensorTraficoRepository SensorTraficoRepository;

    public void avisarExceso() {
        List<SensorTrafico> sensorTrafico = SensorTraficoRepository.findAll();
        for (SensorTrafico sensor : sensorTrafico) {
                if (sensor.estaEncendido()) {
                    System.out.println("Hay conglomeracion de trafico en el sensor "+ sensor.getId());
                    SensorTraficoRepository.save(sensor);
                    simularTrafico(sensor);
                } else {
                    System.out.println("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }

    public void simularTrafico(SensorTrafico sensorTrafico) {
        System.out.print("Redirigiendo trafico en el sensor " + "\n"
                + "Desviando trafico por rutas alternativas..." + "\n"
                + "Trafico redirigido correctamente");
        sensorTrafico.noHayExceso();
        SensorTraficoRepository.save(sensorTrafico);
    }
}
