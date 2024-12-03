package com.example.gestor;
import jakarta.persistence.*;


@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Sensor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public Estado estado;
    public String tipo;

    public Sensor(Estado estado, String tipo) {
        this.estado = estado;
        this.tipo = tipo;
    }

    public Sensor() {
    }

    public abstract void apagar();

    public abstract void encender();

    public abstract boolean estaEncendido();

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
