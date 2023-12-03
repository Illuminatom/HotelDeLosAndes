package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Habitacion")
public class Habitacion {

    @Id
    private ObjectId _id;
    
    private int id;

    private int capacidad;
    private boolean disponible;

    private TipoHabitacion tipoHabitacion;
    private Hotel hotel;

    public Habitacion(int id, int capacidad, boolean disponible, TipoHabitacion tipoHabitacion, Hotel hotel) {
        this.id = id;
        this.capacidad = capacidad;
        this.disponible = disponible;
        this.tipoHabitacion = tipoHabitacion;
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public TipoHabitacion getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(TipoHabitacion tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }
}