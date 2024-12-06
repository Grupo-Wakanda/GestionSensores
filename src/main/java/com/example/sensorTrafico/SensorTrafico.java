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
    public String getTipo() {
        return "trafico";
    }

    public boolean isExceso() {
        return exceso;
    }

    public void setExceso() {
        this.exceso = true;
    }
}
