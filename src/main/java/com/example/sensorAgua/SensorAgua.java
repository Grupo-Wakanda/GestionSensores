    package com.example.sensorAgua;
    import com.example.gestor.Estado;
    import com.example.gestor.Sensor;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;

    @Entity
    public class SensorAgua extends Sensor {

        @Column(name = "detectarFuga")
        public boolean detectarFuga;

        @Column(name = "calidad")
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
            if (this.estado == Estado.ACTIVO) {
                this.estado = Estado.INACTIVO;
                System.out.println("Apagando sensor de agua");
            }
        }

        @Override
        public void encender() {
            if (this.estado == Estado.INACTIVO) {
                this.estado = Estado.ACTIVO;
                System.out.println("Encendiendo sensor de agua");
            }
        }

        public void detectarFuga() {
            this.detectarFuga = true;
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
            this.calidad = Calidad.MEDIA; //empieza en media
            //se debe cambiar en el repo de agua
        }
    }
