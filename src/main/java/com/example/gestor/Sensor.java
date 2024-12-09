package com.example.gestor;
import jakarta.persistence.*;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Estado estado;
    public String tipo;
    public Reloj reloj;

    public Sensor(Estado estado, String tipo) {
        this.estado = estado;
        this.tipo = tipo;
        this.reloj = new Reloj();
    }

    public Sensor() {
    }

    public void apagar(){
        if (this.estado == Estado.ACTIVO) {
            this.estado = Estado.INACTIVO;
            reloj.detenerTiempo();
            System.out.println("Apagando sensor de" + getTipo());
        }
    }

    public void encender(){
        if (this.estado == Estado.INACTIVO) {
            this.estado = Estado.ACTIVO;
            new Thread(reloj::iniciarTiempo).start(); //    reloj en un hilo
            System.out.println("Encendiendo sensor de" + getTipo());

        }
    }

    public boolean estaEncendido(){
      return this.estado == Estado.ACTIVO;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
