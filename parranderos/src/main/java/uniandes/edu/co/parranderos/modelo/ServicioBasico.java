package uniandes.edu.co.parranderos.modelo;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Servicio_Basico")
public class ServicioBasico {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private String nombre;
    private int capacidad;
    private int costo;
    private Timestamp hora_apertura;
    private Timestamp hora_cierre;
    
    public ServicioBasico(String nombre, int capacidad, Timestamp hora_apertura, Timestamp hora_cierre, int costo) { 
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.costo = costo;
        this.hora_apertura = hora_apertura;
        this.hora_cierre = hora_cierre;
    }

    public ServicioBasico(){;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Timestamp getHora_apertura() {
        return hora_apertura;
    }

    public void setHora_apertura(Timestamp hora_apertura) {
        this.hora_apertura = hora_apertura;
    }

    public Timestamp getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(Timestamp hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    
}
