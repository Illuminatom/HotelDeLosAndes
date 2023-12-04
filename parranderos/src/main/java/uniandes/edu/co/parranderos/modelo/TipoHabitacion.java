package uniandes.edu.co.parranderos.modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "TipoHabitacion")
public class TipoHabitacion {
    
    @Id
    private ObjectId _id;
    private String id;
    private String nombre;
    private int capacidad;
    private double precioNoche;
    private ArrayList<Habitacion> habitaciones;

    public TipoHabitacion(String id, String nombre, int capacidad, double precioNoche) {
        this.id = id;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.precioNoche = precioNoche;
        this.habitaciones = new ArrayList<Habitacion>();
    }

    public TipoHabitacion(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public double getPrecioNoche() {
        return precioNoche;
    }

    public void setPrecioNoche(double precioNoche) {
        this.precioNoche = precioNoche;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}