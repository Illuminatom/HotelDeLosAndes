package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ClienteConsume")
public class ClienteConsumeProducto {
    @EmbeddedId
    private ClienteConsumeProductoPK pk;

    private int cantidad;

    public ClienteConsumeProducto(Cliente Cliente_documento, Producto Producto_id, int cantidad) {
        this.pk = new ClienteConsumeProductoPK(Cliente_documento, Producto_id);
        this.cantidad = cantidad;
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
        
    
}
