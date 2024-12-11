package com.example.sensorElectricidad;

import com.example.gestor.Estado;
import com.example.gestor.Reloj;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class SensorElectricidad extends Sensor {

    private Reloj reloj;

    @Column(name = "perdidas")
    protected long perdidas;

    public SensorElectricidad(Estado estado, String tipo, Reloj reloj, long perdidas) {
        super(estado, tipo);
        this.perdidas = perdidas;
    }

    public SensorElectricidad() {
        super();
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

    public Reloj getReloj() {
        return reloj;
    }

    public void setReloj(Reloj reloj) {
        this.reloj = reloj;
    }
}
