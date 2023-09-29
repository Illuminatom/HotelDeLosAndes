package uniandes.edu.co.parranderos.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Embeddable
public class LavanderiaPK implements Serializable{
    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    private ServicioBasico id;

    public LavanderiaPK()
    {super();}

    public ServicioBasico getId() {
        return id;
    }

    public void setId(ServicioBasico id) {
        this.id = id;
    }

    public LavanderiaPK(ServicioBasico id) {
        super();
        this.id = id;
    }
}
