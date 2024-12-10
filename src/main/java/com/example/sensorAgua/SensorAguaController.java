package com.example.sensorAgua;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/sensorAgua")
@Controller
public class SensorAguaController {

    @Autowired
    private SensorAguaService sensorAguaService;

    @GetMapping("/mandarAvisoCalidad")
    public void mandarAvisoCalidad(){
        sensorAguaService.mandarAvisoCalidad();
    }

    @GetMapping("/mandarAvisoFuga")
    public void mandarAvisoFuga(){
        sensorAguaService.mandarAvisoFuga();
    }
}
