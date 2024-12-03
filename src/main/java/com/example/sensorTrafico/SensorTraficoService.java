package com.example.sensorTrafico;

import com.example.exceptions.SensorNotFoundException;
import com.example.gestor.Estado;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorResiduos.SensorResiduos;
import org.springframework.stereotype.Service;
import com.example.sensorTrafico.SensorTraficoRepository;

@Service
public class SensorTraficoService {

    private final SensorTraficoRepository SensorTraficoRepository;

    public SensorTraficoService(SensorTraficoRepository sensorTraficoRepository) {
        this.SensorTraficoRepository = sensorTraficoRepository;
    }

    public void avisarExceso(long sensorId) {
        SensorTrafico sensorTrafico = SensorTraficoRepository
                .findById(sensorId).orElseThrow(() -> new SensorNotFoundException(sensorId));
        if (sensorTrafico.estaEncendido()) {
        System.out.println("Hay conglomeracion de trafico. Redirigiendo trafico");
            //metodo redirigir trafico del microservicio sensorTrafico
        SensorTraficoRepository.save(sensorTrafico);
        }else {
            System.out.println("El sensor Nº: " + sensorTrafico.getId() + " esta apagado");
        }
    }
}
