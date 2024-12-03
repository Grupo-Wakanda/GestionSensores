package com.example.sensorElectricidad;

import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorElectricidad extends Sensor {

    @Column(name = "perdidas")
    public long perdidas;

    public SensorElectricidad(Estado estado, String tipo, long perdidas) {
        super(estado, tipo);
        this.perdidas = perdidas;
    }

    public SensorElectricidad() {
        super();
    }

    @Override
    public void apagar() {
        if (this.estado == Estado.ACTIVO) {
            this.estado = Estado.INACTIVO;
            System.out.println("Apagando sensor de electricidad");
        }
    }

    @Override
    public void encender() {
        if (this.estado == Estado.INACTIVO) {
            this.estado = Estado.ACTIVO;
            System.out.println("Encendiendo sensor de electricidad");
        }
    }

    @Override
    public boolean estaEncendido() {
        if (getEstado().equals(Estado.ACTIVO)){
            return true;
        } else {
            return false;
        }
    }

    public String getTipo() {
        return "electricidad";
    }

    public long getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(long perdidas) {
        this.perdidas = perdidas;
    }
}
