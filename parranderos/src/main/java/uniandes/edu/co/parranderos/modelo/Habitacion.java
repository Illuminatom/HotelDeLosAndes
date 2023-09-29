package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Habitacion")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private Boolean disponible;

    @ManyToOne
    @JoinColumn(name = "Hotel_id", referencedColumnName = "id")
    private Hotel Hotel_id;

    @ManyToOne
    @JoinColumn(name = "TipoHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion TipoHabitacion_id;

    public Habitacion(Boolean Disponible, Hotel hotel_id, TipoHabitacion tipoHabitacion_id) {
        this.disponible = Disponible;
        this.Hotel_id = hotel_id;
        this.TipoHabitacion_id = tipoHabitacion_id;
    }

    public Habitacion()
    {;}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Hotel getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        Hotel_id = hotel_id;
    }

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }  
}

