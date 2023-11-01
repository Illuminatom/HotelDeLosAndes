package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;


import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ClienteConsumeProductoPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "ReservaHotel_id", referencedColumnName = "id")
    private ReservaHotel ReservaHotel_id;

    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    public ClienteConsumeProductoPK(ReservaHotel reservaHotel_id, Producto producto_id) {
        super();
        ReservaHotel_id = reservaHotel_id;
        Producto_id = producto_id;
    }

    public ClienteConsumeProductoPK()
    {super();}

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public ReservaHotel getReservaHotel_id() {
        return ReservaHotel_id;
    }

    public void setReservaHotel_id(ReservaHotel reservaHotel_id) {
        ReservaHotel_id = reservaHotel_id;
    }   
}
