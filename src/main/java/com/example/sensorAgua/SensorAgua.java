package com.example.sensorAgua;
import com.example.gestor.Estado;
import com.example.gestor.Sensor;
import jakarta.persistence.Entity;

@Entity
public class SensorAgua extends Sensor {

    public boolean detectarFuga;
    public Calidad calidad;

    public SensorAgua(Estado estado, String tipo , Calidad calidad, boolean detectarFuga) {
        super(estado, tipo);
        this.detectarFuga = detectarFuga;
        this.calidad = calidad;
    }

    public SensorAgua() {
        super();
    }

    @Override
    public void apagar() {

    }

    @Override
    public void encender() {

    }

    public boolean isDetectarFuga() {
        return detectarFuga;
    }

    public void setDetectarFuga(boolean detectarFuga) {
        this.detectarFuga = false;
    }

    public Calidad getCalidad() {
        return calidad;
    }

    public void setCalidad(Calidad calidad) {
        this.calidad = Calidad.MEDIA;
    }
}
