package com.example.gestor;

import jakarta.persistence.Embeddable;

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
            Thread.sleep(1000);
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

    public void realizandoTarea() {
        System.out.println("Pausando el reloj por 1 segundo..");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Reloj reanudado.");
    }

    public boolean isEjecutando() {
        return ejecutando;
    }

    public void setEjecutando(boolean ejecutando) {
        this.ejecutando = ejecutando;
    }

    public long getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(long tiempo) {
        this.tiempo = tiempo;
    }
}
