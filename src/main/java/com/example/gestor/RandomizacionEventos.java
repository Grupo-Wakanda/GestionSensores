package com.example.gestor;
import com.example.sensorAgua.SensorAguaService;
import com.example.sensorTrafico.SensorTraficoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomizacionEventos {

    private final int ciclo = 30;

    @Autowired
    SensorAguaService sensorAguaService;

    @Autowired
    SensorTraficoService sensorTraficoService;

    public void manejarCiclo(Reloj reloj, Runnable accion) {
        long tiempo = reloj.getTiempo();

        if (tiempo % ciclo == 0) {
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea(); //pausar el ciclo
                accion.run();
            }
        }
    }

    public void cicloSensorTrafico(Reloj reloj) {
        manejarCiclo(reloj, () -> sensorTraficoService.avisarExceso());
    }

    public void cicloSensorFuga(Reloj reloj) {
        manejarCiclo(reloj, () -> sensorAguaService.mandarAvisoFuga());
    }

    public void cicloCalidad(Reloj reloj) {
        manejarCiclo(reloj, () -> sensorAguaService.mandarAvisoCalidad());
    }

    public int probabilidadEvento() {
        return new Random().nextInt(10);
    }
}
