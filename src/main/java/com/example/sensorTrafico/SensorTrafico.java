package com.example.sensorTrafico;

import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorTrafico extends Sensor {

    @Column(name = "exceso")
    protected boolean exceso;

    public SensorTrafico(Estado estado, String tipo, boolean exceso) {
        super(estado, tipo);
        this.exceso = exceso;
    }

    public SensorTrafico() {
        super();
    }

    @Override
    public void apagar() {
        if (this.estado == Estado.ACTIVO) {
            this.estado = Estado.INACTIVO;
            System.out.println("Apagando sensor de tráfico");
        }
    }

    @Override
    public void encender() {
        if (this.estado == Estado.INACTIVO) {
            this.estado = Estado.ACTIVO;
            System.out.println("Encendiendo sensor de tráfico");
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
}
