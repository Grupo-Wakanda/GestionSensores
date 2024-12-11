package com.example.sensorElectricidad;

import com.example.gestor.RandomizacionEventos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@RequestMapping("/sensorElectricidad")
@Controller
public class SensorElectricidadController {

    @Autowired
    private SensorElectricidadService sensorElectricidadService;

    @RequestMapping("/mandarAvisoPerdidas")
    public void mandarAvisoPerdidas(){
    }
}
