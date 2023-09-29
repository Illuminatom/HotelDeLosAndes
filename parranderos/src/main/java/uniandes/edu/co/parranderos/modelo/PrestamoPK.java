package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class PrestamoPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServicioBasico id;

    public PrestamoPK()
    {super();}

    public ServicioBasico getId() {
        return id;
    }

    public void setId(ServicioBasico id) {
        this.id = id;
    }

    public PrestamoPK(ServicioBasico id) {
        super();
        this.id = id;
    }
}
