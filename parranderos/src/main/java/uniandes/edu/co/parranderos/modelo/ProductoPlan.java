package uniandes.edu.co.parranderos.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductoPlan")
public class ProductoPlan {
    @EmbeddedId
    private ProductoPlanPK pk;

    private int cantidad;
    private String descripcion;

    public ProductoPlan(Producto Producto_id, Plan Plan_id, int cantidad, String descripcion) {
        this.pk = new ProductoPlanPK(Producto_id, Plan_id);
        this.cantidad = cantidad;
        this.descripcion = descripcion;
    }
    
    public ProductoPlan()
    {;}

    public ProductoPlanPK getPk() {
        return pk;
    }

    public void setPk(ProductoPlanPK pk) {
        this.pk = pk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
