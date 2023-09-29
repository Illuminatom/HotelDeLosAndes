package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class HotelOfrecePK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Hotel_id", referencedColumnName = "id")
    private Hotel Hotel_id;
    
    @ManyToOne
    @JoinColumn(name = "ServicioBasico_id", referencedColumnName = "id")
    private ServicioBasico ServicioBasico_id;

    public HotelOfrecePK(Hotel hotel_id, ServicioBasico servicioBasico_id) {
        super();
        Hotel_id = hotel_id;
        ServicioBasico_id = servicioBasico_id;
    }

    public HotelOfrecePK()
    {super();}

    public Hotel getHotel_id() {
        return Hotel_id;
    }

    public void setHotel_id(Hotel hotel_id) {
        Hotel_id = hotel_id;
    }

    public ServicioBasico getServicioBasico_id() {
        return ServicioBasico_id;
    }

    public void setServicioBasico_id(ServicioBasico servicioBasico_id) {
        ServicioBasico_id = servicioBasico_id;
    }
}
