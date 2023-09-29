package uniandes.edu.co.parranderos.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ConsumoServicioCliente")
public class ConsumoServicioCliente {

    @EmbeddedId
    private ConsumoServicioClientePK pk;

    private String descripcion;

    public ConsumoServicioCliente(Cliente Cliente_documento, ServicioBasico ServicioBasico_id, Date fecha, String descripcion ) {
        this.pk = new ConsumoServicioClientePK(Cliente_documento, ServicioBasico_id, fecha);
        this.descripcion = descripcion;
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
}
