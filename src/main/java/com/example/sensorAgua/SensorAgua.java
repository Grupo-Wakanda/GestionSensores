    package com.example.sensorAgua;
    import com.example.gestor.Estado;
    import com.example.gestor.Sensor;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;

    @Entity
    public class SensorAgua extends Sensor {

        @Column(name = "fuga")
        protected boolean detectarFuga;

        @Column
        protected Calidad calidad;

        @Column
        protected boolean riego;

        public SensorAgua(Estado estado, String tipo , Calidad calidad, boolean detectarFuga, boolean riego) {
            super(estado, tipo);
            this.detectarFuga = detectarFuga;
            this.calidad = calidad;
            this.riego = riego;
        }

        public SensorAgua() {
            super();
        }

        public String getTipo() {
            return "agua";
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

        public boolean isRiego() {
            return riego;
        }

        public void setRiego(boolean riego) {
            this.riego = riego;
        }

        public void setCalidad(Calidad calidad) {
            this.calidad = Calidad.MEDIA; //empieza en media
            //se debe cambiar en el repo de agua
        }
    }
