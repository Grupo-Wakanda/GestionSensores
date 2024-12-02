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

    @Override
    public void apagar() {
        if (this.estado == Estado.ACTIVO) {
            this.estado = Estado.INACTIVO;
            System.out.println("Apagando sensor de residuos");
        }
    }

    @Override
    public void encender() {
        if (this.estado == Estado.INACTIVO) {
            this.estado = Estado.ACTIVO;
            System.out.println("Encendiendo sensor de residuos");
        }
    }

    public boolean isEsRecolectable() {
        return esRecolectable;
    }

    public void setEsRecolectable() {
        this.esRecolectable = true;
    }
}
