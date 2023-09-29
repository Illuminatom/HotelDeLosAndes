package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class ServicioSpaPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Producto id;

    public ServicioSpaPK()
    {super();}

    public ServicioSpaPK(Producto id) {
        super();
        this.id = id;
    }

    public Producto getId() {
        return id;
    }

    public void setId(Producto id) {
        this.id = id;
    }
}
