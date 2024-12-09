package com.example.gestor;

import com.example.sensorAgua.SensorAgua;
import com.example.sensorAgua.SensorAguaService;
import com.example.sensorTrafico.SensorTraficoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomizacionEventos {

    private final Reloj reloj = new Reloj();
    private final int ciclo = 30;
    private final long tiempo = reloj.getTiempo();

    @Autowired
    SensorAguaService sensorAguaService;

    @Autowired
    SensorTraficoService sensorTraficoService;


    public void cicloSensorTrafico() {
        if (tiempo == ciclo) {
            probabilidadEvento();
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea();
                sensorTraficoService.avisarExceso();
            }
        }
    }

    public void cicloSensorFuga() {
        if (tiempo == this.ciclo) {
            probabilidadEvento();
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea();
                sensorAguaService.mandarAvisoFuga();
            }
        }
    }

    public void cicloCalidad() {
        if (tiempo == ciclo) {
            probabilidadEvento();
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea();
                sensorAguaService.mandarAvisoCalidad();
            }
        }
    }

    public void cicloSensorPerdida() {
        if (tiempo == ciclo) {
            probabilidadEvento();
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea();

            }
        }
    }

    public void cicloRecoleccion() {
        if (tiempo == ciclo) {
            probabilidadEvento();
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea();

            }
        }
    }

    public int probabilidadEvento(){
        int valorDado = (int)Math.floor(Math.random()*10);
        return valorDado;
    }
}
