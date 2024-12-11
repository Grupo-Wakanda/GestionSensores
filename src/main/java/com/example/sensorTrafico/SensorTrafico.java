package com.example.sensorTrafico;

import com.example.gestor.Estado;
import com.example.gestor.Reloj;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorTrafico extends Sensor {

    private Reloj reloj;

    @Column(name = "exceso")
    protected boolean exceso;

    public SensorTrafico(Estado estado, String tipo, Reloj reloj, boolean exceso) {
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

    public boolean noHayExceso() {
        return exceso = false;
    }


    public Reloj getReloj() {
        return reloj;
    }

    public void setReloj(Reloj reloj) {
        this.reloj = reloj;
    }
}
