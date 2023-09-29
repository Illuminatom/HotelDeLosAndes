package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class EquiposSalaPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    @ManyToOne
    @JoinColumn(name = "Sala_id", referencedColumnName = "id")
    private Sala Sala_id;

    public EquiposSalaPK()
    {super();}

    public EquiposSalaPK(Producto producto_id, Sala sala_id) {
        super();
        Producto_id = producto_id;
        Sala_id = sala_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public Sala getSala_id() {
        return Sala_id;
    }

    public void setSala_id(Sala sala_id) {
        Sala_id = sala_id;
    }
}
