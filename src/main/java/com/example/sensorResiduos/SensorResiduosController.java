package com.example.sensorResiduos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorResiduos")
@Controller
public class SensorResiduosController {

    @Autowired
    private SensorResiduosService sensorResiduosService;

    @RequestMapping("/mandarAvisoRecoleccion")
    public void mandarAvisoRecoleccion(){
        sensorResiduosService.avisarRecoleccion();
    }
}
