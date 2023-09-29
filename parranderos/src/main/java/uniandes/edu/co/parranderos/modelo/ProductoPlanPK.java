package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class ProductoPlanPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    @ManyToOne
    @JoinColumn(name = "Plan_id", referencedColumnName = "id")
    private Plan Plan_id;

    public ProductoPlanPK()
    {super();}

    public ProductoPlanPK(Producto producto_id, Plan plan_id) {
        super();
        Producto_id = producto_id;
        Plan_id = plan_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public Plan getPlan_id() {
        return Plan_id;
    }

    public void setPlan_id(Plan plan_id) {
        Plan_id = plan_id;
    }
}