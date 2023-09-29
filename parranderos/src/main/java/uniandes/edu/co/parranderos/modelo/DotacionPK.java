package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class DotacionPK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TipoHabitacion_id", referencedColumnName = "id")
    private TipoHabitacion TipoHabitacion_id;
    
    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    public DotacionPK(TipoHabitacion tipohabitacion_id, Producto producto_id) {
        super();
        TipoHabitacion_id = tipohabitacion_id;
        Producto_id = producto_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public TipoHabitacion getTipoHabitacion_id() {
        return TipoHabitacion_id;
    }

    public void setTipoHabitacion_id(TipoHabitacion tipoHabitacion_id) {
        TipoHabitacion_id = tipoHabitacion_id;
    }    
}
