package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumoServicioClientePK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "ReservaHotel_id", referencedColumnName = "id")
    private ReservaHotel ReservaHotel_id;

    @ManyToOne
    @JoinColumn(name = "ServicioBasico_id", referencedColumnName = "id")
    private ServicioBasico ServicioBasico_id;

    private Date fecha;

    public ConsumoServicioClientePK(ReservaHotel reservaHotel_id, ServicioBasico servicioBasico_id, Date fecha) {
        super();
        ReservaHotel_id = reservaHotel_id;
        ServicioBasico_id = servicioBasico_id;
        this.fecha = fecha;
    }

    public ConsumoServicioClientePK()
    {super();}

    public ServicioBasico getServicioBasico_id() {
        return ServicioBasico_id;
    }

    public void setServicioBasico_id(ServicioBasico servicioBasico_id) {
        ServicioBasico_id = servicioBasico_id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ReservaHotel getReservaHotel_id() {
        return ReservaHotel_id;
    }

    public void setReservaHotel_id(ReservaHotel reservaHotel_id) {
        ReservaHotel_id = reservaHotel_id;
    }
}
