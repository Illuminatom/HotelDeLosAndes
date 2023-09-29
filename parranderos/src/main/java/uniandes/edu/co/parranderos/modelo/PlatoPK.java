package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class PlatoPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Producto id;

    public PlatoPK()
    {super();}

    public PlatoPK(Producto id) {
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
