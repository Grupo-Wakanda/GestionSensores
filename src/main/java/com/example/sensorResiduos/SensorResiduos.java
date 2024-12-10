package com.example.sensorResiduos;

import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorResiduos extends Sensor {

    @Column(name = "esRecolectable")
    public boolean esRecolectable;

    public SensorResiduos(Estado estado, String tipo, boolean esRecolectable) {
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
}
