package com.example.sensorAgua;


import com.example.exceptions.SensorNotFoundException;

public class SensorAguaService {

    private final SensorAguaRepository sensorAguaRepository;

    public SensorAguaService(SensorAguaRepository sensorAguaRepository) {
        this.sensorAguaRepository = sensorAguaRepository;
    }

    public void mandarAvisoFuga(Long sensorId) {
        SensorAgua sensorAgua = sensorAguaRepository.findById(sensorId)
                .orElseThrow(() -> new SensorNotFoundException(sensorId));
        if (sensorAgua.estaEncendido()) {
            sensorAgua.detectarFuga();
            System.out.println("Fuga detectada en el sensor Nº: " + sensorAgua.getId());
            sensorAguaRepository.save(sensorAgua);
            //modificar metodo si se quiere poner otra logica
        }else {
            System.out.println("El sensor Nº: " + sensorAgua.getId() + " esta apagado");
        }
    }

    public void mandarAvisoCalidad(Long sensorId) {
        SensorAgua sensorAgua = sensorAguaRepository.findById(sensorId)
                .orElseThrow(() -> new SensorNotFoundException(sensorId));
        if (sensorAgua.estaEncendido()){
            System.out.println("Calidad del agua de nivel " + sensorAgua.getCalidad() +
                    " detectada en el sensor Nº: " + sensorAgua.getId());
        }else {
            System.out.println("El sensor Nº: " + sensorAgua.getId() + " esta apagado");
        }
    }
}
