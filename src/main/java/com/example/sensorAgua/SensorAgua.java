    package com.example.sensorAgua;
    import com.example.gestor.Estado;
    import com.example.gestor.Reloj;
    import com.example.gestor.Sensor;
    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;

    @Entity
    public class SensorAgua extends Sensor {

        private Reloj reloj;

        @Column(name = "detectarFuga")
        protected boolean detectarFuga;

        @Column(name = "calidad")
        protected Calidad calidad;

        public SensorAgua(Estado estado, String tipo , Calidad calidad, Reloj reloj, boolean detectarFuga) {
            super(estado, tipo);
            this.detectarFuga = detectarFuga;
            this.calidad = calidad;
        }

        public SensorAgua() {
            super();
        }
        public String getTipo() {
            return "agua";
        }

        public void fuga() {
            this.detectarFuga = true;
        }

        public boolean noTieneFuga() {
            return detectarFuga = false;
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

        public Reloj getReloj() {
            return reloj;
        }

        public void setReloj(Reloj reloj) {
            this.reloj = reloj;
        }

        public void setCalidad(Calidad calidad) {
            this.calidad = Calidad.MEDIA; //empieza en media
            //se debe cambiar en el repo de agua
        }
    }
