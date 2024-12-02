package com.example.exceptions;

public class SensorNotFoundException extends RuntimeException {
    public SensorNotFoundException(Long id) {
        super("Sensor no encontrado con ID: " + id);
    }
}
