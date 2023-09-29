package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ConsumoServicioClientePK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Cliente_documento", referencedColumnName = "documento")
    private Cliente Cliente_documento;

    @ManyToOne
    @JoinColumn(name = "ServicioBasico_id", referencedColumnName = "id")
    private ServicioBasico ServicioBasico_id;

    private Date fecha;

    public ConsumoServicioClientePK(Cliente cliente_documento, ServicioBasico servicioBasico_id, Date fecha) {
        super();
        Cliente_documento = cliente_documento;
        ServicioBasico_id = servicioBasico_id;
        this.fecha = fecha;
    }

    public ConsumoServicioClientePK()
    {super();}

    public Cliente getCliente_documento() {
        return Cliente_documento;
    }

    public void setCliente_documento(Cliente cliente_documento) {
        Cliente_documento = cliente_documento;
    }

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
    
    
}
