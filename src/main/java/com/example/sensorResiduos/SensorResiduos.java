package com.example.sensorResiduos;

import com.example.gestor.Estado;
import com.example.gestor.Reloj;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorResiduos extends Sensor {

    private Reloj reloj;

    @Column(name = "esRecolectable")
    protected boolean esRecolectable;

    public SensorResiduos(Estado estado, String tipo, Reloj reloj, boolean esRecolectable) {
        super(estado, tipo);
        this.esRecolectable = esRecolectable;
    }

    public SensorResiduos() {
        super();
    }


    public String getTipo() {
        return "residuos";
    }

    public boolean isEsRecolectable() {
        return esRecolectable;
    }

    public void setEsRecolectable() {
        this.esRecolectable = true;
    }

    public boolean recolectado(){
        return !esRecolectable;
    }

    public Reloj getReloj() {
        return reloj;
    }

    public void setReloj(Reloj reloj) {
        this.reloj = reloj;
    }
}
