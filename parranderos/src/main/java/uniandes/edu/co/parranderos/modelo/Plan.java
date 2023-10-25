package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Plan")
public class Plan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;    

    private String nombre;
    private int descuentoHabitacion;
    
    public Plan(int id, String nombre, int descuentoHabitacion) {
        this.id = id;
        this.nombre = nombre;
        this.descuentoHabitacion = descuentoHabitacion;
    }

    public Plan() {
    }

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

    public int getDescuentoHabitacion() {
        return descuentoHabitacion;
    }

    public void setDescuentoHabitacion(int descuentoHabitacion) {
        this.descuentoHabitacion = descuentoHabitacion;
    }   
}
