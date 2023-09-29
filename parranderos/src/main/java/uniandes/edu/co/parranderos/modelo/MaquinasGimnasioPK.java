package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class MaquinasGimnasioPK implements Serializable{
    @ManyToOne
    @JoinColumn(name = "Producto_id", referencedColumnName = "id")
    private Producto Producto_id;

    @ManyToOne
    @JoinColumn(name = "Gimnasio_id", referencedColumnName = "id")
    private Gimnasio Gimnasio_id;

    public MaquinasGimnasioPK()
    {super();}

    public MaquinasGimnasioPK(Producto producto_id, Gimnasio gimnasio_id) {
        super();
        Producto_id = producto_id;
        Gimnasio_id = gimnasio_id;
    }

    public Producto getProducto_id() {
        return Producto_id;
    }

    public void setProducto_id(Producto producto_id) {
        Producto_id = producto_id;
    }

    public Gimnasio getGimnasio_id() {
        return Gimnasio_id;
    }

    public void setGimnasio_id(Gimnasio gimnasio_id) {
        Gimnasio_id = gimnasio_id;
    }
}
