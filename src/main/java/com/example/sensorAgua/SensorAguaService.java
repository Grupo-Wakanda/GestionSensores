package com.example.sensorAgua;

public class SensorAguaService {

    private final SensorAgua sensorAgua;

    public SensorAguaService(SensorAgua sensorAgua) {
        this.sensorAgua = sensorAgua;
    }

    public void mandarAvisoFuga(){
        System.out.println("Fuga detectada en el sensor Nº: " + sensorAgua.getId());
    }

    public void mandarAvisoCalidad(){
        System.out.println("Calidad del agua: " + sensorAgua.calidad);
    }
}
