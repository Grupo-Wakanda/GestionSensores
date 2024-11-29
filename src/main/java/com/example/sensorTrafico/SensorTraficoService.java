package com.example.sensorTrafico;

import com.example.gestor.Estado;
import org.springframework.stereotype.Service;

@Service
public class SensorTraficoService {

    public void avisarExceso(SensorTrafico sensorTrafico) {
        if (sensorTrafico.getEstado() == Estado.ACTIVO) {
            System.out.println("Hay conglomeracion de trafico. Redirigiendo trafico");
            //metodo redirigir trafico
        }
    }

}
