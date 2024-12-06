package com.example.gestor;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

@Embeddable
public class Reloj {

    private long tiempo;
    private boolean ejecutando;

    public Reloj() {
        this.tiempo = 0;
        this.ejecutando = true;
    }

    public void avanzarTiempo() {
        while (ejecutando && tiempo < 1000) { //16 minutos
            tiempo++;
        }try {
            Thread.sleep(1000000);
        } catch (InterruptedException e) {
           Thread.currentThread().interrupt();
        }
    }

    public void iniciarTiempo(){
        this.tiempo = 0;
        this.ejecutando = true;
        avanzarTiempo();
    }

    public void detenerTiempo(){
        this.ejecutando = false;
    }

    public long getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
}
