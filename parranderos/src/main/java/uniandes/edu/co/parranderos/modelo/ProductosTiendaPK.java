package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductosTiendaPK implements Serializable {
    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    @ManyToOne
    @JoinColumn(name = "Tienda_id", referencedColumnName = "id")
    private Tienda Tienda_id;

    public ProductosTiendaPK()
    {super();}

    public ProductosTiendaPK(Producto producto_id, Tienda tienda_id) {
        super();
        Producto_id = producto_id;
        Tienda_id = tienda_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public Tienda getTienda_id() {
        return Tienda_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public void setTienda_id(Tienda tienda_id) {
        Tienda_id = tienda_id;
    }
}
