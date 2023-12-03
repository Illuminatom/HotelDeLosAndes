package uniandes.edu.co.parranderos.modelo;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Habitacion")
public class Habitacion {

    @Id
    private ObjectId _id;

    private String id;

    private boolean disponible;

    @Transient
    private String tipoHabitacionId;

    private TipoHabitacion tipoHabitacion;

    @Transient
    private String hotelId;
    
    private Hotel hotel;

    public Habitacion(String id, boolean disponible, TipoHabitacion tipoHabitacion, Hotel hotel) {
        this.id = id;
        this.disponible = disponible;
        this.tipoHabitacion = tipoHabitacion;
        this.hotel = hotel;
    }

    public Habitacion() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTipoHabitacionId() {
        return tipoHabitacionId;
    }

    public void setTipoHabitacionId(String tipoHabitacionId) {
        this.tipoHabitacionId = tipoHabitacionId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}