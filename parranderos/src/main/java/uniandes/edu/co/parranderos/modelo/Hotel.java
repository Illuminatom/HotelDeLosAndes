package uniandes.edu.co.parranderos.modelo;

import java.util.ArrayList;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Hotel")
public class Hotel {

    @Id
    private ObjectId _id;
    
    private int id;

    private String nombre;
    private int numEstrellas;

    private ArrayList<Habitacion> habitaciones;

    public Hotel(int id, String nombre, int numEstrellas) {
        this.id = id;
        this.nombre = nombre;
        this.numEstrellas = numEstrellas;
        this.habitaciones = new ArrayList<Habitacion>();
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

    public int getNumEstrellas() {
        return numEstrellas;
    }

    public void setNumEstrellas(int numEstrellas) {
        this.numEstrellas = numEstrellas;
    }

    public ArrayList<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public void setHabitaciones(ArrayList<Habitacion> habitaciones) {
        this.habitaciones = habitaciones;
    }
}
