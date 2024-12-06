package com.example.sensorTrafico;

import com.example.exceptions.SensorNotFoundException;
import com.example.gestor.Estado;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import org.springframework.stereotype.Service;
import com.example.sensorTrafico.SensorTraficoRepository;

import java.util.List;

@Service
public class SensorTraficoService {

    private final SensorTraficoRepository SensorTraficoRepository;

    public SensorTraficoService(SensorTraficoRepository sensorTraficoRepository) {
        this.SensorTraficoRepository = sensorTraficoRepository;
    }

    public void avisarExceso() {
        List<SensorTrafico> sensorTrafico = SensorTraficoRepository.findAll();
        for (SensorTrafico sensor : sensorTrafico) {
                if (sensor.estaEncendido()) {
                    System.out.println("Hay conglomeracion de trafico. Redirigiendo trafico...");
                    SensorTraficoRepository.save(sensor);
                    //metodo de redirigir trafico
                } else {
                    System.out.println("El sensor Nº: " + sensor.getId() + " esta apagado");
            }
        }
    }
}
