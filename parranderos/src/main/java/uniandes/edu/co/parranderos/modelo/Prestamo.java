package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Prestamo")
public class Prestamo {
    @EmbeddedId
    private PrestamoPK pk;

    @OneToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    public Prestamo()
    {;}

    public Prestamo(ServicioBasico id, Producto producto_id) {
        this.pk = new PrestamoPK(id);
        Producto_id = producto_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }
}
