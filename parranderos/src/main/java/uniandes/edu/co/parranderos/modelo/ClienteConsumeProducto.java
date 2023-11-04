package uniandes.edu.co.parranderos.modelo;

import java.sql.Date;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Cliente_Consume_Producto")
public class ClienteConsumeProducto {
    @EmbeddedId
    private ClienteConsumeProductoPK pk;

    private int cantidad;
    private int costo;
    private String descripcion;

    public ClienteConsumeProducto(ReservaHotel ReservaHotel_id, Producto Producto_id, int cantidad, Date fecha, int costo, String descripcion) {
        this.pk = new ClienteConsumeProductoPK(ReservaHotel_id, Producto_id, fecha);
        this.cantidad = cantidad;
        this.costo = costo;
        this.descripcion = descripcion;
    }

    public ClienteConsumeProducto()
    {super();}

    public ClienteConsumeProductoPK getPk() {
        return pk;
    }

    public void setPk(ClienteConsumeProductoPK pk) {
        this.pk = pk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
