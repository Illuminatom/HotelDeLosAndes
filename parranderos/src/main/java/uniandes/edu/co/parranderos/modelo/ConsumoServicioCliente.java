package uniandes.edu.co.parranderos.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Consumo_Servicio_Cliente")
public class ConsumoServicioCliente {

    @EmbeddedId
    private ConsumoServicioClientePK pk;

    private String descripcion;
    private int costo;

    public ConsumoServicioCliente(ReservaHotel ReservaHotel_id, ServicioBasico ServicioBasico_id, Date fecha, String descripcion, int costo) {
        this.pk = new ConsumoServicioClientePK(ReservaHotel_id, ServicioBasico_id, fecha);
        this.descripcion = descripcion;
        this.costo = costo;
    }

    public ConsumoServicioClientePK getPk() {
        return pk;
    }

    public void setPk(ConsumoServicioClientePK pk) {
        this.pk = pk;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }    
}
