package com.example.gestor;
import com.example.sensorAgua.SensorAguaService;
import com.example.sensorElectricidad.SensorElectricidad;
import com.example.sensorElectricidad.SensorElectricidadService;
import com.example.sensorResiduos.SensorResiduos;
import com.example.sensorResiduos.SensorResiduosService;
import com.example.sensorTrafico.SensorTraficoService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RandomizacionEventos {

    private final int ciclo = 30;

    private List<Integer> ciclosCompletados = new ArrayList<>();

    private final Map<String, List<Integer>> ciclosCompletadosPorTipo = new HashMap<>();

    public void manejarCiclo(String tipoSensor, Reloj reloj, Runnable accion) {
        long tiempo = reloj.getTiempo();
        ciclosCompletadosPorTipo.putIfAbsent(tipoSensor, new ArrayList<>()); //crea una nueva lista si no existe
        if (tiempo % ciclo == 0) {
            ciclosCompletadosPorTipo.get(tipoSensor).add((int) tiempo);
            if (probabilidadEvento() > 7) {
                reloj.realizandoTarea(); //pausar el ciclo, porque cuando se calcula la probabilidad, se tiene que parar el tiempo
                ciclosCompletados.add(ciclo);
                accion.run(); //ejecutar el aviso
            }
        }
    }

    public List<Integer> obtenerCiclosCompletados(String tipoSensor) {
        return ciclosCompletadosPorTipo.getOrDefault(tipoSensor, new ArrayList<>());
    }

    public int probabilidadEvento() {
        return new Random().nextInt(10);
    }
}
