package com.example.sensorTrafico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorTrafico")
@Controller
public class SensorTraficoController {

    @Autowired
    private SensorTraficoService sensorTraficoService;

    @RequestMapping("/mandarAvisoExceso")
    public void mandarAvisoExceso(){
        sensorTraficoService.avisarExceso();
    }

}
