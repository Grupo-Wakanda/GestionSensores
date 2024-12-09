package com.example.sensorTrafico;

import com.example.exceptions.SensorNotFoundException;
import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.sensorTrafico.SensorTraficoRepository;

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
