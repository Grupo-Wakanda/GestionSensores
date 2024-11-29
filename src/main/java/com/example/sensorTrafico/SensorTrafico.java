package com.example.sensorTrafico;

import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import org.springframework.stereotype.Component;

@Entity
@Component
public class SensorTrafico extends Sensor {

    @Column(name = "exceso")
    protected boolean exceso;

    @Column(name = "estado")
    private Estado estado;

    @Column(name = "tipo")
    private String tipo;

    public SensorTrafico(Estado estado, String tipo, boolean exceso) {
        super(estado, tipo);
        this.exceso = exceso;
    }

    public SensorTrafico() {}

    @Override
    public void apagar() {
        if (this.estado == Estado.ACTIVO) {
            this.estado = Estado.INACTIVO;
        }
    }

    @Override
    public void encender() {
        if (this.estado == Estado.INACTIVO) {
            this.estado = Estado.ACTIVO;
        }
    }
}
