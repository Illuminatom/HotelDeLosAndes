package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Productos_Tienda")
public class ProductosTienda {
    @EmbeddedId
    private ProductosTiendaPK pk;

    public ProductosTienda()
    {;}

    public ProductosTienda(Producto producto_id, Tienda tienda_id) {
        this.pk = new ProductosTiendaPK(producto_id, tienda_id);
    }

    public ProductosTiendaPK getPk() {
        return pk;
    }

    public void setPk(ProductosTiendaPK pk) {
        this.pk = pk;
    }
}
